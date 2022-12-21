<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <main class="flex-shrink-0">
            <Div>
                <h3>Your favorites</h3>
                <c:if test="${sessionScope.user.favoriteCurrencies != null}">
                    <c:forEach items="${sessionScope.user.favoriteCurrencies}" var="currency">
                        <fieldset>
                            <c:out value="${currency.iconPath}"/>
                            <c:out value="${currency.symbol}"/>
                            <c:out value="${currency.name}"/>
                        </fieldset>
                    </c:forEach>
                </c:if>
            </Div>
            <Div>
                <h3>All others currencies</h3>
                <c:forEach items="${requestScope.currencies}" var="currency">
                    <fieldset>
                        <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                        <c:out value="${currency.iconPath}"/>
                        <c:out value="${currency.symbol}"/>
                        <c:out value="${currency.name}"/>
                    </fieldset>
                </c:forEach>
            </Div>
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>
