<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="../../jquery-3.7.1.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="css/StudentLessonStyle.css">
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
    <!-- تگ‌های a ایجاد شده به صورت دینامیک توسط AJAX پر می‌شوند -->
  </nav>
</header>

<div class="content" >

  <form id="flesson" action="${pageContext.request.contextPath}/Manager-lesson.do" method="post">
    <label id="llesson" for="lessonName">نام درس</label>
    <br>
    <input type="text" id="lessonName" name="lessonName" required><br>

    <button id="btnlesson" type="submit">ثبت</button>
  </form>

  <h1>لیست درس ها</h1>
  <table class="table" id="lessonTable"  >
    <thead>
    <tr>
      <th>Name</th>
<%--      <th>Family</th>--%>
<%--      <th>Education</th>--%>
<%--      <th>Specification</th>--%>

      <th>operation</th>
    </tr>
    </thead>
    <tbody id="lessonTableBody">

    </tbody>
  </table>
</div>

<script>
  // Use jQuery to perform an AJAX request when the page loads
  $(document).ready(function() {
    $.ajax({
      type: "GET",
      url: "/Find-Teacher.do", // Update with your servlet URL
      dataType: "json",
      success: function(data) {
        // Assuming 'data' is an array of lessons
        var htmlContent = "";

        // Iterate through the array and create table rows
        $.each(data, function(index, lesson) {
          htmlContent += '<tr>';
          htmlContent += '<td>' + lesson.username + '</td>';
          // htmlContent += '<td>' + lesson.name + '</td>';
          // Add any other columns as needed
          htmlContent += '<td>';
          htmlContent += '<button onclick="editLesson(' + lesson.id + ')">Edit</button>';
          htmlContent += ' <button onclick="deleteLesson(' + lesson.id + ')">Delete</button>';
          htmlContent += '</td>';
          htmlContent += '</tr>';
        });

        // Update the content of the 'lessonTableBody' with the created HTML
        $('#lessonTableBody').html(htmlContent);
      },
      error: function() {
        console.error('Failed to fetch lesson data.');
      }
    });
  });

</script>
<script>
  $(document).ready(function() {
    $.ajax({
      type: "GET",
      url: "/Student-lesson.do",
      dataType: "json",
      success: function(data) {
        var htmlContent = "";

        $.each(data, function(index, lesson) {
          htmlContent += '<a href="#" class="lessonLink" data-lesson-id="' + lesson.id + '">' + lesson.name + '</a>';
        });

        $('.nav2').html(htmlContent);

        // افزودن رویداد کلیک به تگ‌های a
        $('.lessonLink').click(function(e) {
          e.preventDefault();

          // دریافت شناسه درس از دیتا-آتریبیوت (data-attribute)
          var lessonId = $(this).data('lesson-id');

          // اجرای درخواست AJAX به Servlet جدید
          $.ajax({
            type: "GET",
            url: "/LessonDetailsServlet?lessonId=" + lessonId,
            dataType: "json",
            success: function(details) {
              // اینجا می‌توانید اطلاعات دریافتی را در صفحه نمایش دهید
              console.log(details);
            },
            error: function() {
              console.error('Failed to fetch lesson details.');
            }
          });
        });
      },
      error: function() {
        console.error('Failed to fetch lesson data.');
      }
    });
  });
</script>

</body>
</html>
