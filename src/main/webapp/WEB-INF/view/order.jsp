<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Criar">
    <jsp:body>
        <h1>Criar ordem de serviço</h1>
        <div class="container">
            <form action="/u/ordem/criar" method="POST">
                <div class="card card-default">
                    <div class="card-body">
                        <div class="row">
                            <div class="form-group col-sm-12">
                                <label for="user_name">Descrição</label>
                                <textarea id="user_name" type="text" class="form-control" name="description"></textarea>
                            </div>

                            <div class="form-group col-sm-12">
                                <label for="electronic_signature">Assinatura eletronica</label>
                                <input id="electronic_signature" type="password" class="form-control" name="electronic_signature"/>
                            </div>
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