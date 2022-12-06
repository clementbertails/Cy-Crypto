<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <main class="flex-shrink-0">
            Welcome <c:out value="${sessionScope.user.username}" /> to cy-crypto tracker !
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>