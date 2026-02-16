<%@ page import="com.example.tutor.model.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="../../jquery-3.7.1.min.js" type="text/javascript"></script>
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
    </style>
    <style>

        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4F79AA;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #e6e6ff;
        }

        tr:nth-child(odd) {
            background-color: #e6e6ff;
        }
        tbody tr:hover {
            background-color: #769FCD;
            color: white;
        }
        /*body {*/
        /*    direction: rtl;*/
        /*    font-family: 'Arial', sans-serif;*/
        /*    margin: 0;*/
        /*    padding: 0;*/
        /*    display: flex;*/
        /*    align-items: center;*/
        /*    justify-content: center;*/
        /*    height: 100vh;*/
        /*    !*background-color: #B9D7EA;*!*/
        /*}*/

        /*.form-container {*/
        /*    background-color: #F7FBFC;*/
        /*    margin-top: 50px;*/
        /*    width: 400px;*/
        /*    padding: 20px;*/
        /*    border-radius: 10px;*/
        /*    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);*/
        /*}*/

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
        }

        input,
        textarea,select {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        #buttonm {
            padding: 10px;
            background-color: #769FCD;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #buttonm:hover {
            background-color: #3F72AF;
        }

        .content {
            width: 1200px;
            margin: 10px;
            padding: 10px;
            background-color: #F7FBFC;
            border: 2px solid #D6E6F2;
            border-radius: 10px;
            text-align: right;
        }
        .content2{
            position: relative;
            background-color: #D6E6F2;
            border: 2px solid #D6E6F2;
            border-radius: 10px;
            padding: 0px 30px 0px 0px;
            margin-bottom: 10px;

        }
        form{
            width: 400px;
            align-content: center;
            padding-left: 400px;
        }
        input{
            padding: 8px 18px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .content-row {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }
        .corner-image {
            position: absolute;
            top: 0;
            right: 0;
            max-width: 100px; /* عرض حداکثری تصویر را مشخص کنید */
            max-height: 100px; /* ارتفاع حداکثری تصویر را مشخص کنید */
            border-radius: 10px;
        }
        .co1 , .co2{
            margin-right: 80px;
        }
        ul {
            direction: rtl;
            text-align: right; /* این نیز میتواند بهترین گزینه باشد */
        }
        b{
            margin-right: 80px;
        }

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
</header><div class="content">

    <form action="${pageContext.request.contextPath}/Manager-student.do" method="POST">
        <label for="firstName">نام</label>
        <input type="text" id="firstName" name="firstName" required>

        <label for="lastName">نام خانوادگی</label>
        <input type="text" id="lastName" name="lastName" required>

<%--        <label for="grade">مقطع</label>--%>
<%--        <select id="grade" name="grade" required>--%>
<%--            <option value="" disabled selected>انتخاب مقطع</option>--%>
<%--            <option value="primary">متوسطه اول</option>--%>
<%--            <option value="secondary">متوسطه دوم</option>--%>
<%--        </select>--%>

        <label for="username">گذزواژه</label>
        <input type="text" id="username" name="username" required>
        <label for="password">رمز عبور</label>
        <input type="password" id="password" name="password" required>
        <input id="buttonm" type="submit" value="ثبت">
    </form>
    <h1>Student List</h1>

    <table class="table" id="lessonTable"  >
        <thead>
        <tr>

            <th>name</th>
            <th>family</th>
            <th>grade</th>
            <th>username</th>
            <th>password</th>
            <th>operation</th>

        </tr>
        </thead>
        <tbody>
        </tbody>
        <tbody id="studentTableBody">

        </tbody>
    </table>


</div>


<script>
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/Manager-student-table.do", // Update with your servlet URL for fetching student data
            dataType: "json",
            success: function(data) {
                var htmlContent = "";

                // Iterate through the array and create table rows
                $.each(data, function(index, student) {
                    htmlContent += '<tr>';
                    htmlContent += '<td>' + student.name + '</td>';
                    htmlContent += '<td>' + student.family + '</td>';
                    htmlContent += '<td>' + student.username + '</td>';
                    htmlContent += '<td>' + student.password + '</td>';
                    htmlContent += '<td>';
                    htmlContent += '<button onclick="editStudent(' + student.id + ')">Edit</button>';
                    htmlContent += ' <button onclick="deleteStudent(' + student.id + ')">Delete</button>';
                    htmlContent += '</td>';
                    htmlContent += '</tr>';
                });

                // Update the content of the 'studentTableBody' with the created HTML
                $('#studentTableBody').html(htmlContent);
            },
            error: function() {
                console.error('Failed to fetch student data.');
            }
        });
    });

    // Define functions for handling Edit and Delete actions for students
    function editStudent(studentId) {
        // Implement the logic for editing a student
        console.log('Edit student with ID: ' + studentId);
    }

    function deleteStudent(studentId) {
        // Implement the logic for deleting a student
        console.log('Delete student with ID: ' + studentId);
    }
</script>



</body>
</html>
