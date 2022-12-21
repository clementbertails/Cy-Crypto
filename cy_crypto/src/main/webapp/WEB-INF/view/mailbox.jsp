<%@ include file="/WEB-INF/include/jstl.jsp"%>
<!DOCTYPE html>
<html class="h-100"lang="en">
    <c:import url="/WEB-INF/include/head.jsp"/>
    <body class="d-flex flex-column h-100">
        <c:import url="/WEB-INF/include/header.jsp"/>

        <div class="container py-3">
            <main>
                <div class="row py-1 text-center">
                    <h5 class="h5 mb-3 fw-normal">Welcome <c:out value="${sessionScope.user.username}"/></h5>
                </div>

                <div class="row py-3">
                    <h5 class="h5 mb-3 fw-normal">Send Mail :</h5>
                    <form action="sendmail" method="post">
                        <div class="row py-1">
                            <input type="text" name="receivers" placeholder="To" required/>
                        </div>
                        <div class="row py-1">
                            <input type="text" name="subject" placeholder="Subject" required/>
                        </div>
                        <div class="row py-1">
                            <textarea name="content" placeholder="Message" required></textarea>
                        </div>
                        <div class="row py-1">
                            <input type="submit" value="Send"/>
                        </div>
                    </form>

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
                </div>

                <div class="row py-3">
                    <h5 class="h5 mb-3 fw-normal">You have <c:out value="${requestScope.mails.size()}"/> messages in your mailbox.</h5>

                    <div class="row">
                        <div class="col-3">
                            <h5 class="h5 fw-normal">From</h5>
                        </div>

                        <div class="col-7">
                            <h5 class="h5 fw-normal">Subject</h5>
                        </div>

                        <div class="col-2">
                            <h5 class="h5 fw-normal">Date</h5>
                        </div>
                    </div>
                    
                    <ul class="list-group">
                        <c:forEach items="${requestScope.mails}" var="element">
                            <div class="container ">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-3" id="${element.id}_MailSender">
                                            <c:out value="${element.sender.username}"/>
                                        </div>

                                        <div class="col-7"id="${element.id}_MailSubject">
                                            <c:out value="${element.subject}"/>
                                        </div>

                                        <div class="col-2" id="${element.id}_MailSender">
                                            <c:out value="${element.date}"/>
                                        </div>
                                    </div>
                                </li>
                                
                                <li class="list-group-item">
                                    <div id="${element.id}_MailContent">
                                        <c:out value="${element.content}"/>
                                    </div>
                                </li>                        
                            </div>
                        </c:forEach>
                    </ul>
                </div>
            </main>
        </div>
        <c:import url="/WEB-INF/include/footer.jsp"/>
    </body>
</html>