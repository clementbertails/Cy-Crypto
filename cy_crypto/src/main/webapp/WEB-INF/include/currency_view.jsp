<%@ include file="/WEB-INF/include/jstl.jsp"%>
<div>
    <c:choose>
        <c:when test="${requestScope.currency == null}">
            <div class="row text-center">
                <h5 class="h5 mb-3 fw-normal">No currency found.</h5>
                <h5 class="h5 mb-3 fw-normal">Please add favorites :</h5>
                <div class="mx-auto col-4">
                    <a href="/user/currencies" class="nav-link px-2 text-white"><button class="w-100 btn btn-lg btn-primary">Add Favorite</button></a>
                </div>
            </div>
        </c:when>
        <c:otherwise>    
            <div class="row py-1 text-center">
                <h4 class="h3 mb-3 fw-normal">Real time information of <c:out value="${requestScope.currency.symbol}"/>/<c:out value="${sessionScope.user.favoriteConversion}"/></h4>
            </div>

            <div class="row text-center">
                <div class="col-4 offset-4" >
                    <table class="table table-bordered  bg-secondary bg-gradient" style="--bs-bg-opacity: .5;">
                        <thead>
                            <tr>
                                <th scope="col">Price</th>
                                <th scope="col">Median</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.currency.information}" var="information">
                                <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                                    <tr>
                                        <td><c:out value="${information.price}"/></td>
                                        <td><c:out value="${information.median}"/></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row text-center">
                <div class="col-6">
                    <table class="table table-bordered bg-secondary bg-gradient" style="--bs-bg-opacity: .5;">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Open</th>
                                <th scope="col">High</th>
                                <th scope="col">Low</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Day</th>
                                <c:forEach items="${requestScope.currency.information}" var="information">
                                    <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                                        <td><c:out value="${information.openDay}"/></td>
                                        <td><c:out value="${information.highDay}"/></td>
                                        <td><c:out value="${information.lowDay}"/></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <th scope="row">Hour</th>
                                <c:forEach items="${requestScope.currency.information}" var="information">
                                    <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                                        <td><c:out value="${information.openHour}"/></td>
                                        <td><c:out value="${information.highHour}"/></td>
                                        <td><c:out value="${information.lowHour}"/></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="col-6">
                    <table class="table table-bordered  bg-secondary bg-gradient" style="--bs-bg-opacity: .5;">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Day</th>
                                <th scope="col">24H</th>
                                <th scope="col">1H</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Volume</th>
                                <c:forEach items="${requestScope.currency.information}" var="information">
                                    <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                                        <td><c:out value="${information.volumeDay}"/></td>
                                        <td><c:out value="${information.volume24hour}"/></td>
                                        <td><c:out value="${information.volumeHour}"/></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <th scope="row">VolumeTo</th>
                                <c:forEach items="${requestScope.currency.information}" var="information">
                                    <c:if test="${information.convertedTo == sessionScope.user.favoriteConversion}">
                                        <td><c:out value="${information.volumeDayTo}"/></td>
                                        <td><c:out value="${information.volume24hourTo}"/></td>
                                        <td><c:out value="${information.volumeHourTo}"/></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row py-1 text-center">
                <h4 class="h3 mb-3 fw-normal">History of <c:out value="${requestScope.currency.symbol}"/>/<c:out value="${sessionScope.user.favoriteConversion}"/></h4>
            </div>

            <div class="row text-center">
                <table class="table table-bordered  bg-secondary" style="--bs-bg-opacity: .5;">
                    <thead>
                        <tr>
                            <th scope="col">Time</th>
                            <th scope="col">High</th>
                            <th scope="col">Low</th>
                            <th scope="col">Open</th>
                            <th scope="col">Close</th>
                            <th scope="col">VolumeFrom</th>
                            <th scope="col">VolumeTo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.currency.history}" var="history">
                            <c:if test="${history.convertedTo == sessionScope.user.favoriteConversion)}">
                                <tr>
                                    <fmt:formatDate value="${history.time}" var="time" pattern="dd/MM/yyyy"/>
                                    <td><c:out value="${time}"/></td>
                                    <td><c:out value="${history.high}"/></td>
                                    <td><c:out value="${history.low}"/></td>
                                    <td><c:out value="${history.open}"/></td>
                                    <td><c:out value="${history.close}"/></td>
                                    <td><c:out value="${history.volumefrom}"/></td>
                                    <td><c:out value="${history.volumeto}"/></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>