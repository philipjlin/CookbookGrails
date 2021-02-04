<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>

	<body>

		<div id="create-recipe" class="content scaffold-create" role="main">

			<g:form controller="Recipe">

				<h3>Create A Recipe</h3>

				<label>Recipe Name</label>
				<g:textField name="name"/><br>

				<label>Prep Time</label>
				<g:field type="number" name="prepTime"/><br>

				<label>Cook Time</label>
				<g:field type="number" name="cookTime"/><br>

				<label>Procedure</label>
				<g:textField name="procedure"/><br>

				<label>Breakfast</label>
				<g:checkBox name="isBreakfast"/><br>

				<label>Lunch</label>
				<g:checkBox name="isLunch"/><br>

				<label>Dinner</label>
				<g:checkBox name="isDinner"/><br>

				<label>Dessert</label>
				<g:checkBox name="isDessert"/><br>

				<label>Published</label>
				<g:checkBox name="isPublished"/><br>

				<g:actionSubmit value="Create Recipe" action="save"/>

			</g:form>
		</div>

	</body>
</html>
