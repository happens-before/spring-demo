package com.xupt.edu.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: zhaowanyue
 * @date: 2018/8/23
 * @description:
 */

/**
 *  首先Spring创建office对象，采用其默认构造函数，创建成功后，Spring会通过以下代码将对象提前暴露出来，
    尽管此时的对象还未完成属性注入，属于早期对象。这个时候对象放在singletonFactories的Map表中，value是函数对象ObjectFactory.

    addSingletonFactory(beanName, new ObjectFactory<Object>() {
    @Override
    public Object getObject() throws BeansException {
    return getEarlyBeanReference(beanName, mbd, bean);
    }
    });

    接下来，Spring会通过函数populateBean来完成office对象的属性注入，再注入boss属性时，发现是一个引用对象，
    这个时候同样会通过getBean(“boss”)来获得boss对象，boss对象由于从未创建，则创建boss对象。在创建boss对象时，发现它构造依赖于office对象，
    这个时候Spring也会通过getBean(“office”)获取office对象。由于存在office提前暴露出来，这个时候直接从singletonFactories的Map表中得到office对象并返回，
    并不需要重新再创建office对象，这样就避免了循环依赖问题，接下来boss对象可以成功被创建，则返回到到office的属性注入中。office属性注入完成后，
    得到的office对象是成型的，接下来Spring会进一步判断office在后期的处理过程中是否发生引用更改，所谓引用更改就是成型的office对象与早期暴露的office对象
    是否还是同一个对象。
     if (earlySingletonExposure) {
     //获取指定名称的已注册的单态模式Bean对象
     // allowEarlyReference为false，则不会解析singletonFactories
     Object earlySingletonReference = getSingleton(beanName, false);
     if (earlySingletonReference != null) {//判断点1：首先确定这个对象能从earlySingletonObjects中取出对象来
        //根据名称获取的以注册的Bean和正在实例化的Bean是同一个
        if (exposedObject == bean) {
            //再判断这个对象和当前通过beanPostProcessor处理过的对象是否相同，如果相同，表示对象没有经过修改，即A=A-，那么循环引用成立。无需处理
            exposedObject = earlySingletonReference;
     }
     //当前Bean依赖其他Bean，并且当发生循环引用时不允许新创建实例对象
     else if (!this.allowRawInjectionDespiteWrapping && hasDependentBean(beanName)) {
        String[] dependentBeans = getDependentBeans(beanName);
        Set<String> actualDependentBeans = new LinkedHashSet<String>(dependentBeans.length);
        for (String dependentBean : dependentBeans) {
            if (!removeSingletonIfCreatedForTypeCheckOnly(dependentBean)) {
                actualDependentBeans.add(dependentBean);
     }
     }
     if (!actualDependentBeans.isEmpty()) {//出现循环引用，且被引用的bean被修改
     throw new BeanCurrentlyInCreationException(beanName,
        "Bean with name '" + beanName + "' has been injected into other beans [" +
        StringUtils.collectionToCommaDelimitedString(actualDependentBeans) +
        "] in its raw version as part of a circular reference, but has eventually been " +
        "wrapped. This means that said other beans do not use the final version of the " +
        "bean. This is often the result of over-eager type matching - consider using " +
        "'getBeanNamesOfType' with the 'allowEagerInit' flag turned off, for example.");
     }
     }
     }
     }
    如果是同一个引用对象，则循环引用成立，否则会抛出BeanCurrentlyInCreationException异常
    大意是：当前对象的早期版本被注入到其他对象引用中，也就是最终版本和原始版本不一样导致的，这个时候Spring只能抛出异常。
 */
public class Main {
    public static void main(String[] args) {
        //创建对象以及为spring赋值，交给spring完成
        /*
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.setName("zhaowanyue");
        */
        //创建spring ioc容器对象
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");

        //从ioc容器中获取bean实例
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.hello();
    }
}
