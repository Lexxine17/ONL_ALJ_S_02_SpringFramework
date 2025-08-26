package pl.coderslab.day1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.coderslab.day1.zad2.Captain;
import pl.coderslab.day1.zad2.Ship;
import pl.coderslab.day1.zad3.ScopePrototype;
import pl.coderslab.day1.zad3.ScopeSingleton;

@Configuration
@ComponentScan("pl.coderslab.day1.beans")
public class AppConfig {

    @Bean(name = "helloWorld")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    public Captain jackSparrow() {
        return new Captain();
    }

    @Bean
    public Ship blackPearl() {
        return new Ship(jackSparrow());
    }

    @Bean
    public ScopeSingleton scopeSingleton() {
        return new ScopeSingleton();
    }

    @Bean
    @Scope("prototype")
    public ScopePrototype scopePrototype() {
        return new ScopePrototype();
    }


}
