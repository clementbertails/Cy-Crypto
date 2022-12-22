<%@ include file="/WEB-INF/include/jstl.jsp"%>
<div>
    <c:choose>
        <c:when test="${requestScope.currency == null}">
            <div class="row text-center">
                <h5 class="h5 mb-3 fw-normal">No currency found.</h5>
                <h5 class="h5 mb-3 fw-normal">Please add favorites :</h5>
                <div class="mx-auto col-4">
                    <a href="/user/currencies" class="nav-link px-2 text-white"><button class="w-100 btn btn-lg btn-primary">Redirect to Add Favorite</button></a>
                </div>
            </div>
        </c:when>
        <c:otherwise>    
            <h3>Actual information of <c:out value="${requestScope.currency.symbol}"/>/<c:out value="${sessionScope.user.favoriteConversion}"/></h3>
            <table>
                <tr>
                    <td>Price</td>
                    <td>Median</td>
                    <td>VolumeDay</td>
                    <td>volumeDayTo</td>
                    <td>volume24Hour</td>
                    <td>volume24HourTo</td>
                    <td>openDay</td>
                    <td>highDay</td>
                    <td>lowDay</td>
                    <td>volumeHour</td>
                    <td>volumeHourTo</td>
                    <td>openHour</td>
                    <td>highHour</td>
                    <td>lowHour</td>
                </tr>
                <c:forEach items="${requestScope.currency.information}" var="information">
                    <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                        <tr>
                            <td><c:out value="${information.price}"/></td>
                            <td><c:out value="${information.median}"/></td>
                            <td><c:out value="${information.volumeDay}"/></td>
                            <td><c:out value="${information.volumeDayTo}"/></td>
                            <td><c:out value="${information.volume24hour}"/></td>
                            <td><c:out value="${information.volume24hourTo}"/></td>
                            <td><c:out value="${information.openDay}"/></td>
                            <td><c:out value="${information.highDay}"/></td>
                            <td><c:out value="${information.lowDay}"/></td>
                            <td><c:out value="${information.volumeHour}"/></td>
                            <td><c:out value="${information.volumeHourTo}"/></td>
                            <td><c:out value="${information.openHour}"/></td>
                            <td><c:out value="${information.highHour}"/></td>
                            <td><c:out value="${information.lowHour}"/></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <h3>History of <c:out value="${requestScope.currency.symbol}"/>/<c:out value="${sessionScope.user.favoriteConversion}"/></h3>
            <table>
                <tr>
                    <td>Time</td>
                    <td>High</td>
                    <td>Low</td>
                    <td>Open</td>
                    <td>Close</td>
                    <td>VolumeFrom</td>
                    <td>VolumeTo</td>
                </tr>
                <c:forEach items="${requestScope.currency.history}" var="history">
                    <c:if test="${history.convertedTo.toString() == sessionScope.user.favoriteConversion.toString()}">
                        <tr>
                            <td><c:out value="${history.time}"/></td>
                            <td><c:out value="${history.high}"/></td>
                            <td><c:out value="${history.low}"/></td>
                            <td><c:out value="${history.open}"/></td>
                            <td><c:out value="${history.close}"/></td>
                            <td><c:out value="${history.volumefrom}"/></td>
                            <td><c:out value="${history.volumeto}"/></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>