package forjava.step4

import java.util.Scanner;

// default value
class GroovyFromJavaDemo {

    static void main(def args) {
        String name = (new Scanner(System.in)).nextLine().trim()
        sayHello(name)
        sayHello()
        sayHello(null)

    }

    static def sayHello(name = "World") {
        System.out.println("Hello " + name)
    }
}