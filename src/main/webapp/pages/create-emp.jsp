<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/19/2023
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/emp.css">
    <link rel="stylesheet" href="../css/users.css">
    <link rel="stylesheet" href="../css/modal.css">
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
            <form action="create-emp" id="create__emp" name="emp__form" style="position: relative">
                <a href="nav?page=back" class="back-btn">
                        <i class="fa-solid fa-arrow-left"></i>
                        <span>BACK</span>
                </a>
                <h1>CREATE NEW STAFF</h1>

                <div class="form-item">
                    <label for="fullname">Fullname:</label>
                    <input type="text" name="fullname" id="fullname" placeholder="Full name">
                </div>
                <div class="form-item">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" placeholder="Username">
                </div>
                <div class="form-item">
                    <label for="emp_password">Password:</label>
                    <input type="password" name="password" id="emp_password" placeholder="Password">
                </div>
                <div class="form-item">
                    <label for="mobile">Mobile:</label>
                    <input type="text" name="mobile" id="mobile" placeholder="Mobile">
                </div>
                <div class="form-item">
                    <label for="emp_email">Email:</label>
                    <input type="email" name="email" id="emp_email" placeholder="Email">
                </div>
                <div class="form__items">
                    <div class="form-item">
                        <label for="role">Staff Role:</label>
                        <select name="role" id="role">
                            <option value="manager">Manager</option>
                            <option value="trainer">Trainer</option>
                            <option value="groundsKeeper">Grounds Keeper</option>
                        </select>
                    </div>
                    <div class="form-item">
                        <label for="join_date">Joined Date:</label>
                        <input type="date" name="join_date" id="join_date" class="form-control">
                    </div>
                    <div class="form-item">
                        <label for="status">Status:</label>
                        <select name="status" id="status">
                            <option value="active">Active</option>
                            <option value="leave">Leave</option>
                            <option value="inactive">Inactive</option>
                        </select>
                    </div>
                </div>
                <div class="actions">
                    <button class="create">CREATE</button>
                    <button class="cancel">CANCEL</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div class="modal close-modal">
    <i class="fa-solid fa-check success"></i>
    <h1>Success</h1>
    <h4>
        ${message}
    </h4>
    <%--    <button class="success-button">Confirm</button>--%>
</div>
<script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>
<script>
    const modalBtn = document.querySelector('.modal button');
    const modal = document.querySelector('.modal');
    const valid = ${check};

      if (valid) {
        modal.classList.remove('close-modal');

        setTimeout(() => {
            modal.classList.add('close-modal');
        }, 2000);
    }
</script>
</body>
</html>
