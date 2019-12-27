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
                <a class="navbar-brand" style="color: gray;">Панель администратора</a>
            </div>
            <div class="col-md-6 collapse navbar-collapse" id="navbar-main">
                <ul class="nav navbar-nav">
                    <li><a href="http://localhost:8080/admin/games" style="color: gray;">Розыгрыши</a></li>
                    <li><a href="http://localhost:8080/admin/bonuses" style="color: gray;">Бонусы</a></li>
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
    <div class="container-fluid">
        <div class="row text-center" style="font-size:150%;font-weight:bolder;">
            Назначение бонусов
        </div>
        <div class=" text-center row form-group" style="margin-top:1%;">
            <form method="post" action="/admin/association">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <label for="pass" class="col-sm-3 control-label text-center" style="font-size:150%;">Логин</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control input-xs" id="pass" placeholder="" name="login">
                </div>
                <label for="pass" class="col-sm-2 control-label text-center" style="font-size:150%;">Вид бонуса</label>
                <div class="col-sm-2">
                    <select class="form-control input-xs" id="chance" style="" name="chance" required>
                        <#list bonuses as bonus>
                            <option value="${bonus.id}">${bonus.chance}</option>
                        </#list>
                    </select>
                </div>
                <div class="col-sm-2">
                    <input type="submit" class="btn btn-success" value="Назначить"/>
                </div>
            </form>
        </div>
        <div class="row text-center" style="margin-top:1%;font-size:150%;font-weight:bolder;">
            Имеющиеся назначения
        </div>
        <div class="row">
            <div class="col-md-12 text-center" style="padding-left:3%;padding-right:3%; margin-top:2%;">
                <table class='table table-bordered table-hover' style='background-color:white;'>
                    <thead class='active'>
                    <tr>
                        <td class='text-center info'>Пользователь</td>
                        <td class='text-center info'>Бонус</td>
                        <td class='text-center info'>Действие</td>
                    </tr>
                    </thead>
                    <tbody>
                    <#list bonusUser as iter>
                        <tr>
                            <td>${iter.login}</td>
                            <td>${iter.chance}</td>
                            <td>
                                <form action="/admin/remove" method="post" style="display:inline">
                                    <input type="hidden" name="userId" value="${iter.userId}"/>
                                    <input type="hidden" name="bonusId" value="${iter.id}"/>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <input type="submit" class="btn btn-danger" value="Удалить"/>
                                </form>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row text-center" style="margin-top:1%;font-size:150%;font-weight:bolder;">
            Добавить вид бонуса
        </div>
        <div class=" text-center row form-group" style="margin-top:1%;">
            <form method="post" action="/admin/addbonus">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <label for="pass" class="col-sm-3 control-label text-center" style="font-size:150%;">Вероятность</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control input-xs" id="pass" placeholder="В дробом виде"
                           name="probability">
                </div>
                <div class="col-sm-4">
                </div>
                <div class="col-sm-2">
                    <input type="submit" class="btn btn-success" value="Назначить"/>
                </div>
            </form>
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
</body>