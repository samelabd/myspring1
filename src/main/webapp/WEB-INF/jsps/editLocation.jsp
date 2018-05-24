<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="showupdatedLocation" method="post">
		<pre>
		Id   : <input type="text" name="id" value="${location_.id }" readonly="readonly" /> 
		Code : <input type="text" name="code" value="${location_.code }" /> 

		Name : <input type="text" name="name" value="${location_.name }" />
				 
		Type : Urban<input type="radio" name="type" value="urban" ${location_.type=='urban'?'checked':'' }/> 
		Rural<input type="radio" name="type" value="rural" ${location_.type=='rural'?'checked':'' }/> 
		<input type="submit" value="update" />
</pre>
	</form>

</body>
</html>