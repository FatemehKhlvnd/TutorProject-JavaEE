<!--<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            direction: rtl;
            font-family: Arial, sans-serif;
            background-color: #769FCD;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login-container {
            background-color: #fff;
            padding: 45px 60px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .login-container h2 {
            text-align: center;
            color: #333;
        }



        .form-group #buttonlog:hover {
            background-color: #4F79AA;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 100px;
            alignment: center;
            text-decoration: none;
            color: #fff;
            background-color: #769FCD;
            border: 1px solid #4F79AA;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        #m{
            padding: 10px 97px;
        }
        a:hover {
            background-color: #4F79AA;
        }
    </style>
</head>
<body>

<div class="login-container">
    <a id="m" href="jsp/manager/manager.jsp">Manager</a><br>
    <a href="jsp/teacher/Teacher-celass.jsp">Teacher</a><br>
    <a href="jsp/student/Student-index.jsp">Student</a>
</div>

</body>
</html>
