package test.one;


import org.junit.Test;

public class One {
    //    1.测试数组
    @Test
    public void t() {
//    定义一个3行2列的数组 。。。大数组里面包含四个小数组 每个小数组里面有5个元素
        int arr[][] = {{1, 2}, {3, 4}, {5, 6}};
//        arr[0][0]=1;
//        arr[0][1]=1;
//        arr[0][2]=1;
//        arr[0][3]=1;
//        arr[0][4]=1;

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                //跳出循环
                if (x <= 1) {
                    break;
                }
                System.out.print(arr[x][y] + " ");

            }
            System.out.println();
        }
    }

    /* 2.   short s1= 1; s1 =1+1 ; short s1 = 1; s1 += 1 都有什么错？？
          由于s1+1运算时会自动提升表达式的类型，所以结果是int型，再赋值给short类型s1时，编译器将报告需要强制转换类型的错误。
          对于short s1= 1; s1 += 1;由于 +=是java语言规定的运算符，java编译器会对它进行特殊处理，因此可以正确编译。
        */
    @Test
    public void t1() {
        short s1 = 1;
        s1 = (short) (s1 + 1);//s1+1是 int类型，而s1是short 所以需要强转
    }

    /* 3.char型变量中能不能存贮一个中文汉字?为什么?

        char型变量是用来存储Unicode编码的字符的，unicode编码字符集中包含了汉字，所以，char型变量中当然可以存储汉字啦。
        不过，如果某个特殊的汉字没有被包含在unicode编码字符集中，那么，这个char型变量中就不能存储这个特殊汉字。
        补充说明：unicode编码占用两个字节，所以，char类型的变量也是占用两个字节。
            * */

//    用最有效率的方法算出2乘以8等於几
    @Test
    public void t2(){
        System.out.println(2<<3);
        System.out.println(8>>1);
    }

//   4. 使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？
    @Test
    public void t3(){
//        final int i =6;
//        i=4; //不能更改
        final StringBuffer str = new StringBuffer("panshuo");
//        str=new StringBuffer();//报错
        str.append("123");
    }

//  5.  静态变量和实例变量的区别
    /*
    *   在语法定义上的区别：静态变量前要加static关键字，而实例变量前则不加。
        在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。
        静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，静态变量就会被分配空间，静态变量就可以被使用了。
        总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。*/
    @Test
    public void t4(){
        new TestStaticCybl();
        new TestStaticCybl();
        new TestStaticCybl();
    }

//    6、是否可以从一个static方法内部发出对非static方法的调用？
       /* 不可以。因为非static方法是要与对象关联在一起的，必须创建一个对象后
        才可以在该对象上进行方法调用，而static方法调用时不需要创建对象，可以直接调用。*/

//    7.Integer与int的区别
     /*int是java提供的8种原始数据类型之一。
      Java为每个原始类型提供了封装类，Integer是java为int提供的封装类。int的默认值为0，而Integer的默认值为null，
      即Integer可以区分出未赋值和值为0的区别   */

//    8. Math.round(11.5)等於多少?Math.round(-11.5)等於多少?
    /*
    * Math类中提供了三个与取整有关的方法：ceil、floor、round，这些方法的作用与它们的英文名称的含义相对应。
    * ceil 向上取整； floor向下取整；  round +0.5 再向下取整  */
    @Test
    public void t5(){
        double f =Math.round(0.4);
        double f1=Math.ceil(0.4);
        double f2 =Math.floor(0.4);
        System.out.println(f+"--"+f1+"--"+f2);
    }

//    9.Overload和Override的区别？Overloaded的方法是否可以改变返回值的类型
    /*Overload是重载的意思，Override是覆盖的意思，也就是重写。
      重载Overload表示同一个类中可以有多个名称相同的方法，但这些方法的参数列表各不相同（即参数个数或类型不同）。
     */

//    10.abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized?
    /*abstract的method不可以是static的，因为抽象的方法是要被子类实现的，而static与子类扯不上关系！
    * native方法表示该方法要用另外一种依赖平台的编程语言实现的，不存在着被子类实现的问题，所以，它也不能是抽象的，不能与abstract混用。
    * 方法上的synchronized同步所使用的同步锁对象是this，而抽象方法上无法确定this是什么,不能与abstract混用*/

}
