<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Info">
    <jsp:body>
        <h1>Detalhes ordem</h1>
        <div class="container">
            <form action="" method="">
                <div class="card card-default">
                    <div class="card-body">
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="description">Descrição</label>
                                <textarea id="description" type="text" class="form-control" name="description" disabled>${order.description}</textarea>
                            </div>
                            <div class="form-group col-sm-12">
                                <label for="employee_name">Empregado</label>
                                <input id="employee_name" type="text" class="form-control" name="employee_name" value="${order.employeeName}" disabled/>
                            </div>

                            <div class="form-group col-sm-12">
                                <label for="department">Departamento</label>
                                <input id="department" type="text" class="form-control" name="department" value="${order.departmentName}" disabled/>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="card card-default">
                    <div class="col-xs-12 m-10">
                        <a href="/m/manutencao" class="btn btn-primary pull-right" >Voltar</a>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:template>