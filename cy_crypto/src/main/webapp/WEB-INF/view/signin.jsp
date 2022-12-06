<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="bg-light">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container">
            <main>
                <div class="py-5 text-center">
                    <img class="d-block mx-auto mb-4" src="assets/appLogo.png"  alt="" width="72" height="57">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                </div>

                <div class="py-5 text-center">
                    <c:if test="${param.notLogged}">
                        <h1 class="h3 mb-3 fw-normal">You tried to reach a page without being logged !</h1>
                    </c:if>
                </div>

                <div class="container">
                    <form action="/signin" method="post">
                        <div class="row gy-3">
                            
                            <div class="col-12">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" name="login" id="login" placeholder="Login" required>
                            </div>
                            
                            <div class="col-12">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                            </div>

                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="signin" id="signin" value="Connect" onclick="test()">Sign in</button>
                            
                            <div class ="col-12 text-center">
                                <c:if test="${param.cannotSignin}">
                                    <h1 class="h3 mb-3 fw-normal">Password or Login is incorrect !</h1>
                                    <h3 class="h4 mb-3 fw-normal">You don't have an account ?</h3>
                                    <div class="row justify-content-center">
                                        <div class="col-2">
                                            <a href="/signup" class="nav-link px-2 text-bg-dark">Sign-up</a>
                                        </div>
                                    </div>
                                </c:if>
                            </div>

                            <div>
                                <c:if test="${param.invalidParams}">
                                    <h1 class="h3 mb-3 fw-normal">Invalid parameters sends to server !</h1>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>