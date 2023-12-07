
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nav</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/nav.css">
</head>
<body>
<div class="admin__nav">
    <img src="../images/logo.png" alt="" class="logo" />
<%--    <div class="logo"></div>--%>
    <ul class="admin__nav-links">
        <li class="admin__nav-link active">
            <a href="nav?page=home">
                <i class="fa fa-house"></i>
                <span>DASHBOARD</span>
            </a>
        </li>
        <li class="admin__nav-link">
            <a href="nav?page=emp">
                <i class="fa fa-book-open"></i>
                <span>EMPLOYEES</span>
            </a>
        </li>
        <li class="admin__nav-link">
            <a href="nav?page=users">
                <i class="fa fa-users"></i>
                <span>USERS</span>
            </a>
        </li>
        <li class="admin__nav-link">
            <a href="./facilities.html">
                <i class="fa fa-users"></i>
                <span>Facilities</span>
            </a>
        </li>
        <li class="admin__nav-link">
            <a href="">
                <i class="fa-regular fa-calendar"></i>
                <span>Events</span>
            </a>
        </li>
        <li class="admin__nav-link">
            <a href="logout">
                <i class="fa-regular fa-calendar"></i>
                <span>Logout</span>
            </a>
        </li>
    </ul>
</div>

</body>
</html>
