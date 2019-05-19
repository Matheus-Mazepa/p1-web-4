<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Criar">
    <jsp:body>
        <h1>Criar ordem de serviço</h1>
        <div class="container">
            <c:if test="${param.errorElectronicSignature != null}">
                <div class="alert alert-danger" role="alert">
                    Assinatura Eletrônica incorreta!
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <c:if test="${param.ceateSuccessful != null}">
                <div class="alert alert-success" role="alert">
                    Ordem de serviço criada com sucesso!
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <form action="/u/ordem/criar" method="POST">
                <div class="card card-default">
                    <div class="card-body">
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="description">Descrição</label>
                                <textarea id="description" type="text" class="form-control" name="description"></textarea>
                            </div>

                            <c:if test="${electronicSignature == null}">
                                <div class="form-group col-sm-12">
                                    <label for="electronic_signature">Assinatura eletrônica</label>
                                    <input id="electronic_signature" type="password" class="form-control" name="electronic_signature"/>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="card card-default">
                    <div class="col-xs-12 m-10">
                        <button class="btn btn-primary pull-right" type="submit">Enviar</button>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:template>