<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.tutor.service.StudentService" %>
<%@ page import="com.example.tutor.service.Impl.LessonServiceImpl" %>
<%@ page import="com.example.tutor.model.entity.Lesson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="">
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="../../jquery-3.7.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/StudentIndexStyle.css">
</head>
<body>
<header class="header1">
<strong>&nbsp;&nbsp;Welcome&nbsp; </strong><%=request.getUserPrincipal().getName()%>

    <nav class="nav1">

        <a  href="#">Home page</a>
        <a href="Student-moshakhasat.jsp">Specification</a>
        <a href="#">FAQ</a>

    </nav>
</header>
<header class="header2">
    <nav class="nav2">



    </nav>
</header>


<div class="content">

    <img class="main-img" src="img/20824329_6342486.jpg" alt="">

    <table class="table" id="lessonTable"  >
        <thead>
        <tr>
            <th>Name</th>
                  <th>Family</th>
                  <th>Education</th>
                  <th>Specification</th>

            <th>operation</th>
        </tr>
        </thead>
        <tbody id="teacherTableBody">

        </tbody>
    </table>

</div>

<script>
    // Use jQuery to perform an AJAX request when the page loads
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/find-teacher-table.do", // Update with your servlet URL
            dataType: "json",
            success: function(data) {
                console.log('Response Data:', data);
                // Assuming 'data' is an array of teachers
                var htmlContent = "";

                // Iterate through the array and create table rows
                $.each(data, function(index, teacher) {
                    htmlContent += '<tr>';
                    htmlContent += '<td>' + teacher.username + '</td>';
                    htmlContent += '<td>' + teacher.name + '</td>';
                    htmlContent += '<td>' + teacher.family + '</td>';
                    htmlContent += '<td>' + teacher.education + '</td>';
                    htmlContent += '<td>' + teacher.specification + '</td>';
                    // Add any other columns as needed
                    htmlContent += '<td>';
                    htmlContent += '<button onclick="editTeacher(' + teacher.id + ')">choose</button>';
                    htmlContent += '</td>';
                    htmlContent += '</tr>';
                });

                // Update the content of the 'teacherTableBody' with the created HTML
                $('#teacherTableBody').html(htmlContent);
            },
            error: function() {
                console.error('Failed to fetch teacher data.');
            }
        });
    });
</script>

<script>
    // Use jQuery to perform an AJAX request when the page loads
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/Student-lesson.do", // Update with your servlet URL
            dataType: "json",
            success: function(data) {
                console.log("log1")
                // Assuming 'data' is an array of lessons
                var htmlContent = "";
                console.log("log2")
                // Iterate through the array and create links
                $.each(data, function(index, lesson) {
                    console.log("log3")
                    htmlContent += '<a href="#" class="lessonLink" data-lesson-id="' + lesson.id + '">' + lesson.name + '</a>';

                });
                console.log("log4");

                // Update the content of the 'nav2' with the created HTML
                $('.nav2').html(htmlContent);
            },
            error: function() {
                console.error('Failed to fetch lesson data.');
            }
        });
    });
</script>
<script>
    $(document).ready(function() {
        // Attach a click event handler to all anchor tags inside '.nav2'
        $('.nav2').on('click', 'a', function(event) {
            event.preventDefault(); // Prevent the default behavior of the anchor tag

            var selectedLessonName = $(this).text(); // Get the text of the clicked anchor tag
            var selectedLessonId = $(this).data('lesson-id'); // Corrected to match the attribute name

            console.log('Selected Lesson Name: ' + selectedLessonName);
            console.log('Selected Lesson Id: ' + selectedLessonId);

            // Make an AJAX request to the servlet with the selected lesson name and id
            $.ajax({
                type: "POST",
                url: "/Find-Teacher.do", // Update with the actual URL of your servlet
                data: {
                    lessonName: selectedLessonName,
                    lessonId: selectedLessonId
                }, // Send the selected lesson name and id as parameters
                success: function(response) {
                    console.log('Servlet response: ' + response);
                    // Handle the response from the servlet as needed
                },
                error: function() {
                    console.error('Failed to send data to servlet.');
                }
            });
        });
    });
</script>


</body>
</html>
