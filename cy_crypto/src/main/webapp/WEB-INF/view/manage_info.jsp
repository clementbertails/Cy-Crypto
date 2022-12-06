<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">

        Welcome <c:out value="${sessionScope.user.username}"/>

        <c:import url="/WEB-INF/include/header.jsp"/>
            <form action="/user/saveInformations" method="post">

            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Name" value="${sessionScope.user.name}" required> 

            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name" value="${sessionScope.user.lastName}" required>

            <label for="username">Username</label>
            <input type="text" class="form-control" name="username" id="username" placeholder="Username" value="${sessionScope.user.username}" required>

            <label for="email">E-mail</label>
            <input type="text" class="form-control" name="email" id="email" placeholder="nom@example.com" value="${sessionScope.user.email}" required>

            <button class="w-100 btn btn-lg btn-primary" type="submit" name="saveInformations" id="saveInformations" value="saveInformations">Update</button>

        </form>

        <form action="/user/savePassword" method="post">
        
            <label for="lastPassword">Actual password</label>
            <input type="password" class="form-control" name="lastPassword" id="lastPassword" placeholder="Actual Password" required>

            <label for="password">New Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>

            <label for="passwordConf">Confirm password</label>
            <input type="password" class="form-control" name="passwordConf" id="passwordConf" placeholder="Confirm password" required>

            <button class="w-100 btn btn-lg btn-primary" type="submit" name="savePassword" id="savePassword" value="savePassword">Update</button>

        </form>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>