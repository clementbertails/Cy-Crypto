<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body>
        <c:import url="/WEB-INF/include/header.jsp"/>

        Welcome <c:out value="${sessionScope.user.username}"/>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>