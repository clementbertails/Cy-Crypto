<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html lang="en" class="h-100">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container py-3">
            <main>
                <div class="container mx-auto col-6">
                    <form action="/admin/addCrypto" method="post" enctype="multipart/form-data">
                        <div class="row mt-5 gy-3">
                            
                            <div class="col-12">
                                <label for="login">Symbol</label>
                                <input type="text" class="form-control" name="symbol" id="symbol" placeholder="Symbol" required>
                            </div>
                            
                            <div class="col-12">
                                <label for="password">Name</label>
                                <input type="text" class="form-control" name="name" id="name" placeholder="name" required>
                            </div>

                            <div class="col-12">
                                <label for="password">Logo</label>
                                <input type="file" class="form-control" name="crypto_icon" id="crypto_icon" accept="image/png" unique required>
                            </div>

                            <button class="w-100 btn btn-lg btn-primary" type="submit">Add crypto-currency</button>

                            <c:if test="${param.cryptoAdded}">
                                <div class="alert alert-success" role="alert">
                                    <p class="text-center">Crypto-currency added</p>
                                </div>
                            </c:if>

                            <c:if test="${param.cryptoNotAdded}">
                                <div class="alert alert-danger" role="alert">
                                    <p class="text-center">Error : Crypto-currency can't be added</p>
                                </div>
                            </c:if>

                            <c:if test="${param.cryptoAlreadyExist}">
                                <div class="alert alert-danger" role="alert">
                                    <p class="text-center">Crypto-currency already exist</p>
                                </div>
                            </c:if>

                        </div>
                    </form>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>