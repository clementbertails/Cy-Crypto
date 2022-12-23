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
                                        <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                                        <c:out value="${currency.symbol}"/>
                                        <c:out value="${currency.name}"/>
                                        <form action="/user/removefavoritescrypto" method="post">
                                            <input type="hidden" id="symbol" name="symbol" value="${currency.symbol}"/>
                                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="rmCurrency" id="rmCurrency">Remove</button>
                                        </form>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </Div>
                    <Div class="col">
                        <div class="container">
                            <div class="row py-1 text-center">
                                <h4 class="h4 mb-3 fw-normal">Other currencies accessible from this site:</h4>
                            </div>
                            <div class="col offset-4">
                                <c:forEach items="${requestScope.currencies}" var="currency">
                                    <c:set var="notContains" value="true" />
                                    <c:forEach var="favorite" items="${sessionScope.user.favoriteCurrencies}">
                                        <c:if test="${favorite.symbol == currency.symbol}">
                                            <c:set var="notContains" value="false" />
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${notContains}">
                                        <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                                        <c:out value="${currency.symbol}"/>
                                        <c:out value="${currency.name}"/>
                                        <form action="/user/addfavoritescrypto" method="post">
                                            <input type="hidden" id="symbol" name="symbol" value="${currency.symbol}"/>
                                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="addCurrency" id="addCurrency">Add</button>
                                        </form>
                                    </c:if>
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