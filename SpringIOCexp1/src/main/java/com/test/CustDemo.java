
package com.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");

        Customer c = ctx.getBean("cst", Customer.class);
        System.out.println("Loaded Customer: " + c);

        ctx.close();
    }
}
