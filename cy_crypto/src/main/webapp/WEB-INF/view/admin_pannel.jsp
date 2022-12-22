<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <main>
            <a href="/admin/manage">Manage Users</a>
            <a href="/admin/adminCrypto">Add crypto-currency</a>
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>