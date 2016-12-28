<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="inst" items="${insts}">
		<div style="background-color: aqua">
			${inst.name} <a href="deleteInst/${inst.id}">delete</a>
		</div>
		<br>
	</c:forEach>

<form:form modelAttribute="inst" action="saveInst" method="post">
	
	<form:input path="name" placeholder="inst name"/>
	<br>
	<form:input path="nameOfBoss" placeholder="boss name"/>
	<br>
	<form:select path="area" items="${areas}" itemLabel="name" itemValue="id" >
	</form:select>
	<button>save inst</button>

</form:form>
</body>
</html>