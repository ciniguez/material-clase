<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<!-- link rel="stylesheet" href="../css/estilos.css" -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />

</head>
<body>


<%@include file='../templates/banner.html'%>

<!-- Internacionalizacion -->
<a href="login.jsp?locale=en">ingles</a>
<a href="login.jsp?locale=es_ES">español</a>
<a href="login.jsp?">auto</a>


<c:if test="${param.locale!=null}">
	<h1>${param.locale}</h1>
    <fmt:setLocale value="${param.locale} scope=”session" />
</c:if>
<fmt:setBundle basename="recursos.idioma" />


	<div class="wrapper">
		<div id="formContent">

			<!-- Login Form -->
			<form action="../FrontController?ruta=autenticar" method="POST">
				<fieldset>
					<legend><fmt:message key="title.login.form"/></legend>

					<p><fmt:message key="label.login.user"/>:</p>
					<input type="text" name="usuario" />
					
					<br>
					<p><fmt:message key="label.login.pass"/>:</p>
					<input type="password" name="password" /> 
					
					<br><br><br>
					<input type="submit"
						value="<fmt:message key="label.login.enter"/>" />
					<br><br><br>
				</fieldset>
			</form>


		</div>
	</div>





	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>