<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'cookBook.label', default: 'CookBook')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>

    <h2> ${user.id}'s CookBook </h2>

    <div class="container">

        <h4> ${listName} </h4>

        <g:each var="recipe" in="${recipes}">
            <g:if test="${recipe.isPublished == true}">
                <g:render template="cookBookPage" model="[bean:recipe]" />
            </g:if>
        </g:each>
    </div>

</body>

</html>