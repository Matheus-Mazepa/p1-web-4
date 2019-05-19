<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Acesso negado!">
    <jsp:body>
        <h3 class="col-sm-12 text-center font-italic">Opsss!!! Você não pode acessar essa rota!</h3>
        <div class="row">
            <div class="col-sm-12 text-center">
                <img class="img-fluid" src="/resources/img/403.jpg">
            </div>
        </div>
    </jsp:body>
</t:template>
