<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <main>
            <div class="row text-center">
                <h1 class="h1 mb-3 fw-normal">Welcome <c:out value="${sessionScope.user.username}"/></h1>
            </div>

            <c:if test="${param.notAdmin}">
                <div class="py-2 text-center">
                    <h1 class="h4 mb-3 fw-normal">You tried to reach a page without having the rights!</h1>
                </div>
            </c:if>

            <div class="row">
                <div class="col-7 offset-1">
                    <c:import url="/WEB-INF/include/currency_view.jsp"/>
                </div>

                <div class="col-4">
                    <c:import url="/WEB-INF/include/user_favorite_currencies.jsp"/>
                </div>
            </div>
            <!-- <c:import url="/WEB-INF/include/chatbox.jsp"/> -->
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>