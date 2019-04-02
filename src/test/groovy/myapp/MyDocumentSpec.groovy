package myapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MyDocumentSpec extends Specification implements DomainUnitTest<MyDocument> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }
}
