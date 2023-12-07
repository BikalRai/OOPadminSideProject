<%@ page import="com.example.adminside.model.EmpModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.adminside.query.EmpQuery" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/17/2023
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff</title>
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
      <div class="emp__container">
        <a href="nav?page=create-emp" style="width: fit-content">
          <button class="add__new-btn">
            <p>ADD</p>
            <i class="fa-solid fa-plus"></i>
          </button>
        </a>
        <div class="emp__table-container">
          <table class="emp__table">
            <thead>
            <tr>
              <th>Name</th>
              <th>Username</th>
              <th>Password</th>
              <th>Staff Role</th>
              <th>Mobile</th>
              <th>Email</th>
              <th>Join Date</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="emp" items="${allEmp}">
              <tr>
                <td class="extended">${emp.fullName}</td>
                <td class="extended">${emp.username}</td>
                <td class="extended">${emp.password}</td>
                <td class="extended">${emp.role}</td>
                <td class="extended">${emp.mobile}</td>
                <td class="extended">${emp.email}</td>
                <td class="extended">${emp.joinDate}</td>
                <td class="extended">${emp.status}</td>
                <td class="actions">
                  <form action="empAction" name="emp-action" method="post">
                    <button title="View Profile" name="action" value="view, ${emp.username}" class="viewBtn">
                      <i class="fa-regular fa-eye"></i>
                    </button>
                    <button title="Edit Profile" name="action" value="edit, ${emp.username}">
                      <i class="fa-solid fa-pen-to-square"></i>
                    </button>
                    <button title="Delete Profile" name="action" value="del, ${emp.username}">
                      <i class="fa-solid fa-delete-left"></i>
                    </button>
                  </form>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    </div>

  </div>
</div>




<script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>


</body>
</html>
