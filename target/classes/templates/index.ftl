<#import "/spring.ftl" as spring />
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
        <div class="row text-center wow bounceInLeft" data-wow-delay=".8s">
            <div class="col-xs-12">
                <span style="font-size:300%;">Мы - команда профессионалов</span>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6 wow bounceInLeft" data-wow-delay=".10s"
                 style="font-size:150%;padding-left:10%;padding-top:3%;color:gray;line-height:200%;">
                Наш сайт поможет вам разбогатеть и это не шутки! Мы предлагаем отличную возможность нашим клиентам
                заработать, не выходя из дома. Что для этого нужно сделать? Присоединиться ! Мы даём гарантию, что
                лучшего предложения на рынке просто не существует! Быстрые выплаты, широкий выбор комнат... это и многое
                другое ждёт тебя внутри ;)
            </div>
            <div class="col-xs-6 wow bounceInRight" data-wow-delay=".10s" style="padding-top:3%">
                <p class="text-center"><img style="width:60%; border-radius:50%;"
                                            class='img-responsive img-thumbnail img-rounded'
                                            src='https://cdn3.iconfinder.com/data/icons/guarantee/512/l-06-512.png'/>
                </p>
            </div>
            <hr/>
        </div>
        <div class="row text-center wow bounceInRight" data-wow-delay=".10s"
             style="background-color: rgb(226, 225, 225); visibility: visible; animation-delay: 0.1s; animation-name: bounceInRight;">
            <div class="col-md-12">
                <span style="font-size:300%;">Часто задаваемые вопросы</span>
            </div>
        </div>
        <div class="row text-center wow bounceInLeft" data-wow-delay=".10s"
             style="padding-top:3%;color:black;background-color:rgb(226, 225, 225)">
            <div class="col-md-12" style="padding-left:3%;padding-right:3%;">
                <table class='table table-bordered table-hover' style='background-color:white; '>
                    <thead class='active'>
                    <tr>
                        <td class='text-center info'>Вопрос</td>
                        <td class='text-center info'>Ответ</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class='text-center '>Что вас отличает от конкурентов?</td>
                        <td class='text-center '>Внимание к деталям, большой опыт и огромное желание сделать мир лучше
                        </td>
                    </tr>
                    <tr>
                        <td class='text-center '>Что вы можете мне предложить?</td>
                        <td class='text-center '>Отличную возможность разжиться неплохим капиталом, не выходя из дома
                        </td>
                    </tr>
                    <tr>
                        <td class='text-center '>Хочу присоединиться к вашей команде</td>
                        <td class='text-center '>К сожалению, у нас нет вакантных мест сейчас</td>
                    </tr>
                    <tr>
                        <td class='text-center '>Ребят, почему вы такие классные?</td>
                        <td class='text-center '>Потому что вы - наш клиент =)</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row text-center" data-wow-delay=".10s" style="">
            <div class="col-xs-12">
                <span style="font-size:300%;">Ещё не с нами? - Присоединяйся ;)</span>
            </div>
        </div>
        <div class="row" style="margin-top:1%;">
            <div class="col-md-8 text-center">
                <img src="https://zk-cars.com/wp-content/uploads/2019/04/zaim_deneg.png">
            </div>
            <div class="col-md-4" style=" background-color: #EEDDFF; border: 0px solid blue; border-radius: 15px;">
                <ul class="nav nav-pills" role="tablist">
                    <li class="active"><a href="#home" role="tab" data-toggle="pill">Авторизация</a></li>
                    <li><a href="#profile" role="tab" data-toggle="pill">Регистрация</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home" style="margin:2%;">
                        <form class="form-horizontal" action="/login" method="post">
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Логин</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-xs" id="pass"
                                           placeholder="Введите логин" name="username">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Пароль</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control input-xs" id="pass"
                                           placeholder="Введите пароль" name="password">
                                </div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            </div>
                            <div class="col-sm-10"></div>
                            <input type="submit" class="btn btn-success" value="Войти"/>
                        </form>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile" style="margin:2%;">
                        <form class="form-horizontal" action="/registration" method="post">
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Логин*</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-xs" id="pass"
                                           placeholder="Введите логин" name="login">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Пароль*</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control input-xs" id="pass"
                                           placeholder="Введите пароль" name="password">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Имя*</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-xs" id="pass" placeholder="Введите имя"
                                           name="firstName">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Фамилия*</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-xs" id="pass"
                                           placeholder="Введите фамилию" name="lastName">
                                </div>
                            </div>
                            <div class="form-group has-success">
                                <label for="pass" class="col-sm-2 control-label">Email*</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-xs" id="pass"
                                           placeholder="Введите почту" name="email">
                                </div>
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <div class="col-sm-8">* - Обязательно для заполнения</div>
                            <input type="submit" class="btn btn-success" value="Присоединиться"
                                   data-toggle="modal" data-target="#myModal"/>
                        </form>
                    </div>
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
</body>
</html>