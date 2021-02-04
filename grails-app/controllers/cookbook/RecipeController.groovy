package cookbook


import org.springframework.security.access.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(["ROLE_USER", "ROLE_ADMIN"])
class RecipeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService

    /**
     * Adds a comment to a recipe's list of comments
     */
    @Transactional
    def addComment(){

        def recipe = Recipe.get(params.recipeId)

        def commentToAdd = new Comment(text:params.text, datePublished:new Date(), recipe:recipe)
        commentToAdd.save(failOnError:true)

        recipe.comments.add(commentToAdd)
        recipe.save(failOnError:true)

        redirect(url:"/recipe/show/${params.recipeId}")
    }

    /**
     * Returns the view for all recipes from all users sorted by lists
     */
    def allRecipes(){

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        def allUsers = User.list()

        render(view:"allRecipes", model:[allUsers:allUsers])
    }

    /**
     * Returns the view for all recipes sortable by recipe fields
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Recipe.list(params), model:[recipeInstanceCount: Recipe.count()]
    }

    /**
     *
     * Shows a recipe, with options to add or remove the recipe from a user's cookbook
     * @param recipeInstance
     * @return
     */
    def show(Recipe recipeInstance) {

        CookBookService.updateAllCookBooks()
        RecipeService.updateAllRecipes()

        respond recipeInstance
    }

    def create() {

        respond new Recipe(params)
    }

    @Transactional
    def save(Recipe recipeInstance) {
        if (recipeInstance == null) {
            notFound()
            return
        }

        if (recipeInstance.hasErrors()) {
            respond recipeInstance.errors, view:'create'
            return
        }

        def user = User.get(springSecurityService.principal.id)

        recipeInstance.user = user
        recipeInstance.lastUpdated = new Date()
        recipeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipeInstance.id])
                redirect recipeInstance
            }
            '*' { respond recipeInstance, [status: CREATED] }
        }
    }

    def edit(Recipe recipeInstance) {
        respond recipeInstance
    }

    @Transactional
    def update(Recipe recipeInstance) {
        if (recipeInstance == null) {
            notFound()
            return
        }

        if (recipeInstance.hasErrors()) {
            respond recipeInstance.errors, view:'edit'
            return
        }

        recipeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Recipe.label', default: 'Recipe'), recipeInstance.id])
                redirect recipeInstance
            }
            '*'{ respond recipeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Recipe recipeInstance) {

        if (recipeInstance == null) {
            notFound()
            return
        }

        recipeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Recipe.label', default: 'Recipe'), recipeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
