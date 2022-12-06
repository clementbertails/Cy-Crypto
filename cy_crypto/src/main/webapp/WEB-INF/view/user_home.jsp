<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <h1>Welcome <c:out value="${sessionScope.user.username}"/></h1>
        <c:import url="/WEB-INF/include/currency_view.jsp"/>
        <c:import url="/WEB-INF/include/user_favourite_currencies.jsp"/>
        <c:import url="/WEB-INF/include/chatbox.jsp"/>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>