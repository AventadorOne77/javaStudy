package test.one;

public class Six_Jdbc {
    //44、JDBC访问数据库的基本步骤是什么？
    /*1，加载驱动
      2，通过DriverManager对象获取连接对象Connection
      3，通过连接对象获取会话
      4，通过会话进行数据的增删改查，封装对象
      5，关闭资源*/

    //45、说说preparedStatement和Statement的区别
    /*1，效率：预编译会话比普通会话对象，数据库系统不会对相同的sql语句不会再次编译
      2，安全性：可以有效的避免sql注入攻击！sql注入攻击就是从客户端输入一些非法的特殊字符，而使服务器端在构造sql语句的时候仍然能够正确构造，从而收集程序和服务器的信息和数据。
                比如：“select * from t_user where userName = ‘” + userName + “ ’ and password =’” + password + “’”
                如果用户名和密码输入的是’1’ or ‘1’=’1’ ;  则生产的sql语句是：
                “select * from t_user where userName = ‘1’ or ‘1’ =’1’  and password =’1’  or ‘1’=’1’  这个语句中的where 部分没有起到对数据筛选的作用。*/

    //46、说说事务的概念，在JDBC编程中处理事务的步骤。
    /*1 事务是作为单个逻辑工作单元执行的一系列操作。
      2，一个逻辑工作单元必须有四个属性，称为原子性、一致性、隔离性和持久性 (ACID) 属性，只有这样才能成为一个事务
        事务处理步骤：
      3，conn.setAutoComit(false);设置提交方式为手工提交
      4，conn.commit()提交事务
      5，出现异常，回滚 conn.rollback();*/

    //47、数据库连接池的原理。为什么要使用连接池。
    /*1，数据库连接是一件费时的操作，连接池可以使多个操作共享一个连接。
      2，数据库连接池的基本思想就是为数据库连接建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，
         当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去。我们可以通过设定连接池最大连接数来防止系统无尽的与数据库连接。
         更为重要的是我们可以通过连接池的管理机制监视数据库的连接的数量、使用情况，为系统开发，测试及性能调整提供依据。
      3，使用连接池是为了提高对数据库连接资源的管理

    //48、JDBC的DriverManager是用来做什么的？
    /*JDBC的DriverManager是一个工厂类，我们通过它来创建数据库连接。当JDBC的Driver类被加载进来时，它会自己注册到DriverManager类里面
      然后我们会把数据库配置信息传成DriverManager.getConnection()方法，DriverManager会使用注册到它里面的驱动来获取数据库连接，并返回给调用的程序。*/

    //49、JDBC的ResultSet是什么？
    /*  在查询数据库后会返回一个ResultSet，它就像是查询结果集的一张数据表。
      ResultSet对象维护了一个游标，指向当前的数据行。开始的时候这个游标指向的是第一行。如果调用了ResultSet的next()方法游标会下移一行，
      如果没有更多的数据了，next()方法会返回false。可以在for循环中用它来遍历数据集。 默认的ResultSet是不能更新的，游标也只能往下移。
      也就是说你只能从第一行到最后一行遍历一遍。不过也可以创建可以回滚或者可更新的ResultSet，
      当生成ResultSet的Statement对象要关闭或者重新执行或是获取下一个ResultSet的时候，ResultSet对象也会自动关闭。
      可以通过ResultSet的getter方法，传入列名或者从1开始的序号来获取列数据。 */






}
