package com.codefactory.internship.lesson5.domain;

public class UtilMethods {
    public static  void sayHello(){
        System.out.println("Hello world");
    }
    public static  void sayHello(String name){
        System.out.println("Hello " + name);
    }
    public static  void sayHello(String name,int iteration){
        for(int i = 0;i < iteration;i++) {
            sayHello(name);
        }
    }
    public static void sayHello(Settings settings){
//        for(int i = 0;i < settings.getIterations();i++){
//            System.out.println(settings.getColor() + "hello");
        }

    public static void sayHello(Settings settings,String text){
//        for(int i = 0;i < settings.getIterations();i++){
//            System.out.println(settings.getColor() +" "+ text);
        }
    public static void main(String[] args) {
        sayHello();
    }
}
