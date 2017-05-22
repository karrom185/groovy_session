import db.DbInitializer
import groovy.json.JsonOutput
import org.glassfish.jersey.server.ResourceConfig

import static org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory.createHttpServer

List.metaClass.asJson = { ->
    JsonOutput.toJson delegate
}

new DbInitializer().init()

ResourceConfig withLookupInPackages = new ResourceConfig().packages 'services','filters'

def server = createHttpServer "http://localhost:9998/".toURI(), withLookupInPackages
server.with {
    start()
    println "Server running"
    System.in.read()
    println "Stopping server"
    shutdownNow()
    println "Server stopped"
}
