package cookbook

/**
 *
 * Recipe Domain Object
 *
 * Represents an individual recipe contributed by a particular user.
 *
 */
class Recipe {

    String name
    int prepTime
    int cookTime
    String procedure

    Date lastUpdated
    boolean isPublished
    boolean isBreakfast
    boolean isLunch
    boolean isDinner
    boolean isDessert

    User user

    static hasMany = [comments:Comment]

    static constraints = {

        name blank:false
        prepTime min:0, max:999
        cookTime min:0, max:999
        procedure blank:false
        lastUpdated max:(new Date())+1
        user nullable:true
    }
}
