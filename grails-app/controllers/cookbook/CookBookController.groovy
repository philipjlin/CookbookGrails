package cookbook


import org.springframework.security.access.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["ROLE_USER", "ROLE_ADMIN"])
class CookBookController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def cookBookService
    def springSecurityService


    /**
     *
     * Adds a specified recipe passed from the parameters to the cookbook of the current logged in user
     */
    @Transactional()
    def addRecipeToCookbook(){

        CookBookService.updateAllCookBooks()

        def user = User.get(springSecurityService.principal.id)
        def recipe = Recipe.get(params.recipeId)

        cookBookService.addRecipeToCookBook(user.cookBook, recipe)

        user.save(failOnError:true)

        render(view:"index", model:[user:user])
    }


    /**
     *
     * Removes a specified recipe passed from the parameters from the cookbook of the current logged in user
     */
    @Transactional()
    def removeRecipeFromCookbook(){

        def user = User.get(springSecurityService.principal.id)
        def recipe = Recipe.get(params.recipeId)

        cookBookService.removeRecipeFromCookBook(user.cookBook, recipe)

        user.save(failOnError:true)

        render(view:"index", model:[user:User.get(springSecurityService.principal.id)])

    }

    /*
     * Use the recipes list in the cookbook of the user to get a list of all the recipes tagged as
     * breakfasts, lunch, dinner, or dessert to be passed to the view
     */
    def breakfast(){

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        def listToReturn = cookBookService.returnRecipesList(user.cookBook, CookBook.Lists.BREAKFAST)

        render(view:'cookBookList', model:[user:user, recipes:listToReturn, listName:"Breakfasts"])
    }

    def lunch(){

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        def listToReturn = cookBookService.returnRecipesList(user.cookBook, CookBook.Lists.LUNCH)

        render(view:'cookBookList', model:[user:user, recipes:listToReturn, listName:"Lunches"])
    }

    def dinner(){

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        def listToReturn = cookBookService.returnRecipesList(user.cookBook, CookBook.Lists.DINNER)

        render(view:'cookBookList', model:[user:user, recipes:listToReturn, listName:"Dinners"])
    }

    def dessert(){

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        def listToReturn = cookBookService.returnRecipesList(user.cookBook, CookBook.Lists.DESSERT)

        render(view:'cookBookList', model:[user:user, recipes:listToReturn, listName:"Desserts"])
    }

    /**
     *
     * Returns a list of all the recipes that a user has created
     */
    def myRecipes(){

        def user = User.get(springSecurityService.principal.id)
        def myRecipes = []


        Recipe.list().each { recipe ->

            if( recipe.user.equals(user) )
                myRecipes.add(recipe)
        }

        render(view:'myrecipes', model:[user:user, recipes:myRecipes])
    }

    /**
     * Displays all the recipes of a particular user in the style of a blog
     */
    def blog(){

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()


        def recipesInBlog = []


        user.cookBook.recipes.each{ recipe ->

            recipesInBlog.add(recipe)
        }

        render(view:'blog', model:[recipes:recipesInBlog, user:user])
    }

    /**
     * Method for obtaining a user cookbook's index page
     *
     * Contains functionality to sort the layout of the cookbook based on various criteria
     */
    def index() {

        def user = User.get(springSecurityService.principal.id)

        CookBookService.updateAllCookBooks()

        render(view:'index', model:[user:user])
    }

    def show(CookBook cookBookInstance) {
        respond cookBookInstance
    }

    def create() {
        respond new CookBook(params)
    }

    @Transactional
    def save(CookBook cookBookInstance) {
        if (cookBookInstance == null) {
            notFound()
            return
        }

        if (cookBookInstance.hasErrors()) {

            respond cookBookInstance.errors, view:'create'
            return
        }

        cookBookInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cookBook.label', default: 'CookBook'), cookBookInstance.id])
                redirect cookBookInstance
            }
            '*' { respond cookBookInstance, [status: CREATED] }
        }
    }

    def edit(CookBook cookBookInstance) {
        respond cookBookInstance
    }

    @Transactional
    def update(CookBook cookBookInstance) {
        if (cookBookInstance == null) {
            notFound()
            return
        }

        if (cookBookInstance.hasErrors()) {
            respond cookBookInstance.errors, view:'edit'
            return
        }

        cookBookInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CookBook.label', default: 'CookBook'), cookBookInstance.id])
                redirect cookBookInstance
            }
            '*'{ respond cookBookInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CookBook cookBookInstance) {

        if (cookBookInstance == null) {
            notFound()
            return
        }

        cookBookInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CookBook.label', default: 'CookBook'), cookBookInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cookBook.label', default: 'CookBook'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

}
