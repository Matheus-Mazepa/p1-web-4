<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Minhas Ordens">
    <jsp:body>

        <div class="container">
            <div class="card">
                <table class="table margin-table">
                    <tr>
                        <th class="col-sm-8">Descrição</th>
                        <th class="col-sm-4">Visualizações</th>
                    </tr>
                    <c:forEach var="order" items="${user_orders}">

                            <tr>
                                <td class="col-sm-8">${order.description}</td>
                                <td class="col-sm-4">
                                    <c:set var="selectedOrder" value="views_order_${order.id}"></c:set>
                                        ${applicationScope[selectedOrder]}
                                </td>
                            </tr>

                    </c:forEach>
                </table>
            </div>
        </div>

    </jsp:body>
</t:template>