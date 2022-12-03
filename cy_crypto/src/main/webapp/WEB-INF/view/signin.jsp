<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="text-center">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <form action="/signin" method="post">
            <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        
            <div class="form-floating">
              <input type="text" class="form-control" name="login" id="login" placeholder="Login" required>
              <label for="login">Login</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
              <label for="password">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit" name="signin" id="signin" value="Connect" onclick="test()">Sign in</button>
        </form>

        <c:if test="${param.notLogged}">
            <h1>You tried to reach a page without being logged !</h1>
        </c:if>

        <c:if test="${param.cannotSignin}">
            <h1>Password or Login is incorrect !</h1>
            <h3>Don't have account ?</h3>
            <a href="/signup">Sign Up</a>
        </c:if>
        
        <c:if test="${param.invalidParams}">
            <h1>Invalid parameters sends to server !</h1>
        </c:if>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>