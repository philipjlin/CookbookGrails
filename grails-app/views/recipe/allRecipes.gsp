<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cookbook.User" %>


<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>

    <h2> Recipes Database </h2>

    <div id="recipes">

        <h4> Breakfasts </h4>
        <lists:breakfasts allUsers="${allUsers}"/>

        <h4> Lunches </h4>
        <lists:lunches allUsers="${allUsers}"/>

        <h4> Dinners </h4>
        <lists:dinners allUsers="${allUsers}"/>

        <h4> Desserts </h4>
        <lists:desserts allUsers="${allUsers}"/>
    </div>

</body>
</html>