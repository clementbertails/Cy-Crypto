<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body>
        <c:import url="/WEB-INF/include/header.jsp"/>

        <a href="/user/mail">Mail</a>
        <a href="/user/manage">Account informations</a>
        <a href="/user/currencies">Currencies & Favouries</a>

        <h1>Welcome <c:out value="${sessionScope.user.username}"/></h1>
        <c:import url="/WEB-INF/include/currency_view.jsp"/>
        <c:import url="/WEB-INF/include/user_favourite_currencies.jsp"/>
        <c:import url="/WEB-INF/include/chatbox.jsp"/>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>