package test.one;

import org.junit.Test;

public class Three {
    //16. String s = new String("xyz");创建了几个StringObject？是否可以继承String类?
    /*两个或一个都有可能，”xyz”对应一个对象，这个对象放在字符串常量缓冲区，常量”xyz”不管出现多少遍，都是缓冲区中的那一个。
    NewString每写一遍，就创建一个新的对象，它使用常量”xyz”对象的内容来创建出一个新String对象。如果以前就用过’xyz’，那么这里就不会创建”xyz”了，
    直接从缓冲区拿，这时创建了一个StringObject；
    但如果以前没有用过"xyz"，那么此时就会创建一个对象并放入缓冲区，这种情况它创建两个对象。
    至于String类是否继承，答案是否定的，因为String默认final修饰，是不可继承的。*/

    //17.StringBuffer  StringBuilder  String有什么区别？
    /*1、在字符串不经常发生变化的业务场景优先使用String(代码更清晰简洁)。如常量的声明，少量的字符串操作(拼接，删除等)。
      2、在单线程情况下，如有大量的字符串操作情况，应该使用StringBuilder来操作字符串。不能使用String"+"来拼接而是使用，避免产生大量无用的中间对象，耗费空间且执行效率低下（新建对象、回收对象花费大量时间）。如JSON的封装等。
      3、在多线程情况下，如有大量的字符串操作情况，应该使用StringBuffer。如HTTP参数解析和封装等。*/

    //18、下面这条语句一共创建了多少个对象：String s="a"+"b"+"c"+"d";  --创建一次对象
    @Test
    public void t(){
        String s = "a"+"b"+"c"+"d";
        System.out.println(s=="abcd");
        StringBuffer sb =new StringBuffer("ab");
        System.out.println(sb.append("cd"));

    }

    //19、try {}里有一个return语句，那么紧跟在这个try后的finally{}里的code会不会被执行，什么时候被执行，在return前还是后?
      //准确地说应该是中间 见TryTest

    //20、final, finally, finalize的区别。
    /* final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。内部类要访问局部变量，局部变量必须定义成final类型。
      finally是异常处理语句结构的一部分，表示总是执行。
      finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。但是JVM不保证此方法总被调用*/

    //21、运行时异常与一般异常有何异同？
    /*1.定义不同，运行时异常都是RuntimeException类及其子类异常，如NullPointerException、IndexOutOfBoundsException等。
       一般异常是RuntimeException以外的异常，类型上都属于Exception类及其子类。
      2.处理方法不同，运行时异常是不检查异常，程序中可以选择捕获处理，也可以不处理。对于一般异常，JAVA编译器强制要求用户必需对出现的这些异常进行catch并处理，否则程序就不能编译通过。
      3.发生原因不同，运行时异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。面对这种异常不管我们是否愿意，只能自己去写一大堆catch块去处理可能的异常。
     */

    //22、error和exception有什么区别?
      /*error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。exception表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。*/

    //23、简单说说Java中的异常处理机制的简单原理和应用。
    /*  Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：
        Error和Exception，Error表示应用程序本身无法克服和恢复的一种严重问题，程序只有奔溃了，例如，说内存溢出和线程死锁等系统问题。
        Exception表示程序还能够克服和恢复的问题，其中又分为系统异常和普通异常：
        系统异常是软件本身缺陷所导致的问题，也就是软件开发人员考虑不周所导致的问题，软件使用者无法克服和恢复这种问题，但在这种问题下还可以让软件系统继续运行或者让软件挂掉，
          例如，数组脚本越界（ArrayIndexOutOfBoundsException），空指针异常（NullPointerException）、类转换异常（ClassCastException）；
        普通异常是运行环境的变化或异常所导致的问题，是用户能够克服的问题，例如，网络断线，硬盘空间不够，发生这样的异常后，程序不应该死掉。
          java为系统异常和普通异常提供了不同的解决方案，编译器强制普通异常必须try..catch处理或用throws声明继续抛给上层调用方法处理，
          所以普通异常也称为checked异常，而系统异常可以处理也可以不处理，所以，编译器不强制用try..catch处理或用throws声明，所以系统异常也称为unchecked异常。
    * */

    //24、Java 中堆和栈有什么区别？
    /*JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享。

    栈：在函数中定义的一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，当在一段代码块定义一个变量时，Java 就在栈中为这个变量分配内存空间，
    当超过变量的作用域后，Java 会自动释放掉为该变量分配的内存空间，该内存空间可以立即被另作它用。

    堆：堆内存用来存放由 new 创建的对象和数组，在堆中分配的内存，由 Java 虚拟机的自动垃圾回收器来管理。在堆中产生了一个数组或者对象之后，
    还可以在栈中定义一个特殊的变量，让栈中的这个变量的取值等于数组或对象在堆内存中的首地址，栈中的这个变量就成了数组或对象的引用变量，
    以后就可以在程序中使用栈中的引用变量来访问堆中的数组或者对象，引用变量就相当于是为数组或者对象起的一个名称。*/

    // 25、能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象？
    // 我们可以做强制转换，但是 Java 中 int 是 32 位的，而 byte 是 8 位的，所以，如果强制转化，int 类型的高 24 位将会被丢弃，因为byte 类型的范围是从 -128 到 128。
    @Test
    public void tt(){
        int a =128;
        byte b = (byte) a;
        System.out.println(b);
    }
}
