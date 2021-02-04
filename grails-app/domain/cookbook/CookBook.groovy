package cookbook

/**
 *
 * CookBook Domain Object
 *
 * Represents a cookbook for each user, with favorite recipes, organized
 * into various optional lists for easy reference
 * (i.e. breakfast, lunch, dinner, appetizer, main, and desserts)
 *
 */
class CookBook {

    static hasMany = [recipes:Recipe]

    enum Lists {

        BREAKFAST, LUNCH, DINNER, DESSERT, MYRECIPES
    }

    static constraints = {

        recipes nullable:false
    }
}
