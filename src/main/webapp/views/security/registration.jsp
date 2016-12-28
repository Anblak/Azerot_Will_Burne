<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<form:form modelAttribute="user" action="registration" method="post">

<fieldset>
${usernameException}

</fieldset>
<input name="name" class="validate[required,custom[username],length[0,100]] feedback-input" placeholder="name ${usernameException}">
<input name="email" type="email" placeholder="email">
<input name="password" type="password"" placeholder="password">
<button>save user</button>
</form:form>
