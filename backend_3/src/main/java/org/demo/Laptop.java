package org.demo;

public class Laptop implements Computer {

    public Laptop(){
        System.out.println("laptop Constructor..");
    }
    public void compile(){
        System.out.println("Hello world from laptop compiler");
    }
}
