<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100" lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <main>
            <form action="/admin/addCrypto" method="post" enctype="multipart/form-data">
                <input type="text" name="symbol" id="symbol" placeholder="Symbol" required>
                <input type="text" name="name" id="name" placeholder="name" required>
                <input type="file" name="crypto_icon" id="crypto_icon" accept="image/png" unique required>
                <button type="submit">Add crypto-currency</button>
            </form>
        </main>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>