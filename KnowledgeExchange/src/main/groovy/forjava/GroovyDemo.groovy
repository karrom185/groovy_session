package forjava

class GroovyDemo {

    def list = [1, 2, 3, 4, 5]
    String[] array = [1, 2, 3, 4, 5]
    def someMap = ['1': 'Item 1', '2': 'Item 2', '3': 'Item 3']
    def closure = { int i -> i + 1 }

    def cols = [list, array, someMap, ArrayList, closure]

    static main(args) {

        new GroovyDemo().start()

    }


    def start() {

        println someMap.getClass()

        cols.each {
            println "Class ${it.class}"
            it.each {
                println "Element ${it.toString()}"
            }

            println it.findAll{ it instanceof Integer && it % 2 == 0 }*.toString()


        }


        println 'For map: '

        println someMap
        println someMap.'2'
        println someMap['2']
        println someMap.get('2')
        println someMap.getAt('2')


    }


}


