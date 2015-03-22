package com.javahonk;

/**
 * Created by BRIJ on 3/21/2015.
 */
public class TestClass {

    static String value = "java honk";

    public static void main(String args[]){
        test();
    }

    private static void test() {
        System.out.println("Hello world"+value);
        System.out.println("Hello world");
        method1();

    }

    private static void method1() {
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
    }
}
