<%@ include file="/WEB-INF/include/jstl.jsp"%>
<header class="p-3 text-bg-dark"> 

    <script src="/js/header.js"></script>
    <nav>
        
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
              <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
              </a>
      
              <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                <li><a href="#" class="nav-link px-2 text-white">About</a></li>
              </ul>
      
              <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
              </form>
      
              <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                        <li><a href="signin" class="nav-link px-2 text-secondary">Sign-in</a></li>
                        <li><a href="signup" class="nav-link px-2 text-white">Sign-up</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <a href="signout" class="nav-link px-2 text-white">Sign-out</a>
                </c:otherwise>
              </c:choose>
            </div>
          </div>
    
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="register" class="nav-link px-2 link-dark">Sign-up</a></li>
                    <li><a href="signin" class="nav-link px-2 link-dark">Login</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <a href="signout">Sign Out</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>