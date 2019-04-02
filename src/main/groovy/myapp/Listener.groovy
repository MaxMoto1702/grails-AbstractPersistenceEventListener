package myapp

import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.core.Datastore
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEventListener
import org.grails.datastore.mapping.engine.event.EventType
import org.springframework.context.ApplicationEvent

@Slf4j
class Listener extends AbstractPersistenceEventListener {
    protected Listener(Datastore datastore) {
        super(datastore)
    }

    @Override
    protected void onPersistenceEvent(AbstractPersistenceEvent event) {
        log.debug("onPersistenceEvent ${event}")
        if (event.eventType == EventType.PreUpdate && event.entityObject instanceof MyDocument) {
            def document = (MyDocument) event.entityObject
            document.comment = "UPDATED ${new Date().time}"
            log.debug("Updated comment value ${document.comment}")
        }
    }

    @Override
    boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return true
    }
}
