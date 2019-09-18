package test.one;

public class TestStaticCybl {

        public static int staticVar = 0;

        public int instanceVar = 0;

        TestStaticCybl(){

            staticVar++;

            instanceVar++;

            System.out.println(staticVar +"--"+instanceVar);

        }
        void tt(int i){
            System.out.println(i);
        }

    }
class outer{
    int a =2;
    void a(){
        System.out.println("outer a()");
    }
    class innner{
        int b =3;
        void b(){
            System.out.println("inner b()");
        }
    }
}
