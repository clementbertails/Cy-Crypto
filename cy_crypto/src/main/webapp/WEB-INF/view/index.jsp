<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <main class="flex-shrink-0 mx-3">
            <div class="row text-center">
                <div>
                    <h1 class="h3 mb-3 fw-normal">Welcome to Cy-crypto</h1>
                </div>
                <div>
                    <img class="d-block mx-auto mb-4" src="/assets/appLogo.png"  alt="" width="70" height="70">
                </div>
            </div>
            <div class="row">
                <div class="col-8">
                    <div class="py-5 text-center">
                        <div>
                            <h1 class="h3 mb-3 fw-normal">Example of user home :</h1>
                        </div>
                        <div class="row py-1 text-center">
                            <h4 class="h3 mb-3 fw-normal">Real time information of <c:out value="${requestScope.currency.symbol}"/>/USD</h4>
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
                                            <c:if test="${information.convertedTo == 'USD'}">
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
                                                <c:if test="${information.convertedTo == 'USD'}">
                                                    <td><c:out value="${information.openDay}"/></td>
                                                    <td><c:out value="${information.highDay}"/></td>
                                                    <td><c:out value="${information.lowDay}"/></td>
                                                </c:if>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <th scope="row">Hour</th>
                                            <c:forEach items="${requestScope.currency.information}" var="information">
                                                <c:if test="${information.convertedTo == 'USD'}">
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
                                                <c:if test="${information.convertedTo == 'USD'}">
                                                    <td><c:out value="${information.volumeDay}"/></td>
                                                    <td><c:out value="${information.volume24hour}"/></td>
                                                    <td><c:out value="${information.volumeHour}"/></td>
                                                </c:if>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <th scope="row">VolumeTo</th>
                                            <c:forEach items="${requestScope.currency.information}" var="information">
                                                <c:if test="${information.convertedTo == 'USD'}">
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
                            <h4 class="h3 mb-3 fw-normal">History of <c:out value="${requestScope.currency.symbol}"/>/USD/></h4>
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
                                        <c:if test="${history.convertedTo == 'USD'}">
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
                    </div>
                </div>
                <div class="col-4">
                    <div class="py-5">
                        <div class="container">
                            <h1 class="h3 mb-3 fw-normal">Supported crypto-currencies :</h1>
                            <c:forEach items="${currencies}" var="currency">
                                <div class="mx-5">
                                    <img src="/assets/currency_icon/${currency.symbol}.png" width="50" height="50">
                                    <c:out value="${currency.symbol}"/>
                                    <c:out value="${currency.name}"/>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>7