<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/modal.css">
    <link rel="stylesheet" href="./css/nav.css">

    </head>
<body>
    <div class="login__form">
        <form action="login" name="loginForm" method="POST">
            <img src="./images/logo.png" alt="" class="logo">
            <h1>STAFF LOGIN</h1>
            <div class="form-floating">
                <input type="text" name="username" id="username" class="form-control" placeholder="Enter username">
                <label for="username">Username </label>
            </div>
            <div class="form-floating">
                <input type="password" name="password" id="password" class="form-control" placeholder="Enter Password">
                <label for="password">Password </label>
            </div>
            <button class="btn btn-lg btn-success">SUBMIT</button>
        </form>
    </div>

    <div class="modal close-modal">
        <i class="fa-solid fa-xmark close"></i>
        <h1>Error</h1>
        <h4>
            ${errorMsg}.
        </h4>
        <button class="close-button">Try again</button>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/f8ae938eee.js" crossorigin="anonymous"></script>
    <script>
        const modalBtn = document.querySelector('.modal button');
        const modal = document.querySelector('.modal');
        const valid = ${loginValid};

        modalBtn.addEventListener('click', () => {
            modal.classList.add('close-modal');
        });


        if (valid === false) {
            modal.classList.remove('close-modal');
        }


    </script>
</body>
</html>