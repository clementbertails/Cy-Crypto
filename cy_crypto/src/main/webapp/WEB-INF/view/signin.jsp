<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body>
        <c:import url="/WEB-INF/include/header.jsp"/>

        <form action="signin" method="post">
            <label for="login"></label>
            <input type="text" name="login" id="login" placeholder="Login" required>

            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Password" required>

            <input type="submit" name="signin" id="signin" value="Connect" onclick="test()">
        </form>

        <c:if test="${param.notLogged}">
            <h1>You tried to reach a page without being logged !</h1>
        </c:if>

        <c:if test="${param.cannotSignin}">
            <h1>Password or Login is incorrect !</h1>
            <h3>Don't have account ?</h3>
            <a href="signup">Sign Up</a>
        </c:if>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>