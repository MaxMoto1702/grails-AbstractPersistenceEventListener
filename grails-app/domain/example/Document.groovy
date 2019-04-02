package example

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json', 'xml'])
class Document {
    Long id

    String number
    Date date

    String comment

    static constraints = {
        comment nullable: true
    }
}