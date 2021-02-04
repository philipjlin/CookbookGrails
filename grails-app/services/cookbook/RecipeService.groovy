package cookbook

class RecipeService {

    /**
     *
     * Adds all comments to associated recipes so they can be displayed in the recipe show page or blog
     *
     */
    def static updateAllRecipes(){

        Comment.list().each{ comment ->

            if( !comment.recipe.comments.contains(comment) ){

                comment.recipe.comments.add(comment)
            }
        }
    }
}
