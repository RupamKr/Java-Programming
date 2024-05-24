package strings;

public class StringManupulation {
    
    public static void main(String[] arg){

        String s1 = new String("Dog");
        String s2 = "Dog";
        // String sInterned = s1.intern();

        // System.out.println(sInterned==s1);
        /*
        Returns a canonical representation for the string object.
        A pool of strings, initially empty, is maintained privately by the class String.
        When the intern method is invoked, if the pool already contains a string equal
        to this String object as determined by the equals(Object) method,
        then the string from the pool is returned. Otherwise, this String object is
        added to the pool and a reference to this String object is returned.
        It follows that for any two strings s and t, s.intern() == t.intern()
        is true if and only if s.equals(t) is true.
         */

        if(s1==s2){
            System.out.println("1st"+"True");
        }

        if(s2.equals(s1)){
            System.out.println("True");
        } 
    }
}
