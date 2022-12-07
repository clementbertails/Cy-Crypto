<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container">
            <main>
                <div class="py-5 text-center">
                    <h1 class="h3 mb-3 fw-normal">Welcome <c:out value="${sessionScope.user.username}"/></h1>
               </div>

               <div class="container">
                    <form action="/user/saveInformations" method="post">
                        <div class="row gy-3">
                            <div class="col-12">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="Name" value="${sessionScope.user.name}" required> 
                            </div>

                            <div class="col-12">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" value="${sessionScope.user.lastName}" required>
                            </div>

                            <div class="col-12">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" name="username" id="username" placeholder="Username" value="${sessionScope.user.username}" required>
                            </div>

                            <div class="col-12">
                                <label for="email">E-mail</label>
                                <input type="text" class="form-control" name="email" id="email" placeholder="nom@example.com" value="${sessionScope.user.email}" required>
                            </div>

                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="saveInformations" id="saveInformations" value="saveInformations">Update</button>
                        </div>
                    </form>
               </div>

               <div class="container">
                    <form action="/user/savePassword" method="post">
                        <div class="row gy-3">
                            <div class="col-12">
                                <label for="lastPassword">Actual password</label>
                                <input type="password" class="form-control" name="lastPassword" id="lastPassword" placeholder="Actual Password" required>
                            </div>

                            <div class="col-12">
                                <label for="password">New Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                            </div>

                            <div class="col-12">
                                <label for="passwordConf">Confirm password</label>
                                <input type="password" class="form-control" name="passwordConf" id="passwordConf" placeholder="Confirm password" required>
                            </div>

                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="savePassword" id="savePassword" value="savePassword">Update</button>
                        </div>
                    </form>
               </div>

            </main>
        </div>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>