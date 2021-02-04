<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="recipes" value="${bean}"/>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

            <g:each var="recipe" in="${recipes}">

                <h4><g:link controller="recipe" action="show" id="${recipe.id}">${fieldValue(bean: recipe, field: "name")}</g:link></h4>

                <g:link class="removeFromCookbook" controller="CookBook" params="[recipeId:recipe.id]" action="removeRecipeFromCookbook"><g:message message="Remove From Cookbook" /></g:link>
                <br><br>
            </g:each>
        </div>
    </div>

</div>