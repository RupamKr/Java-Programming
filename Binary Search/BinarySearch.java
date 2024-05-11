import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {


        int array[] = {2,4,6,8,11,14,17,24,56,78};

        //code to find and an element, and return its index and position

        int key = 78;

        int indexAndPosition[] = binarySearch(array, key);
        
        if(indexAndPosition[0]==-1 && indexAndPosition[1]==-1){
            System.out.println("Key not found");
        }else{
            System.out.println("[Index:Position] "+Arrays.toString(indexAndPosition));
        }
        
    }

    private static int[] binarySearch(int[] array, int key){
        
        //this is the logic to find an element in a given array

        //Binary Search is a Searching technique to find an element in given array. This will works in sorted array only
        int beg = 0, end = array.length-1;

        int result[] = {-1,-1};

        while(beg<=end){

            int mid = (beg+end)/2;

            if(array[mid]>key){
                end = mid-1;
            }else if(array[mid]<key){
                beg = mid+1;
            }else if(array[mid]==key){
                result[0] = mid;
                result[1] = mid+1;
                break; //we have to break our loop, when the key is found
            }
        }

        //returning -1,-1 means, the key is not present in given array
        return result;
    }
}