package cookbook

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Unit Tests for Comment objects
 *
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comment)
class CommentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test comment has some text"(){

        when:
            def comment = new Comment(text:'test comment', datePublished:new Date(), author:'author', recipe:new Recipe())
        then:
            comment.validate()
        when:
            comment.text = null
        then:
            !comment.validate()
    }

    void "test comment is no longer than 140 characters"(){

        when:
            def comment = new Comment(text:'test comment', datePublished:new Date(), author:'author', recipe:new Recipe())
        then:
            comment.validate()
        when:
            comment.text = "sdfkdsf;akfj;sadljfdlkjf;alskjfldks;afjdslkjfldsfjlkasdf;djkfa;kddsaklsd" +
                            "dskfljdsfjdsk;jakfjdl;a;ajlfadk;sjflaks;dfjdsjf;dasjf;kadjsf;akdfjaadf;j"
        then:
            !comment.validate()
    }

    void "test datePublished is valid"() {

        when:
            def comment = new Comment(text: 'test comment', datePublished: new Date(), author:'author', recipe:new Recipe())
        then:
            comment.validate()
        when:
            comment.datePublished = Date.parse("MM-dd-yyyy", "01-14-2018")
        then:
            !comment.validate()
    }



}
