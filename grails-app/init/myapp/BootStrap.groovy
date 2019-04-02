package myapp

import grails.core.GrailsApplication
import org.grails.datastore.mapping.core.Datastore

class BootStrap {

    GrailsApplication grailsApplication

    def init = { servletContext ->
        new MyDocument(number: "0001", date: new Date()).save()
        new MyDocument(number: "0002", date: new Date()).save()
        new MyDocument(number: "0003", date: new Date()).save()

        def ctx = grailsApplication.mainContext
        ctx.getBeansOfType(Datastore).values().each { Datastore d ->
            ctx.addApplicationListener new Listener(d)
        }
    }
    def destroy = {
    }
}
