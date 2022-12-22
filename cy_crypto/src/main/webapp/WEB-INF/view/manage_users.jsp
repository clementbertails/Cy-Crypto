<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <script src="/js/manage.js"></script>

    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>
        <div class="container col-6">
            <main>
                <label for="users"><h4 class="h4 mb-3 fw-normal">All users</h4></label>
                <c:forEach items="${requestScope.users}" var="user">
                    <c:if test="${user.username != sessionScope.user.username}">
                        <div class="row py-3">
                            <div class="col-6">
                                <div class="row">
                                    <span>name : <c:out value="${user.name}"/> </span>
                                    <span>last name : <c:out value="${user.lastName}"/></span>
                                    <span>username : <c:out value="${user.username}"/></span>
                                </div>
                                <div class="row">
                                    <span>email : <c:out value="${user.email}"/></span>
                                    <span>role : <c:out value="${user.role}"/></span>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="row py-1">
                                    <c:choose>
                                        <c:when test="${user.role == 'USER'}">
                                            <form action="/admin/addAdmin" method="post">
                                                <input type="hidden" id="addedAdmin" name="addedAdmin" value="${user.id}"/>
                                                <button class="w-100 btn btn-lg btn-primary" type="submit" name="addAdmin" id="addAdmin">ADD ADMIN</button>
                                            </form>
                                        </c:when>
                                        <c:when test="${user.role == 'ADMIN'}">
                                            <form action="/admin/removeAdmin" method="post">
                                                <input type="hidden" id="rmedAdmin" name="rmedAdmin" value="${user.id}"/>
                                                <button class="w-100 btn btn-lg btn-primary" type="submit" name="rmAdmin" id="rmAdmin">REMOVE ADMIN</button>
                                            </form>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <div class="row py-1">
                                    <form action="/admin/removeUser" method="post">
                                        <input type="hidden" id="deletedUser" name="deletedUser" value="${user.id}"/>
                                        <button class="w-100 btn btn-lg btn-primary" type="submit" name="rmUser" id="rmUser">DELETE USER</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>