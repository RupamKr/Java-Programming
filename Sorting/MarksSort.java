package sorting;

import java.util.Arrays;
import java.util.Comparator;

class Student {
    int id;
    String name;
    int marks[] = new int[5];

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
    }

    @Override
    public String toString() {
        return "{id=" + id + " name=" + name + " marks=" + Arrays.toString(marks) + " totalMarks=" + getTotalMarks()
                + "}\n";
    }

    public int getTotalMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
}

class StudentTotalMarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getTotalMarks() != s2.getTotalMarks()) {
            return Integer.compare(s2.getTotalMarks(), s1.getTotalMarks());
        } else if (!s1.name.equals(s2.name)) {
            return s1.name.compareTo(s2.name);
        } else {
            return Integer.compare(s1.id, s2.id);
        }
    }
}

public class MarksSort {

    public static void main(String[] args) {
        int n = SortingUtils.generateRandomNumber(9) + 1;
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {
            int id = i + 1;
            String name = SortingUtils.generateRandomString(6);
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++) {
                marks[j] = SortingUtils.generateRandomNumber(100);
            }

            arr[i] = new Student(id, name, marks);
        }

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new StudentTotalMarksComparator());

        int res[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i].id;
        }

        System.out.println(Arrays.toString(res));
    }
}
