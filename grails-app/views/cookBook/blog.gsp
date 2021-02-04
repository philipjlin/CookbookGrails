<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'cookBook.label', default: 'CookBook')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>

    <body>

        <div id="blog" class="container">

            <h2> ${user.username}'s Blog </h2>

            <g:each var="recipe" in="${recipes}">

                <g:if test="${recipe.isPublished == true}">

                    <g:render template="blogPost" model="[bean:recipe]" />

                    <g:form controller="Recipe" params="[recipeId:recipe.id]">

                        <label>Post A Comment!</label>
                        <g:textField name="text"/><br/>
                        <g:actionSubmit value="Post Comment!" action="addComment"/>
                    </g:form>
                </g:if>
                <br>
                <hr>
            </g:each>
        </div>

    </body>
</html>