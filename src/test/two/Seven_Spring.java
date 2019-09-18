package test.two;

public class Seven_Spring {
    //50、谈谈你对spring的理解
    /*  1.Spring是实现了工厂模式的工厂类（在这里有必要解释清楚什么是工厂模式），这个类名为BeanFactory（实际上是一个接口），
        在程序中通常BeanFactory的子类ApplicationContext。Spring相当于一个大的工厂类，在其配置文件中通过<bean>元素配置用于创建实例对象的类名和实例对象的属性。
        2. Spring提供了对IOC良好支持，IOC是一种编程思想，是一种架构艺术，利用这种思想可以很好地实现模块之间的解耦，IOC也称为DI（Depency Injection）。
        3. Spring提供了对AOP技术的良好封装， AOP称为面向切面编程，就是系统中有很多各不相干的类的方法，在这些众多方法中要加入某种系统功能的代码，
        例如，加入日志，加入权限判断，加入异常处理，这种应用称为AOP。
        实现AOP功能采用的是代理技术，客户端程序不再调用目标，而调用代理类，代理类与目标类对外具有相同的方法声明，有两种方式可以实现相同的方法声明，一是实现相同的接口，二是作为目标的子类。*/

    //51、使用Spring框架的好处是什么？
    /*  --轻量：Spring 是轻量的，基本的版本大约2MB。
        --控制反转：Spring通过控制反转实现了松散耦合，对象们给出它们的依赖，而不是创建或查找依赖的对象们。
        --面向切面的编程(AOP)：Spring支持面向切面的编程，并且把应用业务逻辑和系统服务分开。
        --容器：Spring 包含并管理应用中对象的生命周期和配置。
        --MVC框架：Spring的WEB框架是个精心设计的框架，是Web框架的一个很好的替代品。
        --事务管理：Spring 提供一个持续的事务管理接口，可以扩展到上至本地事务下至全局事务（JTA）。
        --异常处理：Spring 提供方便的API把具体技术相关的异常（比如由JDBC，Hibernate or JDO抛出的）转化为一致的unchecked 异常。*/

    //52、ApplicationContext通常的实现是什么?
    /*  FileSystemXmlApplicationContext ：此容器从一个XML文件中加载beans的定义，XML Bean 配置文件的全路径名必须提供给它的构造函数。
        ClassPathXmlApplicationContext：此容器也从一个XML文件中加载beans的定义，这里，你需要正确设置classpath因为这个容器将在classpath里找bean配置。
        WebXmlApplicationContext：此容器加载一个XML文件，此文件定义了一个WEB应用的所有bean。*/

    //53、什么是Spring的依赖注入？有哪些方法进行依赖注入？
    /*--依赖注入，是IOC的一个方面，是个通常的概念，它有多种解释。这概念是说你不用创建对象，而只需要描述它如何被创建。你不在代码里直接组装你的组件和服务，
        但是要在配置文件里描述哪些组件需要哪些服务，之后一个容器（IOC容器）负责把他们组装起来。
      --构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。
      --Setter方法注入：Setter方法注入是容器通过调用无参构造器或无参static工厂 方法实例化bean之后，调用该bean的setter方法，即实现了基于setter的依赖注入。*/

    //54、什么是Spring beans?
    /*  Spring beans 是那些形成Spring应用的主干的java对象。它们被Spring IOC容器初始化，装配，和管理。这些beans通过容器中配置的元数据创建。比如，以XML文件中<bean/> 的形式定义。
        Spring 框架定义的beans都是单件beans。在bean tag中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个 prototype bean。
        默认是TRUE，所以所有在Spring框架中的beans 缺省都是单件。*/

    //55、解释Spring支持的几种bean的作用域。
    /*  Spring框架支持以下五种bean的作用域：
        singleton : bean在每个Spring ioc 容器中只有一个实例。
        prototype：一个bean的定义可以有多个实例。
        request：每次http请求都会创建一个bean，该作用域仅在基于web的        Spring ApplicationContext情形下有效。
        session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。
        global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。*/

    //56、解释Spring框架中bean的生命周期。
    /*  1，Spring容器 从XML 文件中读取bean的定义，并实例化bean。
        2，Spring根据bean的定义填充所有的属性。
        3，如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。
        4，如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。
        5，如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。
        6，如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。
        7，如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。
        8，如果bean实现了 DisposableBean，它将调用destroy()方法。*/

    //57、在 Spring中如何注入一个java集合？
    /*Spring提供以下几种集合的配置元素：
      <list>类型用于注入一列值，允许有相同的值。
      <set> 类型用于注入一组值，不允许有相同的值。
      <map> 类型用于注入一组键值对，键和值都可以为任意类型。
      <props>类型用于注入一组键值对，键和值都只能为String类型。*/

    //58、解释不同方式的自动装配。
    /*  有五种自动装配的方式，用来指导Spring容器用自动装配方式进行依赖注入。
        no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。
        byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。
        byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。
        constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。
        autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。*/
}
