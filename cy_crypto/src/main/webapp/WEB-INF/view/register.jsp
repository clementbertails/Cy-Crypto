<!DOCTYPE html>
<html lang="en">
    <jsp:include page="../include/head.jsp"/>
    <body>
        <jsp:include page="../include/header.jsp"/>

        <form action="/register" method="post">
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

            <input type="submit" id="connectionSubmit" value="Connect" onclick="test()">
        </form>

        <jsp:include page="../include/footer.jsp"/>
    </body>
</html>