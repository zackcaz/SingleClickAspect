## AOP方式判断Android控件重复点击

参考：https://www.jianshu.com/p/7b354eb8d0d3

## 粗略总结->

使用https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx 这个Aspectj插件

注意：
* 定义切点的注解路径要写全
* 定义切面包裹的切点方法要加括号

关于Aspectj使用：
* 1.使用`@Aspect`修饰要切入的类
* 2.使用` @Pointcut("execution(@com.lifecycle.singleclickaspect.singleclick.annotation.SingleClick * *(..))")`修饰切点，同常这个切点是个自定义注解，路径根据实际情况修改
* 3.使用`@Around、@Before、@After`修饰切面的方法
关键字|说明
Aspect|声明一个AOP容器
Pointcut|声明一个切入点
Before|在函数主体执行之前插入代码
After|在函数主体执行之后插入代码
Around|将函数主体包裹起来，在函数主体前、后插入代码
