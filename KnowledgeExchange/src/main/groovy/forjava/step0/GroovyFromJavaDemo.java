package forjava.step0;

import java.util.Scanner;

public class GroovyFromJavaDemo {
    public static void main(String[] args) {
        String name = (new Scanner(System.in)).nextLine().trim();
        sayHello(name);
    }
    public static void sayHello(String name) {
        if(name == null || name.isEmpty()){
            name = "world";
        }
        System.out.println("Hello " + name);
    }
}