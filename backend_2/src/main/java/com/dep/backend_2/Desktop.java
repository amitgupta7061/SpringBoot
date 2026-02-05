package com.dep.backend_2;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Override
    public void compile() {
        System.out.println("Getting Desktop");
    }
}
