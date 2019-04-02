package myapp


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class MyDocument {
    Long id

    String number
    Date date

    String comment

    static constraints = {
        comment nullable: true
    }
}