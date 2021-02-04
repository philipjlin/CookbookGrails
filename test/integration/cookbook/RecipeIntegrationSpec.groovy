package cookbook

import grails.test.spock.IntegrationSpec

class RecipeIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test comment added to recipe"(){

        when:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
            def comment = new Comment(text:'test comment', datePublished:new Date(), author:'author', recipe:new Recipe())

            recipe.comments.add(comment)

        then:
            recipe.comments.size() == 1
    }

    void "test recipe created"(){

        when:
            Recipe recipe1 = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, user:new User(), comments:[])

        then:
            recipe1.validate()
    }

    void "test list of all recipes from user returned"(){

        when:
            CookBook cookBook1 = new CookBook(recipes:[])
            CookBook cookBook_admin = new CookBook(recipes:[])

            User user_admin = new User(username:'user_admin', password:'password', birthDate:Date.parse("MM-dd-yyyy", "01-14-1988"), cookBook:cookBook_admin, enabled:true)
            User user1 = new User(username:'user1', password:'password', birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), from:"Place", cookBook:cookBook1, enabled:true)

            Recipe recipe1 = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, user:user1, comments:[])
            Recipe recipe2 = new Recipe(name:'French Toast', prepTime:10, cookTime:10, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:true, isLunch:false, isDinner:false, isDessert:true, user:user_admin, comments:[])

            user1.cookBook.recipes.add(recipe1)
            user_admin.cookBook.recipes.add(recipe2)

        then:
            user1.cookBook.recipes.size() + user_admin.cookBook.recipes.size() == 2
    }

    void "test created recipe exists"(){

        when:
            Recipe recipe = Recipe.get(1)

        then:
            recipe.validate()
    }

}
