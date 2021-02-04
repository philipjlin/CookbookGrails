# Grails CookBook


## Repository
<https://github.com/philipjlin/Cookbook_Grails>


## Description
Version of CookBook (https://github.com/philipjlin/Cookbook) developed using Grails Framework.


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
Domain Objects <br>
    - Comment - represents a comment on a recipe. <br>
    - CookBook - represents a unique-to-each-user cookbook, which contains a list of recipes chosen by the user. <br>
    - Recipe - represents a recipe with associated information. <br>
    - Role - defines permissions users have. <br>
    - User - represents a registered user on the site with at least 1 role. <br>
    - UserRole - class that keeps track of user-role pairings. <br>

Controllers <br>
    - CookBookController - used to render all views associated with the user's cookbook, including different lists of recipes by category and the blog. <br>
    - RecipeController - used to render all views associated with recipes and the recipe CRUD methods. Also used to add comments to recipes. <br>
    - UserController - contains CRUD methods for users. <br>

Services <br>
    - CookBookService - contains the logic methods used in managing the cookbook, including statistics about the cookbook and methods for adding and removing recipes from the cookbook. <br>
    - RecipeService - contains methods that edit and update sections of recipes. <br>

Taglibs <br>
    - CookBookTagLib - used to help render views of the different lists recipes by category, by sorting the recipes in a users cookbook by those categories.


## Views
CookBook <br>
    - blog <br>
    - index (of recipe lists) <br>
    - lists (breakfast, lunch, dinner, dessert) <br>

Recipe <br>
    - index (of all recipes) <br>
    - allrecipes (sorted) <br>
    - create <br>
    - edit <br>
    - show (w/ add/delete from cookbook) <br>
