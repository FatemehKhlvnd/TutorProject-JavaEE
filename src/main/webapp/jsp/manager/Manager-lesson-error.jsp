<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        header {
            background-color: #769FCD;
            color: white;
            padding: 2px;
            text-align: center;
            width: 100%;
            display: flex; /* اضافه شده */
            align-items: center;
        }
        nav{
            padding-left:360px;
        }
        nav a {
            color: white;
            text-align: center;
            text-decoration: none;
            padding: 15px 15px;

        }

        nav a:hover{
            background-color:#4F79AA ;

        }
        img{
            width:40px; /* اندازه تصویر */
            height: auto; /* حفظ نسبت ابعاد تصویر */
            margin-right:auto; /* فاصله از سمت راست هدر */
            margin-left: 10px;
        }
        /*content*/
    </style>
</head>
<body>
<header>
    <a href=""><img src="img/icons8-person-64.png" alt=""></a><strong>&nbsp;&nbsp;Welcome&nbsp; </strong><%=request.getUserPrincipal().getName()%>

    <nav>
        <a href="manager.jsp">Manager List</a>
        <a href="Manager-teacher.jsp">Teacher List</a>
        <a href="Manager-student.jsp">Student List</a>
        <a href="Manager-lesson.jsp">Lesson List</a>
        <a href="Manager-celass.jsp">Class List</a>
    </nav>
</header>
<h1 style="color: red">error page</h1>
</body>
</html>
