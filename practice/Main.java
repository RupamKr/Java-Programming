package practice;

public class Main {

    public static int maximumElementOfAnArray(int array[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    public static int minimumElementOfAnArray(int array[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
    
    public static void chart(int arr[]){
        int max = maximumElementOfAnArray(arr);

        for(int maxHeight = max; maxHeight>=1; maxHeight--){
            for(int i=0; i<arr.length; i++){
                if(arr[i]<maxHeight){
                    System.out.print("\t");
                }else{
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }

    public static int totalSumOfAnArray(int arr[]){
        int totalSum = 0;
        for(int x : arr){
            totalSum+=x;
        }
        return totalSum;
    }

    public static void main(String[] arg){
        int arr[] = {1,2,2};

        int numberOfPartitions = 0;
        int totalSum = totalSumOfAnArray(arr);

        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<arr.length-1; i++){
            leftSum = leftSum + arr[i];
            rightSum = totalSum - leftSum;

            int difference = Math.abs(leftSum-rightSum);
            if(difference%2==0){
                numberOfPartitions++;
            }
        }

        System.out.print(numberOfPartitions);
    }
}
