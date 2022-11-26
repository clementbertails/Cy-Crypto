<%@ include file="/WEB-INF/include/jstl.jsp"%>
<header>
    <script src="/js/header.js"></script>
    <nav>
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <a href="register">Register</a>
                <a href="signin">Sign In</a>
            </c:when>
            <c:otherwise>
                <a href="signout">Sign Out</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>