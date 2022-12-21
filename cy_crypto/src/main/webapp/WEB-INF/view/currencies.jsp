<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <div class="container">
            <main class="flex-shrink-0">
                <div class="row">
                    <Div class="col">
                        <div class="row py-1 text-center">
                            <h4 class="h4 mb-3 fw-normal">Your favorites</h4>
                        </div>
                        <c:if test="${sessionScope.user.favoriteCurrencies != null}">
                            <div class="container">
                                <div class="col offset-4">
                                    <c:forEach items="${sessionScope.user.favoriteCurrencies}" var="currency">
                                        <fieldset>
                                            <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                                            <c:out value="${currency.symbol}"/>
                                            <c:out value="${currency.name}"/>
                                        </fieldset>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </Div>
                    <Div class="col">
                        <div class="row py-1 text-center">
                            <h4 class="h4 mb-3 fw-normal">Other currencies accessible from this site:</h4>
                        </div>
                        <div class="container">
                            <div class="col offset-4">
                                <c:forEach items="${requestScope.currencies}" var="currency">
                                    <fieldset>
                                        <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                                        <c:out value="${currency.symbol}"/>
                                        <c:out value="${currency.name}"/>
                                    </fieldset>
                                </c:forEach>
                            </div>
                        </div>
                    </Div>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>
