<%@ page import="com.example.tutor.model.entity.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage teacher</title>
    <link rel="stylesheet" href="css/TeacherMoshakhasatStyle.css">
</head>
<body>
<header>
    <a href=""><img src="img/icons8-person-64.png" alt=""></a>
    <%=request.getUserPrincipal().getName()%>
    <nav>
        <a href="Teacher-celass.jsp">Class List</a>
        <a href="Teacher-moshakhasat.jsp">Specification</a>
    </nav>
    <p></p>
</header>

<form action="#" method="POST">
    <label for="firstName">نام</label>
    <input type="text" id="firstName" name="firstName" value="<%=request.getUserPrincipal().getName()%>" required>

    <label for="lastName">نام خانوادگی</label>
    <input type="text" id="lastName" name="lastName" required>

    <label for="grade">مقطع</label>
    <select id="grade" name="grade" required>
        <option value="" disabled selected>انتخاب مقطع</option>
        <option value="primary">متوسطه اول</option>
        <option value="secondary">متوسطه دوم</option>
    </select>

    <label for="username">گذزواژه</label>
    <input type="text" id="username" name="firstName" required>
    <label for="password">رمز عبور</label>
    <input type="password" id="password" name="password" required>
    <input id="buttonm" type="submit" value="ثبت">
</form>
</body>
</html>
