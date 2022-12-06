<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100"lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        Welcome <c:out value="${sessionScope.user.username}"/>

        <c:if test="${param.mailSent}">
            <div class="alert alert-success" role="alert">
                Mail sent successfully!
            </div>
        </c:if>

        <c:if test="${param.errorParam}">
            <div class="alert alert-danger" role="alert">
                Mail not sent!
            </div>
        </c:if>

        Send Mail :
        <form action="sendmail" method="post">
            <input type="text" name="receivers" placeholder="To" required/>
            <input type="text" name="subject" placeholder="Subject" required/>
            <textarea name="content" placeholder="Message" required></textarea>
            <input type="submit" value="Send"/>
        </form>

        You have <c:out value="${requestScope.mails.size()}"/> messages in your mailbox.
        <c:forEach items="${requestScope.mails}" var="element">
            <div id="${element.id}_MailSender">
                <c:out value="${element.date}"/>
                <c:out value="${element.sender.username}"/>
            </div>
            <div id="${element.id}_MailSubject">
                <c:out value="${element.subject}"/>
            </div>
            <div id="${element.id}_MailContent">
                <c:out value="${element.content}"/>
            </div>
        </c:forEach>

        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>