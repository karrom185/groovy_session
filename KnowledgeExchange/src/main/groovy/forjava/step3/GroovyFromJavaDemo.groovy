package forjava.step3

import java.util.Scanner;

// removing with def, omit type
class GroovyFromJavaDemo {

    static void main(def args) {
        String name = (new Scanner(System.in)).nextLine().trim()
        sayHello(name)
    }

    static def sayHello(name) {
        if (name == null || name.isEmpty()) {
            name = "world"
        }
        System.out.println("Hello " + name)
    }
}