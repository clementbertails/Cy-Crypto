<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container">
            <main class="flex-shrink-0">
                <div class="row text-center">
                    <h1 class="h3 mb-3 fw-normal">Welcome to Cy-crypto</h1>
                </div>

                <div class="row">
                    <div class="col-8">
                        <div class="py-5 text-center">
                            <img class="d-block mx-auto mb-4" src="/assets/appLogo.png"  alt="" width="100" height="100">
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="py-5 text-center">
                            <h1 class="h3 mb-3 fw-normal">All crypto currencies suported :</h1>
                            <img class="d-block mx-auto mb-4" src="/assets/all_crypto.png"  alt="" width="400" height="600">
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>