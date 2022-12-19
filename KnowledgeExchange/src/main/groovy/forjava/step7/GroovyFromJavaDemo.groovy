package forjava.step7

// removing parentheses
class GroovyFromJavaDemo {

    static void main(def args) {
        String name = (new Scanner(System.in)).nextLine().trim()
        sayHelloTo name
    }

    static def sayHelloTo(name = "World") {
        name = name ?: "World"
        System.out.println "Hello " + name // not always a good solution !!
    }
}