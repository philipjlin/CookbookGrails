package cookbook

/**
 * This taglib is used to display all recipes (from all users) on the recipe index page sorted by the lists
 */
class RecipesTagLib {

    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "lists"

    /**
     * Taglib for displaying breakfast recipes in a persons cookbook
     *
     */
    def breakfasts = { attrs, body ->

        def allUsers = attrs.allUsers

        def breakfasts = []

        allUsers.each{ user ->

            user.cookBook.recipes.each{ recipe ->

                if( recipe.isBreakfast && !breakfasts.contains(recipe) )
                    breakfasts.add(recipe)
            }
        }

        out << render(template:'recipeList', model:[recipes:breakfasts])
    }

    /**
     * Taglib for displaying lunch recipes in a persons cookbook
     *
     */
    def lunches = { attrs, body ->

        def allUsers = attrs.allUsers
        def lunches = []

        allUsers.each{ user ->

            user.cookBook.recipes.each{ recipe ->

                if( recipe.isLunch && !lunches.contains(recipe) )
                    lunches.add(recipe)
            }
        }

        out << render(template:'recipeList', model:[recipes:lunches])
    }

    /**
     * Taglib for displaying lunch recipes in a persons cookbook
     *
     */
    def dinners = { attrs, body ->

        def allUsers = attrs.allUsers
        def dinners = []

        allUsers.each{ user ->

            user.cookBook.recipes.each{ recipe ->

                if( recipe.isDinner && !dinners.contains(recipe) )
                    dinners.add(recipe)
            }
        }

        out << render(template:'recipeList', model:[recipes:dinners])
    }

    /**
     * Taglib for displaying lunch recipes in a persons cookbook
     *
     */
    def desserts = { attrs, body ->

        def allUsers = attrs.allUsers
        def desserts = []

        allUsers.each{ user ->

            user.cookBook.recipes.each{ recipe ->

                if( recipe.isDessert && !desserts.contains(recipe) )
                    desserts.add(recipe)
            }
        }

        out << render(template:'recipeList', model:[recipes:desserts])
    }
}
