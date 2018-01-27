package com.github.vlsidlyarevich.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Educe tec application starter class.
 */
@SpringBootApplication
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.instinctools.educe.tec")
public class Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
