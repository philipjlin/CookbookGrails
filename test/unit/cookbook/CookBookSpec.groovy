package cookbook

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Unit Tests for CookBook objects
 *
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CookBook)
class CookBookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test cookbook recipes list is not null"(){

        when:
            def cookBook = new CookBook(recipes:[])
        then:
            cookBook.validate()
        when:
            cookBook.recipes = null
        then:
            !cookBook.validate()
    }
}
