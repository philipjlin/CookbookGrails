# Grails CookBook


## Repository
<https://github.com/philipjlin/CookbookGrails>


## Description
Version of CookBook (https://github.com/philipjlin/Cookbook) developed using Grails Framework.


## Technologies
Groovy, Grails, Spring


## High Level Components
    * Database with information about recipes
    * Table of user accounts with login and password info, with supporting operations
    * Table of recipes for each user, with supporting operations
    * User authentication service
    * CRUD operations controller for users
    * CRUD operations controller for recipes
    * Blog page for users
    * Administrator mode, with additional options
    * Detailed search bar for recipes in the database based on tags or keywords


## Class Overview
    Domain Objects
      - Comment - represents a comment on a recipe.
      - CookBook - represents a unique-to-each-user cookbook, which contains a list of recipes chosen by the user.
      - Recipe - represents a recipe with associated information.
      - Role - defines permissions users have.
      - User - represents a registered user on the site with at least 1 role.
      - UserRole - class that keeps track of user-role pairings.

<br>

    Controllers
      - CookBookController - used to render all views associated with the user's cookbook.
      - RecipeController - used to render all views associated with recipes and the recipe CRUD methods.
      - UserController - contains CRUD methods for users.

<br>

    Services
      - CookBookService - contains the logic methods used in managing the cookbook (add/remove), and stats.
      - RecipeService - contains methods that edit and update sections of recipes.

<br>

    Taglibs
      - CookBookTagLib - used to help render views of the different lists recipes by category, by sorting the recipes in a users cookbook by those categories.


## Views
    CookBook
      - blog
      - index (of recipe lists)
      - lists (breakfast, lunch, dinner, dessert)

<br>

    Recipe
       - index (of all recipes)
       - allrecipes (sorted)
       - create
       - edit
       - show (w/ add/delete from cookbook)
