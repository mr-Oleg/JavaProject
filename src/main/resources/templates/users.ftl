<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Пользователи</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <style>
        <
        style >
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
            console.log(e.target);
            console.log(e.relatedTarget);
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
    <nav class="navbar navbar-default" style="background-color: #d3d6d4;">
        <div class="container-fluid">
            <div class="navbar-header col-md-3">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a <#--href="index.php"--> class="navbar-brand" style="color: gray;">#The Best casino</a>
            </div>
            <div class="col-md-6 collapse navbar-collapse" id="navbar-main">
                <ul class="nav navbar-nav">
                    <li><a href="http://localhost:8080/demo/rooms/show" style="color: gray;">Комнаты</a></li>
                    <li> <a href="http://localhost:8080/demo/users/show" style="color: gray;">Пользователи</a></li>
                    <li> <a href="http://localhost:8080/demo/roles/show" style="color: gray;">Роли</a></li>
                    <li> <a href="http://localhost:8080/demo/bonuspolicies/show" style="color: gray;">Бонусы</a></li>
                    <li> <a href="http://localhost:8080/demo/typeofrooms/show" style="color: gray;">Типы комнат</a></li>
                </ul>
            </div>
            <div class="col-md-2">
                <ul class="nav navbar-nav dropdown">
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center" style="font-size:200%;margin: 2%"> Имеющиеся пользователи
            </div>
        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <table class="table table-hover">
                    <tr>
                        <td>Имя</td>
                        <td>Фамилия</td>
                        <td>Баланс</td>
                        <td>Статус</td>
                    </tr>
                    <#list users as row>
                        <tr>
                            <td>${row.firstName}</td>
                            <td>${row.lastName}</td>
                            <td>${row.balance}</td>
                            <td>${row.role.name}</td>
                        </tr>
                    </#list>
                </table>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</body>
</html>