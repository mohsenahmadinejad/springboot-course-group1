package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context=
               SpringApplication.run(DemoApplication.class, args);
//       HelloBean helloBean2=new HelloBean();
        HelloBean helloBean=context.getBean(HelloBean.class);
        System.out.println(helloBean.sayHello());
    }

}
