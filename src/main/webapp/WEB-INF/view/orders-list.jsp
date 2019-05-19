<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Ordens">
    <jsp:body>

        <div class="container">
            <div class="card">
                <table class="table margin-table">
                    <tr>
                        <th class="col-sm-8">Descrição</th>
                        <th class="col-sm-4">Ações</th>
                    </tr>
                    <c:forEach var="order" items="${orders}">
                        <c:if test="${!order.done}">
                            <tr>
                                <td class="col-sm-8">${order.description}</td>
                                <td class="col-sm-4">
                                    <a href="/m/ordem?id=${order.id}" class="btn btn-primary btn-xs" title="Info">
                                        <i class="fa fa-info-circle"></i>
                                    </a>
                                    <form action="/m/set-as-done" method="post">
                                        <input type="hidden" name="_metodo" value="PATCH">
                                        <input type="hidden" name="id" value="${order.id}">
                                        <a href="" class="btn btn-success btn-xs" title="Feita"
                                           onclick="event.preventDefault(); this.parentNode.submit()">
                                            <span class="fa fa-check-circle"></span>
                                        </a>
                                    </form>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>

    </jsp:body>
</t:template>