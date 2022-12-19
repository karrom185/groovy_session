package forjava.step6

// removing default imports
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