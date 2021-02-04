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

	<div class="row">

		<g:form controller="CookBook">
			<g:actionSubmit value="Breakfast" action="breakfast"/>
		</g:form>

		<g:form controller="CookBook">
			<g:actionSubmit value="Lunch" action="lunch"/>
		</g:form>

		<g:form controller="CookBook">
			<g:actionSubmit value="Dinner" action="dinner"/>
		</g:form>

		<g:form controller="CookBook">
			<g:actionSubmit value="Dessert" action="dessert"/>
		</g:form>

		<g:form controller="CookBook">
			<g:actionSubmit value="My Recipes" action="myRecipes"/>
		</g:form>

	</div>

</div>

</body>

</html>