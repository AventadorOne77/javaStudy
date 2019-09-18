package test.one;


import org.junit.Test;
import pojo.Student;
import test.one.outer;

import java.util.*;

public class Two_Collection {

//    11.接口是否可继承接口?抽象类是否可实现(implements)接口?抽象类是否可继承具体类(concreteclass)?抽象类中是否可以有静态的main方法？
    /* 接口可以继承接口。抽象类可以实现(implements)接口，抽象类可以继承具体类。抽象类中可以有静态的main方法。
       抽象类与普通类的唯一区别就是不能创建实例对象和允许有abstract方法。
    * */

//    12.abstractclass和interface语法上有什么区别?
    /*1.抽象类可以有构造方法，接口中不能有构造方法。

      2.抽象类中可以有普通成员变量，接口中没有普通成员变量

      3.抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方法。

      4. 抽象类中的抽象方法的访问类型可以是public，protected和（默认类型,虽然
          eclipse下不报错，但应该也不行），但接口中的抽象方法只能是public类型的，并且默认即为public abstract类型。

      5. 抽象类中可以包含静态方法，接口中不能包含静态方法

      6. 抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口中定义的变量只能是publicstatic final类型，
          并且默认即为publicstatic final类型。

      7. 一个类可以实现多个接口，但只能继承一个抽象类。
    * */

    //    13.内部类可以引用它的包含类的成员吗？有没有什么限制？
    /* 完全可以。如果不是静态内部类，那没有什么限制！如果是静态内部类 只能访问外部类的普通成员变量*/
    @Test
    public void t5() {
        new outer().new innner().b();
    }

//    14.String s = "Hello";s = s + "world!";这两行代码执行后，原始的String对象中的内容到底变了没有？
    /*没有。这时，s不指向原来那个对象了，而指向了另一个 String对象，内容为"Hello world!"，原来那个对象还存在于内存之中，只是s这个引用变量不再指向它了。
        通过上面的说明，我们很容易导出另一个结论，如果经常对字符串进行各种各样的修改，
        或者说，不可预见的修改，那么使用String来代表字符串的话会引起很大的内存开销。
        因为String对象建立之后不能再改变，所以对于每一个不同的字符串，都需要一个String对象来表示。
        这时，应该考虑使用StringBuffer类，它允许修改，而不是每个不同的字符串都要生成一个新的对象。并且，这两种类的对象转换十分容易。
    * */

//    15.集合
    /*
    * Collection ：Collection - 基本的集合接口，一个 Collection 存储一组 Object。 Collection 子接口：List 接口，Set 接口；
    * List
      List - 列表【有序可重复】；有序指插入顺序
       ArrayList - 基于可变数组实现的
       允许多个 null 值（有序可重复）； 线程不同步（线程不安全）； 查询效率高；
       Vector（已过时） Vector - 基于可变数组实现的
       允许多个 null 值（有序可重复）； 线程同步（线程安全）；查询效率高；
       LinkedList LinkedList - 基于双向链表实现的
       允许多个 null 值（有序可重复）； 线程不同步（线程不安全）； 插入删除效率高；

    * Set
      Set - 数学意义上的集合【无序不重复】，满足确定性、互异性、无序性；无序指插入顺序；
      HashSet
        HashSet - 基于 HashMap （哈希表）实现，元素为 HashMap 的 key； 允许一个 null 值（无序不重复）； 线程不同步（线程不安全）； 通过 equals() 和 hashCode() 方法判断重复元素。

        Object 重写 equals() 方法的同时为什么要重写 hashCode()？
        因为 equals() 与 hashCode() 必须保持一致； 当 obj1.equals(obj2) 为 true，obj1.hashCode() 必须等于 obj2.hashCode()；
        当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false；

      TreeSet
        TreeSet- 基于 TreeMap （二叉树）实现，元素为 TreeMap 的 key；主要用来元素排序。
        允许一个 null 值（无序不重复）； 线程不同步（线程不安全）； 通过集合元素类实现 Comparable 接口，重写 compareTo() 方法判断重复元素。
        自然排序（Comparable）
        自然排序：通过集合元素类实现 Comparable 接口，重写 compareTo() 方法排序。 comparaTo() 返回值：
        TreeSet 底层为一个二叉树 return 0; 表示集合中只存一个元素。元素值每次比较，都认为是相同的元素，这时就不再向TreeSet中插 入除第一个外的新元素。 return 1; 表示集合正序排列。
        元素值每次比较，都认为新插入的元素比上一个元素大，于是二叉树存储 时，会存在根的右侧，读取时就是正序排列的。 return -1; 表示集合倒序排列。元素值每次比较，都认为新插入的元素比上一个元素小，于是二叉树存储 时，会存在根的左侧，读取时就是倒序序排列的。
        比较器排序 Comparator<T>
        创建 TreeSet 类时制定一个 Comparator 接口，重写 compare() 方法制定排序规则。

    * Map
      Map - 键值对集合【无序双列集合】，一个 Map 存储一组键值对，提供键 ( key ) 与值 ( value ) 映射。键不允许重复；
        HashTable
         HashTable - 散列表， 线程同步（使用 synchronized 实现同步）
        HashMap
         HashMap - 基于哈希桶数组实现的 Map；生成相同 hashCode 的不同 key 存储在同一个 bucket 下，null key 存储在 0 bucket 下。
        TreeMap
         TreeMap - 基于红黑树实现的 Map；

        HashTable与HashMap的区别
        1. 关于null： HashTable不支持 null-key 和 null-value。HashTable 遇到 null，抛出 NullPointerException。
        HashMap支持 null-key 和 null-value。HashMap 对 null 做了特殊处理，将 null 的 hashCode 值定为了 0， 从而将其存放在哈希表的第0个 bucket 中。

        2. 扩容方式： HashTable 默认初始化容量大小为11，之后每次扩充为原来的2n+1。 HashMap默认初始化容量大小为16，之后每次扩充为原来的2倍。
        在取模计算时，如果模数是2的幂，那么我们可以直接使用位运算来得到结果，效率要大大高于做除 法。所以从hash计算的效率上，又是HashMap更胜一筹。

        3. 线程安全：
        HashTable 线程安全（同步）； HashMap 线程不安全（不同步）；
        HashTable已经被淘汰了，如果你不需要线程安全，使用HashMap；如果你需要线程安全，使用 ConcurrentHashMap；

        4. 数据结构： HashTable 数组+链表 HashMap 数组+链表/红黑树（JDK1.8）

        ConcurrentHashMap和Hashtable的区别
        HashTable 采用 synchronized 实现同步，单锁锁定整个集合，迭代时其他线程必须等待其迭代完成才能访问 map，所以当 Hashtable 的大小增加到一定的时候，性能会急剧下降。
        ConcurrentHashMap 引入了分割（segmentation），仅锁定 map 的某个部分，更适用于高并发。
 */
    @Test
    public void t6(){
        Map map = new HashMap();
        map.put(0,"1a0");
        map.put(0,"1a1");
        map.put(1,"1a2");
        map.put(2,"1a3");

        Set s = map.entrySet();

        for (Object o : s){
            Map.Entry e = (Map.Entry) o;
            System.out.println(e.getKey()+"  -   "+e.getValue());
        }
    }

}
