package org.demo;

public class Dev {

    //private Laptop laptop;
    private int age;
    private Computer com;

    public Dev(){
        System.out.println("Dev Constructor..");
    }

    public Dev(int age) {
        this.age = age;
        System.out.println("Parameterized constructor");
    }


//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }


    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }


    public void compile(){
        System.out.println("Hello world from Dev compiler");
        com.compile();
    }
}
