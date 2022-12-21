<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en" class="h-100">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container py-3">
            <main>
                <div class="py-5 text-center">
                    <img class="d-block mx-auto mb-4" src="/assets/appLogo.png"  alt="" width="100" height="100">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                </div>

                <c:if test="${param.notLogged}">
                    <div class="py-5 text-center">
                        <h1 class="h3 mb-3 fw-normal">You tried to reach a page without being logged !</h1>
                    </div>
                </c:if>

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
                            
                            <c:if test="${param.cannotSignin}">
                                <div class ="col-12 text-center">
                                    <h1 class="h3 mb-3 fw-normal">Password or Login is incorrect !</h1>
                                    <h3 class="h4 mb-3 fw-normal">You don't have an account ?</h3>
                                    <div class="row justify-content-center">
                                        <div class="col-2">
                                            <a href="/signup" class="nav-link px-2 text-bg-dark">Sign-up</a>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${param.invalidParams}">
                                <div>
                                    <h1 class="h3 mb-3 fw-normal">Invalid parameters sends to server !</h1>
                                </div>
                            </c:if>

                        </div>
                    </form>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>