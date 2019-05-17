<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Ordens">
    <jsp:body>
        <h1>Ordens de serviço</h1>
        <div class="container">
            <table class="table margin-table">
                <tr>
                    <th>Ações</th>
                    <th>Descrição</th>
                    <th>Total</th>
                </tr>
            </table>
        </div>
    </jsp:body>
</t:template>