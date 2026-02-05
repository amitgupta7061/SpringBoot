package org.demo;

public class Desktop implements Computer {

    @Override
    public void compile() {
        System.out.println("From desktop compiling");
    }
}
