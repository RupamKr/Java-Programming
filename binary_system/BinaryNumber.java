
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

    public static long bitMask(long n, int position) {
        return 1L << position;
    }

    public static int getBitValue(long n, int position) {
        long bit = bitMask(n, position);
        long result = n & bit;
        return result != 0 ? 1 : 0;
    }

    public static String getBinaryOf(long n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            sb.append(getBitValue(n, i));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        // byte byteInbyte = Byte.BYTES;
        // byte byteInShort = Short.BYTES;
        // byte byteInInt = Integer.BYTES;
        // byte byteInLong = Long.BYTES;
        String binary = getBinaryOf(Long.MAX_VALUE);
        long decimal = Long.parseUnsignedLong(binary, 2);
        System.out.println(binary);
        System.out.println(decimal==Long.MAX_VALUE);
    }
}