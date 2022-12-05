<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!doctype html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="bg-light">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container">
            <main>
                <div class="py-5 text-center">
                    <img class="d-block mx-auto mb-4" src="/assets/logo.jpg"  alt="" width="72" height="57">
                    <h1 class="h3 mb-3 fw-normal">Sign up form</h1>
                </div>

                    <form action="/signup" method="post">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="Name" required> 
                            </div>

                            <div class="col-sm-6">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" required>
                            </div>

                            <div class="col-12">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                            </div>

                            <div class="col-12">
                                <label for="email">E-mail</label>
                                <input type="text" class="form-control" name="email" id="email" placeholder="nom@example.com" required>
                            </div>

                            <div>
                                <c:if test="${param.incorrectEmail}">
                                    <h1 class="h5 mb-3 fw-normal">Email not respecting pattern !</h1>
                                </c:if>
                            </div>

                            <div class="col-12">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                            </div>

                            <div>
                                <c:if test="${param.weakPassword}">
                                    <h1 class="h5 mb-3 fw-normal">Password is too weak !</h1>
                                    <p class="h6 mb-3 fw-normal">- 1 uppercase</p>
                                    <p class="h6 mb-3 fw-normal">- 1 lowercase</p>
                                    <p class="h6 mb-3 fw-normal">- 1 number</p>
                                    <p class="h6 mb-3 fw-normal">- 1 special character</p>
                                    <p class="h6 mb-3 fw-normal">- min lenth : 10</p>
                                </c:if>
                            </div>

                            <div class="col-12">
                                <label for="passwordConf">Confirm password</label>
                                <input type="password" class="form-control" name="passwordConf" id="passwordConf" placeholder="Confirm password" required>
                            </div>

                            <div>
                                <c:if test="${param.diffPassword}">
                                    <h1 class="h5 mb-3 fw-normal">Password and confirmation are differents !</h1>
                                </c:if>
                            </div>

                            <div class="col-12">
                                <button class="w-100 btn btn-lg btn-primary" type="submit" name="signup" id="signup" value="Sign Up">Sign up</button>
                            </div>
                        
                            <div class="text-center">
                                <c:if test="${param.existUser}">
                                    <h1 class="h3 text-center">This user already exists !</h1>
                                    <!-- pseudo ou adresse mail deja prise -->
                                    <div class="row justify-content-center">
                                        <div class="col-2">
                                            <a href="/signin" class="nav-link px-2 text-bg-dark">Sign In</a>
                                        </div>
                                    </div>
                                </c:if>
                            </div>

                            <div class="text-center">
                                <c:if test="${param.invalidParams}">
                                    <h1 class="h5 mb-3 fw-normal">Invalid parameters sends to server !</h1>
                                </c:if>
                            </div>
                        </div>
                    </form>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>