package test.one;

import org.junit.Test;

public class TryTest {
    public static void main(String[] args) {
        System.out.println(TryTest.t());
    }
    public  static int t(){
        int i =1;
        try {
            return ++i;
        }finally {
            return  ++i;
        }
    }



    @Test
    public void tt(){
        int i =5;
        int i0=5;


        Integer i1=5;
        Integer i2 = 127;
        Integer i3=127;
        Integer i4 = new Integer(128);

        System.out.println(i==i0);
        System.out.println(i==i1);
        System.out.println(i2==i3);

    }
}
