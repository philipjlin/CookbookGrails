package cookbook

/**
 * This service defines logic methods pertaining to how the cookbook is displayed
 */
class CookBookService {

    /**
     *
     * Adds a recipe to a user's cookbook
     *
     * @param cookBook
     * @param recipe
     */
    def addRecipeToCookBook(CookBook cookBook, Recipe recipe){

        if( !cookBook.recipes.contains(recipe) )
            cookBook.recipes << recipe
    }

    /**
     *
     * Removes a recipe from a user's cookbook
     *
     * @param cookBook
     * @param recipe
     */
    def removeRecipeFromCookBook(CookBook cookBook, Recipe recipe){

            cookBook.recipes.remove(recipe)
    }

    /**
     *
     * Checks the recipes in a users cookbook for a specified tag, and returns a list
     * of recipes that have a match to the tag. This method is used to sort the cookbook
     * into lists.
     *
     * @param cookbook
     * @param listToMatch
     * @return list of matches
     */
    def returnRecipesList(CookBook cookbook, CookBook.Lists list){

        def recipesList = []

        if( list.equals(CookBook.Lists.BREAKFAST) ) {

            cookbook.recipes.each { recipe ->

                if (recipe.isBreakfast)
                    recipesList.add(recipe)
            }
        }


        if( list.equals(CookBook.Lists.LUNCH) ) {

            cookbook.recipes.each { recipe ->

                if (recipe.isLunch)
                    recipesList.add(recipe)
            }
        }

        if( list.equals(CookBook.Lists.DINNER)) {

            cookbook.recipes.each { recipe ->

                if (recipe.isDinner)
                    recipesList.add(recipe)
            }
        }

        if( list.equals(CookBook.Lists.DESSERT)) {

            cookbook.recipes.each { recipe ->

                if (recipe.isDessert)
                    recipesList.add(recipe)
            }
        }

        recipesList
    }

    /**
     *
     * Adds all recipes to the cookbooks of the users that created them with the myrecipe tag,
     * so that they can be displayed in the My Recipes list of the cookbook
     *
     */
    def static updateAllCookBooks(){

        Recipe.list().each{ recipe ->

            if( !recipe.user.cookBook.recipes.contains(recipe) ){

                recipe.user.cookBook.recipes.add(recipe)
            }
        }
    }

}
