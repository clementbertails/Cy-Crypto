<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body>
        <c:import url="/WEB-INF/include/header.jsp"/>

        <form action="signup" method="post">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" placeholder="Name" required>

            <label for="lastName">Last Name</label>
            <input type="text" name="lastName" id="lastName" placeholder="Last name" required>

            <label for="username">Username</label>
            <input type="text" name="username" id="username" placeholder="Username" required>

            <label for="email">E-mail</label>
            <input type="email" name="email" id="email" placeholder="nom@example.com" required>

            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Password" required>

            <label for="passwordConf">Confirm password</label>
            <input type="password" name="passwordConf" id="passwordConf" placeholder="Confirm password" required>

            <input type="submit" name="signup" id="signup" value="Sign Up">
        </form>

        <c:if test="${param.existUser}">
            <h1>User already exist !</h1>
            <!-- pseudo ou adresse mail deja prise -->
            <a href="signin">Sign In</a>
        </c:if>
        <c:if test="${param.diffPassword}">
            <h1>Password and confirmation are differents !</h1>
        </c:if>
        <c:if test="${param.weakPassword}">
            <h1>Password is too weak !</h1>
            <p>- 1 uppercase</p>
            <p>- 1 lowercase</p>
            <p>- 1 number</p>
            <p>- 1 special character</p>
            <p>- min lenth : 10</p>
        </c:if>
        <c:if test="${param.incorrectEmail}">
            <h1>Email not respecting pattern !</h1>
        </c:if>
        <c:if test="${param.invalidParams}">
            <h1>Invalid parameters sends to server !</h1>
        </c:if>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>