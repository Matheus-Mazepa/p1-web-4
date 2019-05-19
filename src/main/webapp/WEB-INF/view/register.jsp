<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar</title>
    <!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/register.css"/>
    <link rel="stylesheet" href="/resources/lib/font-awesome/css/font-awesome.min.css"/>


    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:200,700'
          rel='stylesheet' type='text/css'/>

</head>
<body>
    <div class="container">
		<h1 class="text-uppercase">Cadastro</h1>
        <form action="registrar" method="POST">
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
    </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="../../resources/js/register_validation.js"></script>
</body>
</html>