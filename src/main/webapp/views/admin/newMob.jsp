<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="mob" items="${mobs}">
		${area.name}
		<a href="deleteMob/${mob.id}">delete mob</a>
	</c:forEach>

	<form:form modelAttribute="mob" action="saveMob" method="post">
		<form:input path="name" placeholder="name" />
		<br>
		<form:input path="lvl" placeholder="lvl" />
		<br>
		<form:input path="hp" placeholder="hp" />
		<br>
		<form:input path="manapool" placeholder="manapool" />
		<br>
		<form:input path="attack" placeholder="attack" />
		<br>
		<form:input path="agr" placeholder="agr" />
		<br>
		
		<form:select path="areas" items="${areasDTOs}" itemLabel="name"
 			itemValue="id"> 
		</form:select>

<%-- 		<form:select path="mob"> --%>
<%-- 			<c:forEach var="mob" items="${mobs}"> --%>
<%-- 				<form:option value="${mob.name}">${mob.lvl}</form:option> --%>
<%-- 			</c:forEach> --%>
<%-- 		</form:select> --%>

		<button>save mob</button>
	</form:form>
</body>
</html>