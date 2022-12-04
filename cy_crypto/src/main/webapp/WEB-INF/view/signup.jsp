<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="text-center">
        <c:import url="/WEB-INF/include/header.jsp"/>

            <form action="/signup" method="post">
                <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
            
                <div class="form-floating">
                    <input type="text" class="form-control" name="name" id="name" placeholder="Name" required>
                    <label for="name">Name</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" required>
                    <label for="lastName">Last Name</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                    <label for="username">Username</label>
                </div>
                
                <div class="form-floating">
                    <input type="text" class="form-control" name="email" id="email" placeholder="nom@example.com" required>
                    <label for="email">E-mail</label>
                </div>
                
                <div class="form-floating">
                  <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                  <label for="password">Password</label>
                </div>
    
                <div class="form-floating">
                    <input type="password" class="form-control" name="passwordConf" id="passwordConf" placeholder="Confirm password" required>
                    <label for="passwordConf">Confirm password</label>
                  </div>

                <button class="w-100 btn btn-lg btn-primary" type="submit" name="signup" id="signup" value="Sign Up">Sign up</button>
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