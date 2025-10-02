<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    // Check session
   
    if(session == null || session.getAttribute("empName") == null){
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Profile</title>
<link rel="stylesheet" href="css/profile.css">
</head>
<body>

<div class="profile-container">
    <div class="profile-header">
        <h1>Employee Profile</h1>
    </div>

    <table class="profile-details">
      <tr>
            <th>Employee ID</th>
            <td>${sessionScope.empId}</td>
        </tr>
        <tr>
            <th>Employee Name</th>
            <td>${sessionScope.empName}</td>
        </tr>
        <tr>
            <th>Date of Birth</th>
            <td>${sessionScope.dob}</td>
        </tr>
        <tr>
            <th>Department</th>
            <td>${sessionScope.department}</td>
        </tr>
        <tr>
            <th>Designation</th>
            <td>${sessionScope.designation}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${sessionScope.email}</td>
        </tr>
        <tr>
            <th>Mobile Number</th>
            <td>${sessionScope.mobNo}</td>
        </tr>
          <tr>
            <th>Aadhar Number</th>
            <td>${sessionScope.aadharNO}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${sessionScope.address}</td>
        </tr>
        <tr>
            <th>Male</th>
            <td>${sessionScope.empGender}</td>
        </tr>
          <tr>
            <th>Joining Date</th>
            <td>${sessionScope.joiningDate}</td>
        </tr>
        <tr>
            <th>Salary</th>
            <td>${sessionScope.salary}</td>
        </tr>
    </table>

    <form action="logout" method="post">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</div>

</body>
</html>
