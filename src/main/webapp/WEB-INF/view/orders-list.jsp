<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Ordens">
    <jsp:body>

            <table class="table margin-table">
            <tr>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <c:if test="${!order.done}">
                    <tr>
                        <td>${order.description}</td>
                        <td>
                            <a href="" class="btn btn-primary btn-xs" title="Info">
                                <i class="far fa-info-circle"></i>
                            </a>
                            <a href="" class="btn btn-success btn-xs" title="Feita">
                                <i class="far fa-check-circle"></i>
                            </a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
    </table>


    </jsp:body>
</t:template>