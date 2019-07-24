<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
	<meta 
		http-equiv="Content-Type"
		content="text/html;charset=UTF-8"/>
		<meta charset="UTF-8"/>
	</head>
    <body>
        <sql:setDataSource var="ds" 
        driver="oracle.jdbc.OracleDriver" 
        url="jdbc:oracle:thin@//localhost:1527/XE"
        user="onlineshop"
        password="geheim_123"/>
        <sql:query dataSource="${ds}" var="reuslt">select email,password from onlineshop.customer</sql:query>
        <c:forEach 
        	var="row"
        	items="${result.rows}">
        	<c:out value="${row.email}"/>
        	<c:out value="${row.password}"/>
        	<br/>
        </c:forEach>	
    </body>
</html>