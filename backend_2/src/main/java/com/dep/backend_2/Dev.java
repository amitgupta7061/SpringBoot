package com.dep.backend_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // dependency injection
public class Dev {

    @Autowired  // field injection
    @Qualifier("Laptop") // don't want primary
    private Computer laptop;

    // work without autowired using constructor
//    public Dev(Laptop laptop){
//        this.laptop = laptop;
//    }

    // in case of setter
//    @Autowired
//    public void setLaptop(Laptop laptop){
//        this.laptop = laptop;
//    }

    public void build(){
        laptop.compile();
        System.out.println("working on dependency injection");
    }
}
