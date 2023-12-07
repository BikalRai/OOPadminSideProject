<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
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
                <h1>DASHBOARD</h1>
                <div class="stats">
                    <div class="stat__item">
                        <div class="stat__item-left">
                            <h5>Total Users: </h5>
                            <h3>${totalUsers}</h3>
                        </div>
                        <i class="fa-solid fa-users"></i>
                    </div>
                    <div class="stat__item">
                        <div class="stat__item-left">
                            <h5>Total Bookings: </h5>
                            <h3>${totalBookings}</h3>
                        </div>
                        <i class="fa-solid fa-chart-simple"></i>
                    </div>
                    <div class="stat__item">
                        <div class="stat__item-left">
                            <h5>Pending Bookings: </h5>
                            <h3>${pendingCount}</h3>
                        </div>
                        <i class="fa-solid fa-clipboard-question"></i>
                    </div>
                </div>
                <div class="table__container">
                    <table class="admin__bookings">
                        <thead>
                        <tr>
                            <th>Booked BY</th>
                            <th>Booked For</th>
                            <th>Booked Date</th>
                            <th>Start Time</th>
                            <th>End Time</th>
                            <th>Price</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="booking" items="${allBookings}">
                        <tr>
                            <td>${booking.bookedBy}</td>
                            <td>${booking.bookedFor}</td>
                            <td>${booking.bookingDate}</td>
                            <td>${booking.bookingStart}</td>
                            <td>${booking.bookingEnd}</td>
                            <td>${booking.price}</td>
                            <td>${booking.payment}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </div>

    <script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>
    <script>
        const dropDown = document.querySelector('.user__dropdown');
        const closeBtn = dropDown.querySelector('.close-box');
        const avatar = document.querySelector(".avatar-container");

        avatar.addEventListener('click', function() {
            if (dropDown.classList.contains('hide')) {
                dropDown.classList.remove('hide')
            } else {
                dropDown.classList.add('hide')
            }
        })

        closeBtn.addEventListener("click", function () {
            dropDown.classList.add('hide');
        })

    </script>
</body>
</html>
