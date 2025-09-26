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
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 0;
    }

    .profile-container {
        max-width: 600px;
        margin: 50px auto;
        background: #fff;
        border-radius: 12px;
        padding: 30px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    }

    .profile-header {
        text-align: center;
        margin-bottom: 30px;
    }

    .profile-header h1 {
        color: #2563eb;
        font-size: 28px;
        margin: 0;
    }

    .profile-details {
        width: 100%;
        border-collapse: collapse;
    }

    .profile-details th, .profile-details td {
        padding: 12px 20px;
        text-align: left;
        font-size: 18px;
    }

    .profile-details th {
        background: #4CAF50;
        color: white;
        width: 40%;
    }

    .profile-details tr:nth-child(even) {
        background: #f9f9f9;
    }

    .profile-details tr:nth-child(odd) {
        background: #fff;
    }

    .logout-btn {
        display: block;
        width: 100%;
        margin-top: 20px;
        padding: 12px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .logout-btn:hover {
        background: #0056b3;
    }

    /* Responsive */
    @media(max-width: 480px){
        .profile-container {
            width: 90%;
            padding: 20px;
        }
        .profile-details th, .profile-details td {
            font-size: 16px;
            padding: 10px;
        }
    }
</style>
</head>
<body>

<div class="profile-container">
    <div class="profile-header">
        <h1>Employee Profile</h1>
    </div>

    <table class="profile-details">
        <tr>
            <th>Employee Name</th>
            <td>${sessionScope.empName}</td>
        </tr>
        <tr>
            <th>Department</th>
            <td>${sessionScope.department}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${sessionScope.email}</td>
        </tr>
        <tr>
            <th>Mobile Number</th>
            <td>${sessionScope.mobNo}</td>
        </tr>
    </table>

    <form action="logout" method="post">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</div>

</body>
</html>
