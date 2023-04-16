# Grails CookBook


## Repository
<https://github.com/philipjlin/CookbookGrails>


## Description
Web application that serves as a digital recipe library for individuals who love to make food.

The application will store recipes, uploaded by registered users, in a central, shared database. Anyone will be able to access all recipes on the site, and use a search engine to construct queries for specific recipes. Individual recipes with photos can be displayed in their own page with ingredients, instructions, cooking time, and other searchable tags/parameters.

A user can create an account, and upon login will gain functionality to the cookbook feature of the site.

Registered users, when logged in, will be able to add recipes that they like to their own personal cookbook. The cookbook will be able aggregate and present these recipes by parameters such as course, cuisine type, or total cook time.

Registered users will also have a means means to upload recipes into the shared organized database using a template provided by the site.

There will also be a blog component to the site, which allows users a way to display all their recipes in a chronological style.


## Technologies
Project was developed in Groovy using the Grails framework.
Spring security framework used for authentication and authorization.


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
