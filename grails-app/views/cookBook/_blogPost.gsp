<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="recipe" value="${bean}"/>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>
                <td><g:link controller="recipe" action="show" id="${recipe.id}">${fieldValue(bean: recipe, field: "name")}</g:link></td>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div> ${recipe.procedure} </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Prep Time: ${recipe.prepTime} Cook Time: ${recipe.cookTime}</div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Last Edited: ${recipe.lastUpdated}</div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Creator: ${recipe.user.username}</div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <g:if test="${recipe.isBreakfast}">
                Breakfast
            </g:if>
            <g:if test="${recipe.isLunch}">
                Lunch
            </g:if>
            <g:if test="${recipe.isDinner}">
                Dinner
            </g:if>
            <g:if test="${recipe.isDessert}">
                Dessert
            </g:if>
        </div>
    </div>


    <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div>Comments</div>
            <g:each var="comment" in="${recipe.comments}">
                ${comment.text}
                ${comment.author}
                ${comment.datePublished}
                <br>
            </g:each>
        </div>
    </div>

</div>