<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Просмотр</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        html, body {
            height: 100%;
        }

        #wrap:after {
            content: "";
            display: block;
        }

        #wrap {
            margin-bottom: 5%;
            min-height: 75%;
        }

        #wrap:after {
            height: 100%;
        }
    </style>
    <script>
        $('a[data-toggle="pill"]').on('hidden.bs.tab', function (e) {
            console.log(e.target); // вкладка, которая стала активной
            console.log(e.relatedTarget); // предыдущая активная вкладка
        })
    </script>
    <script>
        function a() {
            $('#myModal').modal("toggle");
            $('#myModal').on('shown.bs.modal', function (event) {
                alert("Выполенно");
            });
        }
    </script>
</head>
<body>
<div id="wrap">
    <div class="container-fluid">
        <div class="row" style="background-color: #090111">
            <div class="col-md-4">
                <img class="img-responsive"
                     src="https://cms-assets.tutsplus.com/uploads/users/1557/posts/28913/image/screenshot-preview.png"/>
            </div>
            <div class="col-md-6">
                <div style="margin-top:13%;">
                    <p class="text-center" style="color:white; font-size:250%;">#The best casino</p>
                    <p class="text-center" style="color:white; font-size:250%;">Лучший среди конкурентов</p>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-default" style="background-color: #d3d6d4;">
        <div class="container-fluid">
            <div class="navbar-header col-md-3">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="color: gray;">#The Best casino</a>
            </div>
            <div class="col-md-6 collapse navbar-collapse" id="navbar-main">
                <ul class="nav navbar-nav">
                    <li><a href="http://localhost:8080/rooms" style="color: gray;">Комнаты</a></li>
                    <li><a href="http://localhost:8080/personal" style="color: gray;">Личный кабинет</a></li>
                </ul>

            </div>
            <div class="col-md-3 text-right" style="margin-left:20%; margin-top:0.5%;">
                <a href='#' style="color: gray;">${user.firstName} ${user.lastName}</a>
                <form action="/logout" method="post" style="display:inline-block; margin-left:1%;">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input class="btn btn-primary" type="submit" value="Выйти"/>
                </form>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row text-center" style="margin-top:2%; font-size:200%; font-weight:bolder;">
            <div class="col-md-12">
                Информация обо мне:
            </div>
        </div>
        <div class="row" style="margin-top:2%; font-size:150%; font-weight:bolder;">
            <div class="col-md-4">Имя пользователя</div>
            <div class="col-md-4">${user.firstName}</div>
            <div class="col-md-4">
                <button class="btn btn-warning" onclick="document.getElementById('myModal1').style.display = 'block';">
                    Изменить
                </button>
            </div>
        </div>
        <div class="row" style="margin-top:2%; font-size:150%; font-weight:bolder;">
            <div class="col-md-4">Фамилия пользователя</div>
            <div class="col-md-4">${user.lastName}</div>
            <div class="col-md-4">
                <button class="btn btn-warning" onclick="document.getElementById('myModal2').style.display = 'block';">
                    Изменить
                </button>
            </div>
        </div>
        <div class="row" style="margin-top:2%; font-size:150%; font-weight:bolder;">
            <div class="col-md-4">Пароль пользователя</div>
            <div class="col-md-4">${user.password}</div>
            <div class="col-md-4">
                <button class="btn btn-warning" onclick="document.getElementById('myModal3').style.display = 'block';">
                    Изменить
                </button>
            </div>
        </div>
        <div class="row" style="margin-top:2%; font-size:150%; font-weight:bolder;">
            <div class="col-md-4">E-mail пользователя</div>
            <div class="col-md-4">${user.email}</div>
            <div class="col-md-4">
                <button class="btn btn-warning" onclick="document.getElementById('myModal4').style.display = 'block';">
                    Изменить
                </button>
            </div>
        </div>
        <div class="row text-center" style="margin-top:2%; font-size:200%; font-weight:bolder;">
            <div class="col-md-12">
                Счёт
            </div>
        </div>
        <div class="row text-left" style="font-size:150%; font-weight:bolder;">
            <div class="col-md-4 text-right ">
                Текущий баланс
            </div>
            <div class="col-md-8">
                ${user.balance} рублей
            </div>
        </div>
        <div class="text-center row form-group" style="margin-top:1%;">
            <form method="post" action="/personal/addmoney">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <label for="pass" class="col-sm-3 control-label text-right" style="font-size:150%;">Пополнить на</label>
                <div class="col-sm-3 text-left">
                    <input type="text" class="form-control input-xs" id="money" placeholder="" name="money">
                </div>
                <label for="pass" class="col-sm-2 control-label text-left" style="font-size:150%;">рублей</label>
                <div class="col-sm-4">
                    <input type="submit" class="btn btn-success" value="Провести платёж"/>
                </div>
            </form>
        </div>
        <div class="row text-center" style="margin-top:2%; font-size:200%; font-weight:bolder;">
            <div class="col-md-12">
                История игр
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="padding-left:3%;padding-right:3%; margin-top:2%;">
                <table class='table table-bordered table-hover' style='background-color:white;'>
                    <thead class='active'>
                    <tr>
                        <td class='text-center info'>Имя комнаты</td>
                        <td class='text-center info'>Сумма</td>
                        <td class='text-center info'>Статус</td>
                    </tr>
                    </thead>
                    <tbody>
                    <#list history as historyNode>
                        <tr>
                            <td>${historyNode.title}</td>
                            <td>${historyNode.benefit}</td>
                            <td>${historyNode.status}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row" style="background-color: #090111">
        <div class="col-md-12 text-center">
            <p style="color:white; font-size:150%;">All rights reserved ©</p>
            <p style="color:white; font-size:150%;">2019</p>
        </div>
    </div>
