<%@ include file="/WEB-INF/include/jstl.jsp"%>
<Div>
    <div class="row py-1 text-center">
        <div class="row py-1 text-center">
            <h3 class="h3 mb-3 fw-normal">Your favorites crypto-currencies :</h4>
        </div>
        
        <div class="mx-auto col-6 ">
            <c:if test="${sessionScope.user.favoriteCurrencies != null}">
                <div class="container">
                    <div class="col">
                        <c:forEach items="${sessionScope.user.favoriteCurrencies}" var="currency">
                            <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                            <c:out value="${currency.symbol}"/>
                            <c:out value="${currency.name}"/>
                            <form action="/user/home" method="get">
                                <input type="hidden" id="currency" name="currency" value="${currency.symbol}"/>
                                <button class="w-100 btn btn-lg btn-info" type="submit" name="showCurrency" id="showCurrency">Show</button>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="row py-4 text-center">
                <a href="/user/currencies" class="nav-link px-2 text-white"><button class="w-100 btn btn-lg btn-primary">Add Favorite</button></a>
            </div>

            <div>
                <c:choose>
                    <c:when test="${sessionScope.user.favoriteConversion == 'EUR'}">
                        <form action="/user/favoriteConversion" method="post">
                            <input type="hidden" id="favoriteConversion" name="favoriteConversion" value="USD"/>
                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="changeFavoriteConversion" id="changeFavoriteConversion">Convert to USD</button>
                        </form>
                    </c:when>
                    <c:when test="${sessionScope.user.favoriteConversion == 'USD'}">
                        <form action="/user/favoriteConversion" method="post">
                            <input type="hidden" id="favoriteConversion" name="favoriteConversion" value="EUR"/>
                            <button class="w-100 btn btn-lg btn-primary" type="submit" name="changeFavoriteConversion" id="changeFavoriteConversion">Convert to EUR</button>
                        </form>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>    
</Div>