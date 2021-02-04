import cookbook.CookBook
import cookbook.CookBookService
import cookbook.Recipe
import cookbook.Role
import cookbook.User
import cookbook.UserRole
import cookbook.*

class BootStrap {

    def init = { servletContext ->


        Role admin = new Role('ROLE_ADMIN')
        Role user = new Role('ROLE_USER')
        admin.save(failOnError:true)
        user.save(failOnError:true)


        CookBook cookBook1 = new CookBook(recipes:[])
        CookBook cookBook2 = new CookBook(recipes:[])
        cookBook1.save(failOnError:true)
        cookBook2.save(failOnError:true)


        User user1 = new User(username:'user1', password:'password', birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), from:"Place", cookBook:cookBook1, enabled:true)
        User user2 = new User(username:'user2', password:'password', birthDate:Date.parse("MM-dd-yyyy", "01-14-1988"), cookBook:cookBook2, enabled:true)
        user1.save(flush:true)
        user2.save(flush:true)


        UserRole.create(user1, user).save(flush:true)
        UserRole.create(user2, admin).save(flush:true)


        Recipe recipe1 = new Recipe(name:'Beef Stew', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:false, isDinner:true, isDessert:false, user:user1, comments:[])
        Recipe recipe2 = new Recipe(name:'French Toast', prepTime:10, cookTime:10, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:true, isLunch:false, isDinner:false, isDessert:true, user:user1, comments:[])
        Recipe recipe3 = new Recipe(name:'Eggs Benedict', prepTime:30, cookTime:60, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:true, isLunch:false, isDinner:false, isDessert:false, user:user1, comments:[])
        Recipe recipe4 = new Recipe(name:'Fried Chicken', prepTime:30, cookTime:20, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:false, isLunch:true, isDinner:true, isDessert:false, user:user1, comments:[])
        Recipe recipe5 = new Recipe(name:'Yogurt Parfait', prepTime:5, cookTime:0, procedure:'procedure', lastUpdated:new Date(), isPublished:true, isBreakfast:true, isLunch:false, isDinner:false, isDessert:true, user:user2, comments:[])


        recipe1.save(failOnError:true)
        recipe2.save(failOnError:true)
        recipe3.save(failOnError:true)
        recipe4.save(failOnError:true)
        recipe5.save(failOnError:true)


        user1.cookBook.recipes.add(recipe1)
        user1.cookBook.recipes.add(recipe2)
        user1.cookBook.recipes.add(recipe3)
        user1.cookBook.recipes.add(recipe4)
        user2.cookBook.recipes.add(recipe5)
        user1.save(failOnError:true)
        user2.save(failOnError:true)


        CookBookService.updateAllCookBooks()
    }

    def destroy = {
    }
}
