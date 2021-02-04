<%@ page import="cookbook.CookBook" %>



<div class="fieldcontain ${hasErrors(bean: cookBookInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="cookBook.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${cookbook.User.list()}" optionKey="id" required="" value="${cookBookInstance?.user?.id}" class="many-to-one"/>

</div>

