
package testing;

public class TestIntLong {
    public static void main(String[] args) {
        long hi=Long.MAX_VALUE;
        System.out.println("long max: "+hi);
        System.out.println(Long.toBinaryString(hi));
        System.out.println("casted: "+(int) hi);
        System.out.println();

        hi=Long.MIN_VALUE;
        System.out.println("long min: "+hi);
        System.out.println(Long.toBinaryString(hi));
        System.out.println("casted: "+(int) hi);
        System.out.println();

        double hello=Double.MAX_VALUE;
        System.out.println("double max: "+hello);
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(hello)));
        System.out.println("casted: "+(int) hello);
        System.out.println("casted: "+Integer.toBinaryString((int) hello));
        System.out.println();

        hello=Double.MIN_VALUE;
        System.out.println("double min: "+hello);
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(hello)));
        System.out.println("casted: "+(int) hello);
        System.out.println();


        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(1D)));
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(1D)).length());
    }
}
