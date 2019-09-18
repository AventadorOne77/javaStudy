package test.two;

import pojo.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public  class  Nine_Thread {
    //64、什么是线程
    /*  线程是操作系统能够进行运算调度的最小单位，它被包含在进程之中，是进程中的实际运作单位。
        程序员可以通过它进行多处理器编程，你可以使用多线程对运算密集型任务提速。
        比如，如果一个线程完成一个任务要100毫秒，那么用十个线程完成改任务只需10毫秒。*/

    //65、线程和进程有什么区别？
    /*  线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。
        不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。每个线程都拥有单独的栈内存用来存储本地数据。*/

    //66、如何在java中实现线程？
    /*  两种方式：java.lang.Thread 类的实例就是一个线程但是它需要调用java.lang.Runnable接口来执行，
        由于线程类本身就是调用的Runnable接口所以你可以继承java.lang.Thread 类或者直接调用Runnable接口来重写run()方法实现线程。*/

    //67、Java 关键字volatile 与 synchronized 作用与区别？
    /*  1，volatile
           它所修饰的变量不保留拷贝，直接访问主内存中的。
             在Java内存模型中，有main memory，每个线程也有自己的memory (例如寄存器)。为了性能，一个线程会在自己的memory中保持要访问的变量的副本。
           这样就会出现同一个变 量在某个瞬间，在一个线程的memory中的值可能与另外一个线程memory中的值，或者main memory中的值不一致的情况。
           一个变量声明为volatile，就意味着这个变量是随时会被其他线程修改的，因此不能将它cache在线程memory中。
        2，synchronized

            当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。
            一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
            二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
            三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
            四、当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
            五、以上规则对其它对象锁同样适用.
*/

    //68、有哪些不同的线程生命周期？
    /*  New(初始化状态)
        Runnable(可运行/运行状态)
        Blocked(阻塞状态)
        Waiting(无时间限制的等待状态)
        Timed_Waiting(有时间限制的等待状态)
        Terminated(终止状态)*/

    //69、什么是死锁(Deadlock)？如何分析和避免死锁？
    /*  死锁是指两个以上的线程永远阻塞的情况，这种情况产生至少需要两个以上的线程和两个以上的资源。

          分析死锁，我们需要查看Java应用程序的线程转储。我们需要找出那些状态为BLOCKED的线程和他们等待的资源。
        每个资源都有一个唯一的id，用这个id我们可以找出哪些线程已经拥有了它的对象锁。
          避免嵌套锁，只在需要的地方使用锁和避免无限期等待是避免死锁的通常办法。*/

    //70、什么是线程安全？Vector是一个线程安全类吗？
    /* 如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，
    而且其他的变量的值也和预期的是一样的，就是线程安全的。一个线程安全的计数器类的同一个实例对象在被多个线程使用的情况下也不会出现计算失误。
    很显然你可以将集合类分成两组，线程安全和非线程安全的。Vector 是用同步方法来实现线程安全的, 而和它相似的ArrayList不是线程安全的。*/

    //71、Java中如何停止一个线程？
    /*当run() 或者 call() 方法执行完的时候线程会自动结束,如果要手动结束一个线程，你可以用volatile (布尔变量来退出run)方法的循环或者是取消任务来中断线程*/

    //72、什么是ThreadLocal?
    /*      ThreadLocal用于创建线程的本地变量，我们知道一个对象的所有线程会共享它的全局变量，所以这些变量不是线程安全的，我们可以使用同步技术。
         但是当我们不想使用同步的时候，我们可以选择ThreadLocal变量。每个线程都会拥有他们自己的Thread变量，它们可以使用get()\set()方法去获取他们的默认值或者在线程内部改变他们的值。
         ThreadLocal实例通常是希望它们同线程状态关联起来是private static属性。*/

    //73、Sleep()、suspend()和wait()之间有什么区别？
    /*      Thread.sleep()使当前线程在指定的时间处于“非运行”（Not Runnable）状态。线程一直持有对象的监视器。比如一个线程当前在一个同步块或同步方法中，
        其它线程不能进入该块或方法中。如果另一线程调用了interrupt()方法，它将唤醒那个“睡眠的”线程。

        注意：   sleep()是一个静态方法。这意味着只对当前线程有效，一个常见的错误是调用t.sleep()，（这里的t是一个不同于当前线程的线程）。即便是执行t.sleep()，也是当前线程进入睡眠，而不是t线程。
             t.suspend()是过时的方法，使用suspend()导致线程进入停滞状态，该线程会一直持有对象的监视器，suspend()容易引起死锁问题。
                object.wait()使当前线程出于“不可运行”状态，和sleep()不同的是wait是object的方法而不是thread。调用object.wait()时，线程先要获取这个对象的对象锁，
             当前线程必须在锁对象保持同步，把当前线程添加到等待队列中，随后另一线程可以同步同一个对象锁来调用object.notify()，这样将唤醒原来等待中的线程，然后释放该锁。
             基本上wait()/notify()与sleep()/interrupt()类似，只是前者需要获取对象锁。*/

    //74、什么是线程饿死，什么是活锁？
    /*  当所有线程阻塞，或者由于需要的资源无效而不能处理，不存在非阻塞线程使资源可用。JavaAPI中线程活锁可能发生在以下情形：
        1，当所有线程在程序中执行Object.wait(0)，参数为0的wait方法。程序将发生活锁直到在相应的对象上有线程调用Object.notify()或者Object.notifyAll()。
        2，当所有线程卡在无限循环中。*/

    //75、Java中的同步集合与并发集合有什么区别？
    /*   同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。
        在Java1.5之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。
        Java5介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和    内部分区等现代技术提高了可扩展性。*/

    //76、同步方法和同步块，哪个是更好的选择？
    /*同步块是更好的选择，因为它不会锁住整个对象（当然你也可以让它锁住整个对象）。同步方法会锁住整个对象，哪怕这个类中有多个不相关联的同步块，这通常会导致他们停止执行并需要等待获得这个对象上的锁。*/

    //77、什么是线程池？ 为什么要使用它？
    /*      创建线程要花费昂贵的资源和时间，如果任务来了才创建线程那么响应时间会变长，而且一个进程能创建的线程数有限。
        为了避免这些问题，在程序启动的时候就创建若干线程来响应处理，它们被称为线程池，里面的线程叫工作线程。
        从JDK1.5开始，Java API提供了Executor框架让你可以创建不同的线程池。比如单线程池，每次处理一个任务；数目固定的线程池或者是缓存线程池（一个适合很多生存期短的任务的程序的可扩展线程池）。*/

    //78、多线程中的忙循环是什么?
    /*    忙循环就是程序员用循环让一个线程等待，不像传统方法wait(), sleep() 或 yield() 它们都放弃了CPU控制，而忙循环不会放弃CPU，它就是在运行一个空循环。这么做的目的是为了保留CPU缓存。
        在多核系统中，一个等待线程醒来的时候可能会在另一个内核运行，这样会重建缓存。为了避免重建缓存和减少等待重建的时间就可以使用它了。*/

    //79、Java中的泛型是什么 ? 使用泛型的好处是什么?
    /* 泛型是Java SE 1.5的新特性，泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
好处：
        1、类型安全，提供编译期间的类型检测
        2、前后兼容
        3、泛化代码,代码可以更多的重复利用
        4、性能较高，用GJ(泛型JAVA)编写的代码可以为java编译器和虚拟机带来更多的类型信息，这些信息对java程序做进一步优化提供条件。*/

    //80、简单说一下数据库的三范式？
    /*  第一范式： 数据表之中的每一个字段都不可再分，数据表中的每一列都具有原子性

        第二范式： 确保表中的每列都和主键相关

        第三范式： 确保每列都和主键列直接相关,而不是间接相关	*/

    //81、数据库五大约束
    /*  1.primary KEY:设置主键约束；
        2.UNIQUE：设置唯一性约束，不能有重复值；
        3.DEFAULT 默认值约束，height DOUBLE(3,2)DEFAULT 1.2 height不输入是默认为1,2
        4.NOT NULL：设置非空约束，该字段不能为空；
        5.FOREIGN key :设置外键约束。
*/

    //82、 索引 主键
    /*索引是对数据库中一列或多列的值进行排序的一种结构。
    * 全文索引  FULLTEXT  mysql>ALTER TABLE `table_name` ADD FULLTEXT ( `column`)
    * 普通索引  mysql>ALTER TABLE `table_name` ADD INDEX index_name ( `column` )
    * 复合索引  mysql>ALTER TABLE `table_name` ADD INDEX index_name ( `column1`, `column2`, `column3` )
    * 唯一索引  mysql>ALTER TABLE `table_name` ADD UNIQUE ( `column` )
    * 数据库主键，指的是一个列或多列的组合，其值能唯一地标识表中的每一行，通过它可强制表的实体完整性。主键主要是用于其他表的外键关联，以及本记录的修改与删除。

    //83、
    /*  CASCADE：父表delete、update的时候，子表会delete、update掉关联记录；
        SET NULL：父表delete、update的时候，子表会将关联记录的外键字段所在列设为null，所以注意在设计子表时外键不能设为not null；
        RESTRICT：如果想要删除父表的记录时，而在子表中有关联该父表的记录，则不允许删除父表中的记录；
        NO ACTION：同 RESTRICT，也是首先先检查外键；
*/

    //84、动态代理

    class t implements InvocationHandler{
        @Override
//        类对象、类的方法，参数
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
