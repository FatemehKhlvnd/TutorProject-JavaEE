<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/StudentMoshakhasat.css">
</head>
<body>
<jsp:include page="StudentMenu.jsp"></jsp:include>
<div class="content">

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
</div>
</body>
</html>
