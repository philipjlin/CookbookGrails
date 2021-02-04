
<%@ page import="cookbook.Recipe" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-recipe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-recipe" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list recipe">
			
				<g:if test="${recipeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="recipe.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${recipeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.prepTime}">
				<li class="fieldcontain">
					<span id="prepTime-label" class="property-label"><g:message code="recipe.prepTime.label" default="Prep Time" /></span>
					
						<span class="property-value" aria-labelledby="prepTime-label"><g:fieldValue bean="${recipeInstance}" field="prepTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.cookTime}">
					<li class="fieldcontain">
						<span id="cookTime-label" class="property-label"><g:message code="recipe.cookTime.label" default="Cook Time" /></span>

							<span class="property-value" aria-labelledby="cookTime-label"><g:fieldValue bean="${recipeInstance}" field="cookTime"/></span>

					</li>
				</g:if>
			
				<g:if test="${recipeInstance?.procedure}">
					<li class="fieldcontain">
						<span id="procedure-label" class="property-label"><g:message code="recipe.procedure.label" default="Procedure" /></span>

							<span class="property-value" aria-labelledby="procedure-label"><g:fieldValue bean="${recipeInstance}" field="procedure"/></span>

					</li>
				</g:if>
			
				<g:if test="${recipeInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="recipe.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${recipeInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.isPublished}">
				<li class="fieldcontain">
					<span id="isPublished-label" class="property-label"><g:message code="recipe.isPublished.label" default="Is Published" /></span>
					
						<span class="property-value" aria-labelledby="isPublished-label"><g:formatBoolean boolean="${recipeInstance?.isPublished}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="recipe.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${recipeInstance?.user?.id}">${recipeInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>

				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div>Comments</div>
						<g:each var="comment" in="${recipeInstance?.comments}">
							${comment.text}
							${comment.author}
							${comment.datePublished}
							<br>
						</g:each>
					</div>
				</div>

				<g:form controller="Recipe" params="[recipeId:recipeInstance?.id]">

					<label>Post A Comment!</label>
					<g:textField name="text"/><br/>
					<g:actionSubmit value="Post Comment!" action="addComment"/>
				</g:form>
			
			</ol>

			<g:form url="[resource:recipeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${recipeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

					<g:link class="addToCookbook" controller="CookBook" params="[recipe:recipe]" action="addRecipeToCookbook"><g:message message="Add To Cookbook" /></g:link>
					<g:link class="removeFromCookbook" controller="CookBook" params="[recipe:recipe]" action="removeRecipeFromCookbook"><g:message message="Remove From Cookbook" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
