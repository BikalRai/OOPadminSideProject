<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/28/2023
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/emp.css">
</head>
<body>
<div class="admin">
    <jsp:include page="../includes/nav.jsp"/>
    <div class="admin__container">
        <div class="admin__dashboard">
            <div class="admin__dashboard-header">
                <div class="header__content">
                    <form action="">
                        <div class="search__input">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <input type="search" name="search" placeholder="Search....." />
                            <button type="submit">Search</button>
                        </div>
                    </form>
                    <div class="details">
                        <i class="fa-solid fa-user avatar-icon"></i>
                    </div>


                    <div class="details__detail">
                        <%
                            String empName = (String) session.getAttribute("empName");
                            String empRole = (String) session.getAttribute("empRole");
                        %>
                        <p style="font-size: 1.1rem; font-weight: 700"><%= empName %></p>
                        <p style="font-weight: 500"><%= empRole %></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="admin__content">
            <h1>STAFF</h1>
            <form method="post" action="empAction" class="view__emp-container">
                <h1>Staff Details</h1>
                <div>Name: ${emp.fullName}</div>
                <div>Username: ${emp.username}</div>
                <div>Password: ${emp.password}</div>
                <div>Staff Role: ${emp.role}</div>
                <div>Mobile: ${emp.mobile}</div>
                <div>Email: ${emp.email}</div>
                <div>Joined Date: ${emp.joinDate}</div>
                <div>Status: ${emp.status}</div>
                <button id="view-closeBtn" name="action" value="back, ${emp.username}">BACK</button>
            </form>
        </div>
    </div>
</div>


<%--<script>--%>
<%--    const viewContainer = document.querySelector(".view__emp-container");--%>
<%--    const viewBtns = document.querySelectorAll('.viewBtn');--%>
<%--    const viewClose = document.getElementById('view-closeBtn');--%>

<%--    viewBtns.forEach((viewBtn) => {--%>
<%--        viewBtn.addEventListener('click', () => {--%>
<%--            if (viewContainer.classList.contains('hide-view')) {--%>
<%--                viewContainer.classList.remove('hide-view');--%>
<%--            }--%>
<%--        })--%>
<%--    })--%>

<%--    viewClose.addEventListener('click', () => {--%>
<%--        viewContainer.classList.add('hide-view');--%>
<%--    })--%>
<%--</script>--%>
</body>
</html>
