# 设计模式专栏
#### 目录介绍
- 00.设计模式分类汇总
- 01.创建型设计模式
- 02.结构型设计模式
- 03.行为型设计模式
- 04.面向对象设计原则
- 05.项目重构的演进
- 06.面向对象设计思想
- 07.更多内容推荐




## 00.设计模式分类汇总
| 23种设计模式 & 描述 & 核心作用                                                                              | 包括                                                                                                                                                                                                                                                                                                                                          |
|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **[创建型模式](http://localhost:8080/zh/design/creational/)**<br>提供创建对象用例。能够将软件模块中对象的创建和对象的使用分离       | 工厂模式（Factory Pattern）<br>抽象工厂模式（Abstract Factory Pattern）<br>单例模式（Singleton Pattern）<br>建造者模式（Builder Pattern）<br>原型模式（Prototype Pattern）                                                                                                                                                                                                   |
| **[结构型模式](http://localhost:8080/zh/design/behavioral/)**<br>关注类和对象的组合。描述如何**将类或者对象结合在一起形成更大的结构** | 适配器模式（Adapter Pattern）<br>桥接模式（Bridge Pattern）<br>过滤器模式（Filter、Criteria Pattern）<br>组合模式（Composite Pattern）<br>装饰器模式（Decorator Pattern）<br>外观模式（Facade Pattern）<br>享元模式（Flyweight Pattern）<br>代理模式（Proxy Pattern）                                                                                                                           |
| **[行为型模式](http://localhost:8080/zh/design/structural/)**<br>特别关注对象之间的通信。主要解决的就是“类或对象之间的交互”问题     | 责任链模式（Chain of Responsibility Pattern）<br>命令模式（Command Pattern）<br>解释器模式（Interpreter Pattern）<br>迭代器模式（Iterator Pattern）<br>中介者模式（Mediator Pattern）<br>备忘录模式（Memento Pattern）<br>观察者模式（Observer Pattern）<br>状态模式（State Pattern）<br>空对象模式（Null Object Pattern）<br>策略模式（Strategy Pattern）<br>模板模式（Template Pattern）<br>访问者模式（Visitor Pattern） |



## 01.创建型模式
### 1.1 创建型模式导读
- [01.创建型模式导读](https://yccoding.com/zh/design/introduction/01.%E5%88%9B%E5%BB%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F%E5%AF%BC%E8%AF%BB.html)


### 1.2 创建型设计模式
- [01.创建型：单例设计模式思想](https://yccoding.com/zh/design/creational/01.%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [02.创建型：工厂设计模式思想](https://yccoding.com/zh/design/creational/02.%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [03.创建型：建造者模式设计](https://yccoding.com/zh/design/creational/03.%E5%BB%BA%E9%80%A0%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [04.创建型：原型设计模式](https://yccoding.com/zh/design/creational/04.%E5%8E%9F%E5%9E%8B%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)



## 02.结构型模式
### 2.1 结构型模式导读
- [结构型模式导读](https://yccoding.com/zh/design/introduction/02.%E7%BB%93%E6%9E%84%E5%9E%8B%E6%A8%A1%E5%BC%8F%E5%AF%BC%E8%AF%BB.html)


### 2.2 结构型设计模式
- [05.结构型：静态代理模式思想](https://yccoding.com/zh/design/behavioral/05.%E9%9D%99%E6%80%81%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [06.结构型：动态代理模式思想](https://yccoding.com/zh/design/behavioral/06.%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [07.结构型：适配器设计模式](https://yccoding.com/zh/design/behavioral/07.%E9%80%82%E9%85%8D%E5%99%A8%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [08.结构型：装饰者设计模式](https://yccoding.com/zh/design/behavioral/08.%E8%A3%85%E9%A5%B0%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [09.结构型：外观设计模式](https://yccoding.com/zh/design/behavioral/09.%E5%A4%96%E8%A7%82%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [10.结构型：桥接设计模式](https://yccoding.com/zh/design/behavioral/10.%E6%A1%A5%E6%8E%A5%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [11.结构型：组合设计模式](https://yccoding.com/zh/design/behavioral/11.%E7%BB%84%E5%90%88%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [12.结构型：享元模式设计思想](https://yccoding.com/zh/design/behavioral/12.%E4%BA%AB%E5%85%83%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)



## 03.行为型模式
### 3.1 行为型模式导读
- [行为型模式导读](https://yccoding.com/zh/design/introduction/03.%E8%A1%8C%E4%B8%BA%E5%9E%8B%E6%A8%A1%E5%BC%8F%E5%AF%BC%E8%AF%BB.html)


### 3.2 行为型设计模式
- [13.行为型：观察者模式](https://yccoding.com/zh/design/structural/13.%E8%A7%82%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [14.行为型：策略者模式](https://yccoding.com/zh/design/structural/14.%E7%AD%96%E7%95%A5%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [15.行为型：模版设计模式](https://yccoding.com/zh/design/structural/15.%E6%A8%A1%E7%89%88%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [16.行为型：迭代器设计模式](https://yccoding.com/zh/design/structural/16.%E8%BF%AD%E4%BB%A3%E5%99%A8%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [17.行为型：中介者设计模式](https://yccoding.com/zh/design/structural/17.%E4%B8%AD%E4%BB%8B%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [18.行为型：解释器设计模式](https://yccoding.com/zh/design/structural/18.%E8%A7%A3%E9%87%8A%E5%99%A8%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [19.行为型：命令设计模式](https://yccoding.com/zh/design/structural/19.%E5%91%BD%E4%BB%A4%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [20.行为型：责任链设计模式](https://yccoding.com/zh/design/structural/20.%E8%B4%A3%E4%BB%BB%E9%93%BE%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [21.行为型：备忘录设计模式](https://yccoding.com/zh/design/structural/21.%E5%A4%87%E5%BF%98%E5%BD%95%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [22.行为型：访问者设计模式](https://yccoding.com/zh/design/structural/22.%E8%AE%BF%E9%97%AE%E8%80%85%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)
- [23.行为型：状态设计模式](https://yccoding.com/zh/design/structural/23.%E7%8A%B6%E6%80%81%E6%A8%A1%E5%BC%8F%E8%AE%BE%E8%AE%A1%E6%80%9D%E6%83%B3.html)




## 04.面向对象设计原则
- [01.面向对象六大原则](https://yccoding.com/zh/design/principle/01.%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E5%85%AD%E5%A4%A7%E5%8E%9F%E5%88%99.html)
- [02.单一职责原则详解](https://yccoding.com/zh/design/principle/02.%E5%8D%95%E4%B8%80%E8%81%8C%E8%B4%A3%E5%8E%9F%E5%88%99%E8%AF%A6%E8%A7%A3.html)
- [03.开闭原则详细介绍](https://yccoding.com/zh/design/principle/03.%E5%BC%80%E9%97%AD%E5%8E%9F%E5%88%99%E8%AF%A6%E7%BB%86%E4%BB%8B%E7%BB%8D.html)
- [04.里氏替换原则介绍](https://yccoding.com/zh/design/principle/04.%E9%87%8C%E5%BC%8F%E6%9B%BF%E6%8D%A2%E5%8E%9F%E5%88%99%E4%BB%8B%E7%BB%8D.html)
- [05.接口隔离原则介绍](https://yccoding.com/zh/design/principle/05.%E6%8E%A5%E5%8F%A3%E9%9A%94%E7%A6%BB%E5%8E%9F%E5%88%99%E4%BB%8B%E7%BB%8D.html)
- [06.依赖倒置原则介绍](https://yccoding.com/zh/design/principle/06.%E4%BE%9D%E8%B5%96%E5%80%92%E7%BD%AE%E5%8E%9F%E5%88%99%E4%BB%8B%E7%BB%8D.html)
- [07.迪米特原则介绍](https://yccoding.com/zh/design/principle/07.%E8%BF%AA%E7%B1%B3%E7%89%B9%E5%8E%9F%E5%88%99%E4%BB%8B%E7%BB%8D.html)
- [08.代码保持简单原则](https://yccoding.com/zh/design/principle/08.%E4%BB%A3%E7%A0%81%E4%BF%9D%E6%8C%81%E7%AE%80%E5%8D%95%E5%8E%9F%E5%88%99.html)
- [09.避免代码重复原则](https://yccoding.com/zh/design/principle/09.DRY%E5%8E%9F%E5%88%99%E7%AE%80%E5%8D%95%E4%BB%8B%E7%BB%8D.html)



## 05.项目重构的演进
- [33.项目重构演进之路](https://blog.csdn.net/m0_37700275/article/details/86069291)
- [34.重构技术手段分析](https://blog.csdn.net/m0_37700275/article/details/86294509)
- [35.切忌避免过度设计](https://blog.csdn.net/m0_37700275/article/details/86297630)


## 06.面向对象设计思想
- [01.面向对象思想说明](https://yccoding.com/zh/design/more/01.%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E6%80%9D%E6%83%B3%E8%AF%B4%E6%98%8E.html)
- [02.四大特性详细说明](https://yccoding.com/zh/design/more/02.%E5%9B%9B%E5%A4%A7%E7%89%B9%E6%80%A7%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E.html)
- [03.面向对象和过程](https://yccoding.com/zh/design/more/03.%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E5%92%8C%E8%BF%87%E7%A8%8B.html)
- [04.接口vs抽象类比较](https://yccoding.com/zh/design/more/04.%E6%8E%A5%E5%8F%A3vs%E6%8A%BD%E8%B1%A1%E7%B1%BB%E6%AF%94%E8%BE%83.html)
- [05.接口而非实现编程](https://yccoding.com/zh/design/more/05.%E6%8E%A5%E5%8F%A3%E8%80%8C%E9%9D%9E%E5%AE%9E%E7%8E%B0%E7%BC%96%E7%A8%8B.html)
- [06.多用组合和少继承](https://yccoding.com/zh/design/more/06.%E5%A4%9A%E7%94%A8%E7%BB%84%E5%90%88%E5%92%8C%E5%B0%91%E7%BB%A7%E6%89%BF.html)



## 07.更多内容推荐
| 模块      | 描述                                              | 备注                                                       |
|---------|-------------------------------------------------|----------------------------------------------------------|
| GitHub  | 多个YC系列开源项目，包含Android组件库，以及多个案例                  | [GitHub](https://github.com/yangchong211)                |
| 博客汇总    | 汇聚Java，Android，C/C++，网络协议，算法，编程总结等              | [YCBlogs](https://github.com/yangchong211/YCBlogs)       |
| 设计模式    | 六大设计原则，23种设计模式，设计模式案例，面向对象思想                    | [设计模式](https://github.com/yangchong211/YCDesignBlog)     |
| Java进阶  | 数据设计和原理，面向对象核心思想，IO，异常，线程和并发，JVM                | [Java高级](https://github.com/yangchong211/YCJavaBlog)     |
| 网络协议    | 网络实际案例，网络原理和分层，Https，网络请求，故障排查                  | [网络协议](https://github.com/yangchong211/YCNetwork)        |
| 计算机原理   | 计算机组成结构，框架，存储器，CPU设计，内存设计，指令编程原理，异常处理机制，IO操作和原理 | [计算机基础](https://github.com/yangchong211/YCComputerBlog)  |
| 学习C编程   | C语言入门级别系统全面的学习教程，学习三到四个综合案例                     | [C编程](https://github.com/yangchong211/YCStudyC)          |
| C++编程   | C++语言入门级别系统全面的教学教程，并发编程，核心原理                    | [C++编程](https://github.com/yangchong211/YCStudyCpp)      |
| 算法实践    | 专栏，数组，链表，栈，队列，树，哈希，递归，查找，排序等                    | [Leetcode](https://github.com/yangchong211/YCLeetcode)   |
| Android | 基础入门，开源库解读，性能优化，Framework，方案设计                  | [Android](https://github.com/yangchong211/YCAndroidBlog) |


# 设计模式快速简介
## 01.单例模式设计思想

**01.单例模式基础介绍**

对于系统某些需求来说，保证一个实例很重要，比如文件管理系统，ID生成器等。为了保证实例只能被创建一次，因此这才有了单例模式！

单例模式特点，构造私有，单例类只有一个，反序列化不会重新构建对象，通过静态返回单例对象。

使用场景：应用中只存在一个实例，比如账号系统，数据库等。思考几个问题：为何使用单例，它存在什么问题，跟静态类有何区别，是否有替代方案？

**02.单例模式设计思考**

为何要使用单例？一个类只允许创建一个对象（或者实例），表示全局唯一的类，比如Android中数据库，所有数据操作都是指向一个数据库！

**03.单例模式实现方式**

如何实现单例：构造必须私有，避免外部创建；要考虑线程安全问题，避免多线程下创建多个对象；是否支持延迟加载；性能

1. 方式1: 熟悉单例模式各自的优缺点和使用场景。
2. 方式2: 饿汉式实现方式。
3. 方式3: 懒汉式实现方式。
4. 方式4: 双重DCL校验模式。这种用的最为广泛！
5. 方式5: 静态内部类方式。
6. 方式6: 枚举方式单例。
7. 方式7: 容器实现单例模式。

有什么优点：1.提供全局访问【共享】；2.只有一个对象【对于高频率比较好】；3.使用简单。**缺点也很明显**：1.拓展难；2.指责不清晰；3.滥用单例导致对象状态丢失。

**04.单例模式有那些不友好**

单例对OOP不友好。单例违背了面向对象设计思想，不能搞封装，继承，多态等。如果强行实现面向对象，则会让人感到奇怪！

对代码类之间的依赖和可读性要注意。避免单例中内容太过于庞大，代码逻辑复杂导致维护比较难。

对代码拓展不友好。对可测试不够友好。不支持有参数的构造。


## 02.工厂模式设计思想

**01.工厂模式设计**

工厂模式分类，大概分为三种更加细分的类型：简单工厂、工厂方法和抽象工厂。一般情况下，使用简单工厂，工厂方法场景稍多。

工厂模式思考，主要要搞清楚应用场景。什么时候该用工厂模式？相对于直接 new 来创建对象，用工厂模式来创建究竟有什么好处呢？

思考一个题目，你要在店里买各种咖啡，而这些咖啡中有的加冰，有的加奶，有的加糖。比如美式咖啡，拿铁咖啡，摩卡咖啡，巴西咖啡等等！用简单工厂，工厂方法，抽象工厂分别实现。

**02.简单工厂介绍**

一句话概括简单工厂：可以根据参数的不同返回不同类的实例。

简单工厂模式包含如下角色：抽象产品角色，具体产品角色，工厂角色。

简单工厂实现：

1. 创造抽象产品角色，比如总结出很多咖啡都可能会，加糖，加冰，加奶，因此把它抽成抽象方法。
2. 具体产品角色，这块有：美式咖啡类，拿铁咖啡类，摩卡咖啡等，这些都是具体的咖啡产品。
3. 工厂角色。负责创建不同咖啡，为了简便高效地分配咖啡，设了根据类型（比如`american`，`latte`）来提供不同的咖啡。

**03.工厂方法介绍**

工厂方法模式：定义一个创建对象的接口（指的是抽象工厂），让子类（具体工厂）决定实例化哪个产品类对象。工厂方法使一个产品类的实例化延迟到其工厂的子类。

工厂方法实现：

1. Product：抽象产品。这个和简单工厂模式代码一样，忽略！
2. ConcreteProduct：具体产品。这个和简单工厂模式代码一样，忽略！
3. Factory：抽象工厂。这块定义咖啡工厂接口，通过该接口子类可以自己实现咖啡创建。
4. ConcreteFactory：具体工厂。这里主要是创建美式咖啡工厂类，创建拿铁咖啡工厂类。

**04.抽象工厂介绍**

抽象工厂模式：抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级（即，同种的产品）的产品，而抽象工厂模式可生产多个等级（即，多种产品）的产品。

抽象工厂实现：

1. AbstractFactory：抽象工厂。这个时候则需要抽象出生产甜品，生产咖啡的接口。
2. ConcreteFactory：具体工厂。分别实现生产甜品的具体工厂，生产咖啡的具体工厂。
3. AbstractProduct：抽象产品。这里把甜点抽象成一个产品，把咖啡抽象成一个产品。
4. Product：具体产品。创建具体的美式咖啡，拿铁咖啡产品。创建具体的提拉米苏甜点，抹茶慕斯甜点。





