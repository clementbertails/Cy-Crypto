<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body>
        <c:import url="/WEB-INF/include/header.jsp"/>

        <h1>Welcome <c:out value="${sessionScope.user.username}"/></h1>

        <c:if test="${test}">
            YUYUYUYYUUY
        </c:if>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>