<%@ include file="/WEB-INF/include/jstl.jsp"%>
<header class="p-3 text-bg-dark"> 
    <nav>
        
      <div class="container">
        <div class="row">

          <div class="col-2">
            <a href="/"><img src="/assets/appLogo.png" width="50" height="50"></a>
          </div>

          <div class="col-8">
            <c:choose>
              <c:when test="${sessionScope.user != null}">
                <ul class="nav justify-content-start mb-md-0">
                  <li><a href="/user/home" class="nav-link px-2 text-secondary">Home</a></li>
                  <li><a href="/user/mail" class="nav-link px-2 text-white">Mail</a></li>
                  <li><a href="/user/currencies" class="nav-link px-2 text-white">Currencies & favorites</a></li>
                  <li><a href="/user/manage" class="nav-link px-2 text-white">Account informations</a></li>
                  <c:if test="${sessionScope.user.role == 'ADMIN'}">
                    <li><a href="/admin" class="nav-link px-2 text-white">Admin</a></li>
                  </c:if>
                </ul>
              </c:when>
            </c:choose>
          </div>



          <div class="col-2">
            <c:choose>
              <c:when test="${sessionScope.user == null}">
                  <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                      <li><a href="/signin" class="nav-link px-2 text-secondary">Sign-in</a></li>
                      <li><a href="/signup" class="nav-link px-2 text-white">Sign-up</a></li>
                  </ul>
              </c:when>
              <c:otherwise>
                <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                  <li><a href="/signout" class="nav-link px-2 text-white">Sign-out</a></li>
                </ul>
                </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </nav>
</header>