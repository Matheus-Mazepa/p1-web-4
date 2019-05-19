<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Erro">
    <jsp:body>

        <div class="container">
            <div class="col-sm-12">
                <h2 class="text-center font-italic">Ops!!! Algo deu errado!!</h2>
                <c:if test="${not empty error}">
                    <p>
                        <h3>Error:</h3>
                        ${error.msg}
                    </p>
                </c:if>
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <img class="img-fluid img-all-error" src="/resources/img/error.jpg">
                    </div>
                </div>
            </div>
        </div>


    </jsp:body>
</t:template>
