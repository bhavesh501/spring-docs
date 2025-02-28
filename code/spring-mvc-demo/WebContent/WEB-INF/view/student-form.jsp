<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
Fist Name: <form:input path="firstName"/>
<br/>
Last Name: <form:input path="lastName"/>
<br/>
Country:
<form:select path="country">
    <form:options items="${student.countryOptions}" />
</form:select>
<br/>
Favourite Language:

Java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
<br><br>
Operating Systems:

Linux <form:checkbox path="operatingSystems" value="Linux"/>
Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
Windows <form:checkbox path="operatingSystems" value="Windows"/>

<br><br>
<input type="submit" value="Submit" />
</form:form>
</body>
</html>