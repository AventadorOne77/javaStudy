package test.one;

import pojo.Student;

import java.util.*;

public class TreeTest {
    public static void main(String[] args) {
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student student1 =(Student)o1;
                Student student2 =(Student)o2;
                int flag =student1.getName().compareTo(student2.getName());
                if (flag==0){                   //如果姓名相等 根据年龄排  否则根据姓名排
                    flag = student1.getAge().compareTo(student2.getAge());
                }
                return flag;
            }
        });

        set.add(new Student("aa",2));
        set.add(new Student("aa",5));
        set.add(new Student("bb",34));
        set.add(new Student("cc",7));

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Integer [] arr = new Integer[]{2,3,5,4,7,1};
        List list1 = Arrays.asList(2,9);
        for (Object obj :list1){
            System.out.println(obj);
        }
    }
}
