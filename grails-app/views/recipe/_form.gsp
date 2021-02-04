<%@ page import="cookbook.Recipe" %>



<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="recipe.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${recipeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'prepTime', 'error')} required">
	<label for="prepTime">
		<g:message code="recipe.prepTime.label" default="Prep Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="prepTime" type="number" min="0" max="1000" value="${recipeInstance.prepTime}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'cookTime', 'error')} required">
	<label for="cookTime">
		<g:message code="recipe.cookTime.label" default="Cook Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cookTime" type="number" min="0" max="1000" value="${recipeInstance.cookTime}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'procedure', 'error')} required">
	<label for="procedure">
		<g:message code="recipe.procedure.label" default="Procedure" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="procedure" required="" value="${recipeInstance?.procedure}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'datePublished', 'error')} ">
	<label for="datePublished">
		<g:message code="recipe.datePublished.label" default="Date Published" />
		
	</label>
	<g:datePicker name="datePublished" precision="day"  value="${recipeInstance?.datePublished}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'isPublished', 'error')} ">
	<label for="isPublished">
		<g:message code="recipe.isPublished.label" default="Is Published" />
		
	</label>
	<g:checkBox name="isPublished" value="${recipeInstance?.isPublished}" />

</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="recipe.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${cookbook.User.list()}" optionKey="id" required="" value="${recipeInstance?.user?.id}" class="many-to-one"/>

</div>

