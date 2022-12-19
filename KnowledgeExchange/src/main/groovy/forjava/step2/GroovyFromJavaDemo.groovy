package forjava.step2

import java.util.Scanner;

// removing public/private
class GroovyFromJavaDemo {

    static void main(String[] args) {
        String name = (new Scanner(System.in)).nextLine().trim()
        sayHello(name)
    }

    static void sayHello(String name) {
        if(name == null || name.isEmpty()){
            name = "world"
        }
        System.out.println("Hello " + name)
    }
}