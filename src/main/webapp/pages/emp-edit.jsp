<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/28/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/nav.css">
  <link rel="stylesheet" href="../css/emp-edit.css">
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
      <h1>STAFF</h1>
      <form action="editEmp" name="empEdit" method="post" id="emp-edit">
        <h1>EDIT</h1>
        <div class="form__fields">
          <div class="form__field">
            <input type="text" name="name" value="${emp.fullName}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="username" value="${emp.username}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="password" value="${emp.password}" readonly style="overflow-x: scroll">
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="role" value="${emp.role}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="mobile" value="${emp.mobile}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="email" value="${emp.email}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="date" value="${emp.joinDate}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
          <div class="form__field">
            <input type="text" name="status" value="${emp.status}" readonly>
            <div class="action">
              <button title="edit" type="button">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
              <button title="done" type="button">
                <i class="fa-solid fa-check"></i>
              </button>
              <button title="cancel" type="button">
                <i class="fa-solid fa-delete-left"></i>
              </button>
            </div>
          </div>
        </div>

        <button style="background-color: #ea3024; padding: 1em; color: #fff; font-weight: 600; font-size: 1.1rem" name="id" value="${emp.empId}">DONE</button>
      </form>
    </div>
  </div>
</div>

<div class="modal close-modal">
  <h1>UPDATE</h1>
  <h4>
    ${msg}
  </h4>
  <%--    <button class="success-button">Confirm</button>--%>
</div>


<script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>

<script>
  const edit = document.getElementById('emp-edit');

  edit.addEventListener('click', function (e) {
    const target = e.target.closest('.action')
    const selection = target.previousElementSibling;
    const editIcon = target.querySelector('.fa-pen-to-square');
    const doneIcon = target.querySelector('.fa-check');
    const cancelIcon = target.querySelector('.fa-delete-left');


    if (e.target === editIcon && target !== null) {
      selection.removeAttribute("readonly");
      selection.focus();
      editIcon.parentElement.style.display = 'none';
      doneIcon.parentElement.style.display = 'initial';
      cancelIcon.parentElement.style.display = 'initial';
    } else if (doneIcon === e.target || cancelIcon === e.target ) {
      // Clicked on the "done" or "cancel" button
      toggleAttribute(selection, editIcon, doneIcon, cancelIcon);
    }

  })

  const toggleAttribute = (sel, edit, done, cancel) => {
    sel.setAttribute('readonly', 'readonly');
    edit.parentElement.style.display = 'initial';
    done.parentElement.style.display = 'none';
    cancel.parentElement.style.display = 'none';
  };

</script>
</body>
</html>
