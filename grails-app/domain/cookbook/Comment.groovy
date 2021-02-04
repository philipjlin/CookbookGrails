package cookbook

/**
 *
 * Comment Domain Object
 *
 * Represents an individual comment that can be created by a specific that will be added to a blog post of any user.
 *
 */
class Comment {

    String text
    String author
    Date datePublished

    static belongsTo = [recipe:Recipe]

    static constraints = {

        text type:'text', size:1..140
        author nullable:true
        datePublished max:(new Date())+1
    }
}
