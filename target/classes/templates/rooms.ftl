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
            if (JSON.parse(localStorage.getItem('${user.firstName}') != null)) {
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
    <div class="container-fluid">
        <div class="row text-center" style="font-size:200%; font-weight:bold;">
            <div class="col-md-12">
                Создать комнату
            </div>
        </div>
        <div class=" text-center row form-group" style="margin-top:1%;">
            <form method="post" action="/rooms/create">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <label for="pass" class="col-sm-2 control-label text-center" style="font-size:150%;">Имя комнаты</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-xs" id="pass" placeholder="" name="title">
                </div>
                <label for="pass" class="col-sm-2 control-label text-center" style="font-size:150%;">Кол-во
                    игроков</label>
                <div class="col-sm-1">
                    <select class="form-control input-xs" id="amount" style="" name="userAmount" required>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
                <label for="pass" class="col-sm-2 control-label text-right" style="font-size:150%;">Ставка</label>
                <div class="col-sm-2">
                    <select class="form-control input-xs" id="bet" style="" name="tor" required>
                        <#list tor as r>
                            <option value="${r.id}">${r.contribution}</option>
                        </#list>
                    </select>
                </div>
                <div class="col-sm-1">
                    <input type="submit" class="btn btn-success" value="Создать"/>
                </div>
            </form>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr align="center" width="100%" size="2" color="#ff0000"/>
            </div>
        </div>
        <div class="row text-center" style="font-size: 130%;font-weight: bolder;">
            <div class="col-md-3">
                <a href="#"
                   onclick="document.getElementById('my').style.display = 'none';document.getElementById('free').style.display = 'block'; document.getElementById('busy').style.display = 'none';">Доступные
                    комнаты</a>
            </div>
            <div class="col-md-3">
                <a href="#"
                   onclick="document.getElementById('my').style.display = 'none'; document.getElementById('free').style.display = 'none'; document.getElementById('busy').style.display = 'block';">Мои
                    комнаты</a>
            </div>
            <div class="col-md-3">
                <a href="#"
                   onclick="document.getElementById('my').style.display = 'block'; document.getElementById('free').style.display = 'none'; document.getElementById('busy').style.display = 'none';">Готовые
                    к розыгрышу</a>
            </div>
            <div class="col-md-3">
            </div>
        </div>
        <div id="free">
            <div class="row text-center" style="font-size:200%; font-weight:bold;margin-top:1%;">
                <div class="col-md-12">
                    Доступные комнаты
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style="margin-top:2%;">
                    <table class='table table-bordered table-hover' style='background-color:white;'>
                        <thead class='active'>
                        <tr>
                            <td class='text-center info'>Имя комнаты</td>
                            <td class='text-center info'>Заполненность</td>
                            <td class='text-center info'>Ставка</td>
                            <td class='text-center info'>Действие</td>
                        </tr>
                        </thead>
                        <tbody>
                        <#list free as freeRoom>
                            <tr>
                                <td>${freeRoom.title}</td>
                                <td>${freeRoom.occupancy} из ${freeRoom.userAmount}</td>
                                <td>${freeRoom.bet}</td>
                                <td class='text-center'>
                                    <form action="/rooms/add" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <input type="hidden" name="roomID" value="${freeRoom.id}">
                                        <input type="submit" class="btn btn-success" value="Присоединиться"/>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <#--    </div>-->
        <div id="busy" style="display: none;">
            <div class="row text-center" style="font-size:200%; font-weight:bold; margin-top:1%;">
                <div class="col-md-12">
                    Мои комнаты
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style=" margin-top:2%;">
                    <table class='table table-bordered table-hover' style='background-color:white;'>
                        <thead class='active'>
                        <tr>
                            <td class='text-center info'>Имя комнаты</td>
                            <td class='text-center info'>Заполненность</td>
                            <td class='text-center info'>Ставка</td>
                        </tr>
                        </thead>
                        <tbody>
                        <#list busy as busyRoom>
                            <tr>
                                <td>${busyRoom.title}</td>
                                <td>${busyRoom.occupancy} из ${busyRoom.userAmount}</td>
                                <td>${busyRoom.bet}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="my" style="display: none;">
            <div class="row text-center" style="font-size:200%; font-weight:bold; margin-top:1%;">
                <div class="col-md-12">
                    Готовые к розыгрышу
                </div>
            </div>
            <div class="row">
                <div class="col-md-12" style=" margin-top:2%;">
                    <table class='table table-bordered table-hover' style='background-color:white;'>
                        <thead class='active'>
                        <tr>
                            <td class='text-center info'>Имя комнаты</td>
                            <td class='text-center info'>Ставка</td>
                            <td class='text-center info'>Действие</td>
                        </tr>
                        </thead>
                        <tbody>
                        <#list my as completed>
                            <tr>
                                <td>${completed.title}</td>
                                <td>${completed.bet}</td>
                                <td class="text-center">
                                    <form action="/rooms/play" method="post">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <input type="hidden" name="roomID" value="${completed.id}"/>
                                        <input type="submit" class="btn btn-primary" value="Разыграть"
                                               onclick="localStorage.setItem('${user.firstName}','${user.firstName}');"/>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
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