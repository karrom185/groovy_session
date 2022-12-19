package forjava.step5

import java.util.Scanner;

// Elvis operator
class GroovyFromJavaDemo {

    static void main(def args) {
        String name = (new Scanner(System.in)).nextLine().trim()
        sayHello(name)
        sayHello()
        sayHello(null)

    }

    static def sayHello(name = "World") {
        name = name ?: "World"
        System.out.println("Hello " + name)
    }
}