package test.two;

public class Eight_Mybatis {
    //59、什么是ORM？
    /*  对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术；
        简单的说，ORM是通过使用描述对象和数据库之间映射的元数据（在Java中可以用XML或者是注解），
        将程序中的对象自动持久化到关系数据库中或者将关系数据库表中的行转换成Java对象，其本质上就是将数据从一种形式转换到另外一种形式。*/

    //60、MyBatis中使用#和$书写占位符有什么区别？
    /* #将传入的数据都当成一个字符串，会对传入的数据自动加上引号；
       $将传入的数据直接显示生成在SQL中。
       注意：使用$占位符可能会导致SQL注射攻击，能用#的地方就不要使用$，写order by子句的时候应该用$而不是#。
    * */

    //61、解释一下MyBatis中命名空间（namespace）的作用。
    /*  在大型项目中，可能存在大量的SQL语句，这时候为每个SQL语句起一个唯一的标识（ID）就变得并不容易了。
      为了解决这个问题，在MyBatis中，可以为每个映射文件起一个唯一的命名空间，这样定义在这个映射文件中的每个SQL语句就成了定义在这个命名空间中的一个ID。
      只要我们能够保证每个命名空间中这个ID是唯一的，即使在不同映射文件中的语句ID相同，也不会再产生冲突了。*/

    //62、JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？
    /*  1、JDBC：数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库链接池可解决此问题。
           MyBatis：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。
        2、JDBC：Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。
           MyBatis：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。
        3、JDBC：向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。
           MyBatis： Mybatis自动将java对象映射至sql语句。
        4，JDBC：对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。
           MyBatis：Mybatis自动将sql执行结果映射至java对象。*/

    //63、简单的说一下MyBatis的一级缓存和二级缓存？
    /*Mybatis首先去缓存中查询结果集，如果没有则查询数据库，如果有则从缓存取出返回结果集就不走数据库。
      Mybatis内部存储缓存使用一个HashMap，key为hashCode+sqlId+Sql语句。value为从查询出来映射生成的java对象；

      Mybatis的二级缓存即查询缓存，它的作用域是一个mapper的namespace，即在同一个namespace中查询sql可以从缓存中获取数据。二级缓存是可以跨SqlSession的。*/
}