</div>

<div id="myModal1" class="modal" tabindex="-1" style="display:none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"
                        onclick="document.getElementById('myModal1').style.display = 'none';">х
                </button>
                <h4 class="modal-title">Изменение</h4>
            </div>
            <div class="modal-body" id="setfname">
                <div class="row">
                    <form class="form-horizontal" action="/personal/fname" method="post">
                        <div class="form-group has-warning">
                            <label for="pass" class="col-sm-4 control-label">Имя</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control input-xs" id="pass"
                                       placeholder="Введите значение" name="fname">
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-warning" style="margin:1%;" value="Изменить"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="myModal2" class="modal" tabindex="-1" style="display:none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"
                        onclick="document.getElementById('myModal2').style.display = 'none';">х
                </button>
                <h4 class="modal-title">Изменение</h4>
            </div>
            <div class="modal-body" id="textmessage">
                <div class="row">
                    <form class="form-horizontal" action="/personal/lname" method="post">
                        <div class="form-group has-warning">
                            <label for="pass" class="col-sm-4 control-label">Фамилия</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control input-xs" id="pass"
                                       placeholder="Введите значение" name="lname">
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-warning" style="margin:1%;" value="Изменить"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="myModal3" class="modal" tabindex="-1" style="display:none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"
                        onclick="document.getElementById('myModal3').style.display = 'none';">х
                </button>
                <h4 class="modal-title">Изменение</h4>
            </div>
            <div class="modal-body" id="textmessage">
                <div class="row">
                    <form class="form-horizontal" action="/personal/password" method="post">
                        <div class="form-group has-warning">
                            <label for="pass" class="col-sm-4 control-label">Пароль</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control input-xs" id="pass"
                                       placeholder="Введите значение" name="password">
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-warning" style="margin:1%;" value="Изменить"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="myModal4" class="modal" tabindex="-1" style="display:none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"
                        onclick="document.getElementById('myModal4').style.display = 'none';">х
                </button>
                <h4 class="modal-title">Изменение</h4>
            </div>
            <div class="modal-body" id="textmessage">
                <div class="row">
                    <form class="form-horizontal" action="/personal/email" method="post">
                        <div class="form-group has-warning">
                            <label for="pass" class="col-sm-4 control-label">E-mail</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control input-xs" id="pass"
                                       placeholder="Введите значение" name="email">
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-warning" style="margin:1%;" value="Изменить"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>