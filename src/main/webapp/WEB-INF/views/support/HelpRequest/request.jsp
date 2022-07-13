<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!doctype html>
    <html lang="en">

    <head>
        <title>Contact Form 02</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/request.css">

    </head>

    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">Contact Form #02</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-12">
                        <div class="wrapper">
                            <div class="row no-gutters">
                                <div class="col-lg-8 col-md-7 order-md-last d-flex align-items-stretch">
                                    <div class="contact-wrap w-100 p-md-5 p-4">
                                        <h3 class="mb-4">Rent Car center로 연결해 드립니다.</h3>
                                        <div id="form-message-warning" class="mb-4"></div>
                                        <div id="form-message-success" class="mb-4">
                                            Your message was sent, thank you!
                                        </div>

                                        <form id="contactForm" name="contactForm" class="contactForm">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="label" for="name">Full Name</label>
                                                        <input type="text" class="form-control" name="mname" id="mname"
                                                            placeholder="Name">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="label" for="email">Email Address</label>
                                                        <input type="email" class="form-control mb-5" name="email"
                                                            id="email" placeholder="Email">
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Car number</label>
                                                        <input type="text" class="form-control mb-5" name="carnum"
                                                            id="carnum">
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="label" for="#">Reason</label>
                                                        <textarea name="reason" class="form-control" id="reason"
                                                            cols="30" rows="4" placeholder="Message"></textarea>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input onclik="help" type="submit" value="Send Message"
                                                            class="btn btn-primary" style="left: 80%; margin-top: 5%;">
                                                        <div class="submitting"></div>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-5 d-flex align-items-stretch">
                                    <div class="info-wrap bg-primary w-100 p-md-5 p-4">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script>
            async function helpMe(position) {
                // Geolocation  and send

                const lat = position.coords.latitude;
                const lng = position.coords.longitude;

                const name = document.getElementById("reason").value;
                const email = document.getElementById("email").value;
                const carnum = document.getElementById("carnum").value;
                const reason = document.getElementById("reason").value;

                console.log(name);

                data = {
                    x: lat,
                    y: lng,
                    name: name,
                    email: email,
                    carnum: carnum,
                    reason: reason
                };

                var url = "/request/help";
                const response = await fetch(url, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(data)
                })
                    .then((res) => {if(!res.ok){alert("성공")}})
                    .catch("잠시후 다시 시도해 보세요.");

            }


            function onGeoError() {
                alert("Can't find you. No weather for you.");
            }

            function help() {
                navigator.geolocation.getCurrentPosition(helpMe, onGeoError);
                // 충전소 위치 표시
            }

        </script>
    </body>

    </html>