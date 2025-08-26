package pl.coderslab.day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.day1.zad2.Ship;
import pl.coderslab.day1.zad3.ScopePrototype;
import pl.coderslab.day1.zad3.ScopeSingleton;

public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SayGoodbye test = context.getBean(SayGoodbye.class);
        test.hello();

        HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
        bean.hello();

        Ship ship = context.getBean("blackPearl", Ship.class);
        ship.getCaptain().startSailing();

        ScopeSingleton singleton1 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton1);
        ScopeSingleton singleton2 = context.getBean(ScopeSingleton.class);
        System.out.println(singleton2);
        System.out.println((singleton1 == singleton2) + ": ten sam obiekt\n");
        ScopePrototype prototype1 = context.getBean(ScopePrototype.class);
        System.out.println(prototype1);
        ScopePrototype prototype2 = context.getBean(ScopePrototype.class);
        System.out.println(prototype2);
        System.out.println((prototype1 == prototype2) + ": dwa różne obiekty");


    }
}
