<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/emp.css">
  <link rel="stylesheet" href="../css/users.css">
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
            <div class="avatar-container">
              <%--                                <%--%>
              <%--                                    boolean hasImg = (boolean) request.getAttribute("img");--%>
              <%--                                %>--%>

              <%--                                <c:if test="${not hasImg}">--%>
              <%--                                    <i class="fa-solid fa-user avatar-icon"></i>--%>
              <%--                                </c:if>--%>
              <%--                                <c:choose>--%>
              <%--                                    <c:when test="${hasImg}">--%>
              <%--                                        <img--%>
              <%--                                                src=""--%>
              <%--                                                alt="Avatar"--%>
              <%--                                                class="avatar"--%>
              <%--                                        />--%>
              <%--                                    </c:when>--%>
              <%--                                </c:choose>--%>
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
            <%--                            <form name="user__dropdown" class="user__dropdown hide" action="dropdown" method="POST">--%>
            <%--                                <button class="close-box">--%>
            <%--                                    <i class="fa-solid fa-xmark"></i>--%>
            <%--                                </button>--%>
            <%--                                <c:if test="${not hasImg}">--%>
            <%--                                    <i class="fa-solid fa-user avatar-icon"></i>--%>
            <%--                                </c:if>--%>
            <%--                                <c:choose>--%>
            <%--                                    <c:when test="${hasImg}">--%>
            <%--                                        <img--%>
            <%--                                                src=""--%>
            <%--                                                alt="Avatar"--%>
            <%--                                                class="avatar"--%>
            <%--                                        />--%>
            <%--                                    </c:when>--%>
            <%--                                </c:choose>--%>
            <%--                                <button class="user__dropdown-option">Profile</button>--%>
            <%--                                <button class="user__dropdown-option" value="logout" name="logout">Logout</button>--%>
            <%--                            </form>--%>
          </div>
        </div>
      </div>

    </div>
    <div class="admin__content">
      <h1>USERS</h1>
      <div class="users__table-container">
        <table class="users__table">
          <thead>
          <tr>
            <th>User ID</th>
            <th>Full Name</th>
            <th>Mobile</th>
            <th>Password</th>
            <th>Bookings</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <c:forEach var="user" items="${allUsers}">
              <td>${user.id}</td>
              <td>${user.fullName}</td>
              <td>${user.mobile}</td>
              <td class="password">${user.password}</td>
              <td>${user.bookings}</td>
            </c:forEach>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>
</body>
</html>
