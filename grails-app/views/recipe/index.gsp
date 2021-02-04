
<%@ page import="cookbook.Recipe" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-recipe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-recipe" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'recipe.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="prepTime" title="${message(code: 'recipe.prepTime.label', default: 'Prep Time')}" />
					
						<g:sortableColumn property="cookTime" title="${message(code: 'recipe.cookTime.label', default: 'Cook Time')}" />
					
						<g:sortableColumn property="procedure" title="${message(code: 'recipe.procedure.label', default: 'Procedure')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'recipe.lastUpdated.label', default: 'Last Updated')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${recipeInstanceList}" status="i" var="recipeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${recipeInstance.id}">${fieldValue(bean: recipeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: recipeInstance, field: "prepTime")}</td>
					
						<td>${fieldValue(bean: recipeInstance, field: "cookTime")}</td>
					
						<td>${fieldValue(bean: recipeInstance, field: "procedure")}</td>
					
						<td><g:formatDate date="${recipeInstance.lastUpdated}" /></td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${recipeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
