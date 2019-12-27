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
    <script type="text/javascript">
        window.onload = function readFromLocalStorage() {
            if (JSON.parse(localStorage.getItem("username") != null)) {
                document.getElementById("myModal").style.display = 'block';
                localStorage.clear();
            }
        }
    </script>
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
            Проведение розыгрышей
        </div>
        <div class="col-md-12 text-center" style="padding-left:3%;padding-right:3%; margin-top:2%;">
            <table class='table table-bordered table-hover' style='background-color:white;'>
                <thead class='active'>
                <tr>
                    <td class='text-center info'>Имя комнаты</td>
                    <td class='text-center info'>Ставка</td>
                    <td class='text-center info'>Действие</td>
                </tr>
                </thead>
                <tbody>
                <#list rooms as room>
                    <tr>
                        <td>${room.title}</td>
                        <td>${room.bet}</td>
                        <td>
                            <form action="/admin/play" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input type="hidden" name="roomID" value="${room.id}"/>
                                <input type="submit" class="btn btn-primary" value="Разыграть"
                                       onclick="localStorage.setItem('username','${user.firstName}';"/>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="row text-center" style="margin-top:1%;font-size:150%;font-weight:bolder;">
            Добавить тип комнаты
        </div>
        <div class=" text-center row form-group" style="margin-top:1%;">
            <form method="post" action="/admin/addtype">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <label for="pass" class="col-sm-2 control-label text-center" style="font-size:150%;">Ставка</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-xs" id="pass" placeholder="Введите число"
                           name="bet" required>
                </div>
                <label for="pass" class="col-sm-2 control-label text-center" style="font-size:150%;">Описание</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control input-xs" id="pass" placeholder="Введите описание"
                           name="description">
                </div>
                <div class="col-sm-2">
                    <input type="submit" class="btn btn-success" value="Добавить"/>
                </div>
            </form>
        </div>
        <div class="row text-center" style="margin-top:1%;font-size:150%;font-weight:bolder;">
            Типы комнат
        </div>
        <div class="col-md-12 text-center" style="padding-left:3%;padding-right:3%; margin-top:2%;">
            <table class='table table-bordered table-hover' style='background-color:white;'>
                <thead class='active'>
                <tr>
                    <td class='text-center info'>Ставка</td>
                    <td class='text-center info'>Описание</td>
                    <td class='text-center info'>Действие</td>
                </tr>
                </thead>
                <tbody>
                <#list types as type>
                    <tr>
                        <td>${type.contribution}</td>
                        <td>${type.description}</td>
                        <td>
                            <form action="/admin/removeType" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <input type="hidden" name="typeID" value="${type.id}"/>
                                <input type="submit" class="btn btn-danger" value="Удалить"/>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
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
<div id="myModal" class="modal" tabindex="-1" style="display:none;">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal"
                        onclick="document.getElementById('myModal').style.display = 'none'; ">х
                </button>
                <h4 class="modal-title">Дорогой ${user.firstName} !</h4>
            </div>
            <div class="modal-body" id="textmessage">
                <div class="row text-center">
                    Розыгрыш проведён! Результат можно посмотреть в истории розыгрышей!
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>