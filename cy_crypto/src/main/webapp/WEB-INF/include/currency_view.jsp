<%@ include file="/WEB-INF/include/jstl.jsp"%>
<div>
    <c:choose>
        <c:when test="${requestScope.currency == null}">
            <p>No currency found.</p>
            <p>Please add favorites :</p>
            <button>Redirect to Add Favorite (/user/currencies)</button>
        </c:when>
        <c:otherwise>    
            <h3>Actual information of <c:out value="${requestScope.currency.symbol}"/></h3>
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
                    <c:if test="${information.convertedTo.toString()} == ${sessionScope.user.favoriteConversion.toString()}">
                        <tr>
                            <td><c:out value="${information.price}"/></td>
                            <td><c:out value="${information.median}"/></td>
                            <td><c:out value="${information.volumeDay}"/></td>
                            <td><c:out value="${information.volumeDayTo}"/></td>
                            <td><c:out value="${information.volume24Hour}"/></td>
                            <td><c:out value="${information.volume24HourTo}"/></td>
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
            <h3>History of <c:out value="${requestScope.currency.symbol}"/></h3>
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
                    <c:if test="${information.convertedTo} == ${sessionScope.user.favoriteConversion}">
                        <tr>
                            <td><c:out value="${history.time}"/></td>
                            <td><c:out value="${history.high}"/></td>
                            <td><c:out value="${history.low}"/></td>
                            <td><c:out value="${history.open}"/></td>
                            <td><c:out value="${history.close}"/></td>
                            <td><c:out value="${history.volumeFrom}"/></td>
                            <td><c:out value="${history.volumeTo}"/></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>