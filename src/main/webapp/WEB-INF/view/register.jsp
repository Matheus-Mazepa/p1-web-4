<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template title="Criar">
    <jsp:body>
        <h1 class="text-uppercase">Cadastro</h1>
        <form action="/a/registrar" method="POST">
            <div class="card card-default">
                <div class="card-body">
                    <div class="row">

                        <div class="form-group col-md-6 col-sm-12">
                            <label for="first-name">Nome</label>
                            <input id="first-name" type="text" class="form-control" name="first-name" required/>
                        </div>
                        <div class="form-group col-md-6 col-sm-12">
                            <label for="last-name">Sobrenome</label>
                            <input id="last-name" type="text" class="form-control" name="last-name" required/>
                        </div>

                        <div class="form-group col-md-6 col-sm-12">
                            <label for="departament">Departamento</label>
                            <select class="form-control" id="departament" name="departament">
                                <c:forEach var = "dep" items="${departments}">
                                    <option value="${dep.id}">${dep.name}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group col-md-6 col-sm-12">
                            <label for="user_name">Nome do Usuário</label>
                            <input id="user_name" type="text" class="form-control" name="user_name" required/>
                        </div>

                        <div class="form-group col-md-6 col-sm-12">
                            <label for="password">Senha</label>
                            <input id="password" type="password" class="form-control" name="password" required/>
                        </div>

                        <div class="form-group col-md-6 col-sm-12">
                            <label for="password-confirmation">Confirmação de senha</label>
                            <input id="password-confirmation" type="password" class="form-control" name="password-confirmation" required/>
                        </div>
                        <div>
                            <p id="p-error-password"></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card card-default">
                <div class="col-xs-12 m-10">
                    <button class="btn btn-primary pull-right" type="submit">Registrar</button>
                    <a href="/entrar" class="btn btn-primary pull-left" >Cancelar</a>
                </div>
            </div>
        </form>
    </jsp:body>
</t:template>