
package binary_system;

public class BinaryNumber {

    public static int maximumUnsignedValueOf(int bits) {

        int num = 0;
        for (int i = 0; i < bits; i++) {
            num = num + (int) Math.pow(2, i);
        }
        return num;
    }

    public static int maximumSignedValueOf(int bits) {
        int num = 0;
        for (int i = 0; i < bits - 1; i++) {
            num = num + (int) Math.pow(2, i);
        }
        return num;
    }

    public static int minimumSignedValueOf(int bits) {
        int num = 0;
        for (int i = 0; i < bits - 1; i++) {
            num = num + (int) Math.pow(2, i);
        }
        return -(num + 1);
    }

    public static void main(String[] args) {

        // byte byteInbyte = Byte.BYTES;
        // byte byteInShort = Short.BYTES;
        // byte byteInInt = Integer.BYTES;
        // byte byteInLong = Long.BYTES;

        // System.out.println("byteInbyte " + byteInbyte);
        // System.out.println("byteInShort " + byteInShort);
        // System.out.println("byteInInt " + byteInInt);
        // System.out.println("byteInLong " + byteInLong);

        //left shift and right shift
        

    }
}