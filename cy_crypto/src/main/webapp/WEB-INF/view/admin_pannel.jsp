<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container py-3 mx-auto col-6">
            <main>
                <div class="row mt-5 gy-3 text-center">
                    <h5 class="h3 mb-3 gy-4 fw-normal">Manage users accounts <c:out value="${sessionScope.user.username}"/></h5>
                </div>
                <div class="row gy-3 col-6 offset-3">
                    <a href="/admin/manage"><button class="w-100 btn btn-lg btn-primary" >Manage</button></a>
                </div>
                <div class="row gy-3 text-center">
                    <h5 class="h3 mb-3 fw-normal">Add crypto-currencies <c:out value="${sessionScope.user.username}"/></h5>
                </div>
                <div class="row gy-3 col-6 offset-3">
                    <a href="/admin/adminCrypto"><button class="w-100 btn btn-lg btn-primary" >Add crypto-currencies</button></a>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>