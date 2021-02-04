package cookbook

import grails.test.spock.IntegrationSpec

class CookBookIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    def cookBookService

    void "test recipe added to cookbook"(){

        when:
            Recipe recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
            CookBook cookBook = new CookBook(recipes:[])

            cookBookService.addRecipeToCookBook(cookBook, recipe)

        then:
            cookBook.recipes.size() == 1
    }

    void "test recipe removed from cookbook"(){

        when:
            Recipe recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
            Recipe recipe1 = new Recipe(name:'French Toast', prepTime:10, cookTime:10, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:true, isLunch:false, isDinner:false, isDessert:true, user:new User(), comments:[])
            CookBook cookBook = new CookBook(recipes:[])

            cookBookService.addRecipeToCookBook(cookBook, recipe)
            cookBookService.addRecipeToCookBook(cookBook, recipe1)

            cookBookService.removeRecipeFromCookBook(cookBook, recipe1)

        then:
            cookBook.recipes.size() == 1
    }

    void "test list returned correctly from a cookbook instance"(){

        given:
            def recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
            def recipe1 = new Recipe(name:'Fried Chicken', prepTime:30, cookTime:20, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:true, isDinner:true, isDessert:false, user:new User(), comments:[])
            def cookBook = new CookBook(recipes:[])

            cookBookService.addRecipeToCookBook(cookBook, recipe)
            cookBookService.addRecipeToCookBook(cookBook, recipe1)

        when:
            def breakfasts = cookBookService.returnRecipesList(cookBook, CookBook.Lists.BREAKFAST)
        then:
            breakfasts.size() == 0

        when:
            def lunches = cookBookService.returnRecipesList(cookBook, CookBook.Lists.LUNCH)
        then:
            lunches.size() == 1

        when:
            def dinners = cookBookService.returnRecipesList(cookBook, CookBook.Lists.DINNER)
        then:
            dinners.size() == 2

        when:
            def desserts = cookBookService.returnRecipesList(cookBook, CookBook.Lists.DESSERT)
        then:
            desserts.size() == 0
    }

    void "test list of recipes in a user cookbook exists"(){

        when:
            Recipe recipe = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, comments:[])
            User user1 = new User(username:'user1', password:'password', birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), from:"Place", cookBook:new CookBook(recipes:[]), enabled:true)

            recipe.user = user1

        then:
            recipe.validate()
    }

}