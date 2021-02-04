package cookbook

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Unit Test for Recipe objects
 *
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Recipe)
class RecipeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    void "test name not blank"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
        when:
            recipe.name = null
        then:
            !recipe.validate()
    }

    void "test prepTime is within valid range"(){

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
        when:
            recipe.prepTime = 1000
        then:
            !recipe.validate()
    }

    void "test cookTime is within valid range"(){

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
        when:
            recipe.cookTime = -30
        then:
            !recipe.validate()
    }

    void "procedure is not blank"(){

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
        when:
            recipe.procedure = null
        then:
            !recipe.validate()
    }

    void "test lastUpdated is valid"(){

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
        when:
            recipe.lastUpdated = Date.parse('MM-dd-yyyy','03-21-2017')
        then:
            !recipe.validate()
    }

    void "test isBreakfast is true or false"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
    }

    void "test isLunch is true or false"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
    }

    void "test isDinner is true or false"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
    }

    void "test isDessert is true or false"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
    }

    void "test isPublished is true or false"() {

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
        then:
            recipe.validate()
    }


}
