<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/TeacherClassStyle.css">
</head>

<body>
<header>
    <a href=""><img src="img/icons8-person-64.png" alt=""></a>
    <%=request.getUserPrincipal().getName()%>
    <nav>
        <a href="Teacher-celass.jsp">Class List</a>
        <a href="Teacher-moshakhasat.jsp">Specification</a>
    </nav>

</header>

<h1>Class List</h1>
<table class="table" id="lessonTable"  >
    <thead>
    <tr>
        <th>Day</th>
        <th>Time</th>
        <th>Lesson</th>
        <th>operation</th>
    </tr>
    </thead>

    <tbody id="celassTableBody">

    </tbody>
</table>


<script>
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/Teacger-celass-table.do", // Update with your servlet URL for fetching celass data
            dataType: "json",
            success: function(data) {
                var htmlContent = "";

                // Iterate through the array and create table rows
                $.each(data, function(index, celass) {
                    htmlContent += '<tr>';
                    htmlContent += '<td>' + celass.Date_c + '</td>';
                    htmlContent += '<td>' + celass.time + '</td>';
                    htmlContent += '<td>' + celass.lessonName+ '</td>';
                    // Add more fields as needed
                    htmlContent += '<td>';
                    htmlContent += '<button onclick="editCelass(' + celass.id + ')">Edit</button>';
                    htmlContent += ' <button onclick="deleteCelass(' + celass.id + ')">Delete</button>';
                    htmlContent += '</td>';
                    htmlContent += '</tr>';
                });

                // Update the content of the 'celassTableBody' with the created HTML
                $('#celassTableBody').html(htmlContent);
            },
            error: function() {
                console.error('Failed to fetch celass data.');
            }
        });
    });

    // Define functions for handling Edit and Delete actions for celass
    function editCelass(celassId) {
        // Implement the logic for editing a celass
        console.log('Edit celass with ID: ' + celassId);
    }

    function deleteCelass(celassId) {
        // Implement the logic for deleting a celass
        console.log('Delete celass with ID: ' + celassId);
    }
</script>
</body>
</html>
