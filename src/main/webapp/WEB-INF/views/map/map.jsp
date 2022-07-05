<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>마커 생성하기</title>

    </head>

    <body>
        <div id="map" style="width:100%;height:350px;"></div>

        <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6eae01749ed46288f45cd68bb87a3238"></script>
        <script>

            function log(url) {
                var title = "";
                var style = "width=940, height=644, top=10, left=10";
                window.open(url, title,style);
            }

            async function fetchData(position) {

                var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                    mapOption = {
                        center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude), // 지도의 중심좌표
                        level: 3 // 지도의 확대 레벨
                    };


                var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

                const lat = position.coords.latitude;
                const lng = position.coords.longitude;
                var url = "/kakao_url/" + lat + "/" + lng

                const response = await fetch(url);
                const data = await response.json();

                itemlist = []
                len = 0;
                data.forEach(obj => {
                    itemlist.push(obj)
                });

                len = itemlist.length;

                positions = []
                for (let i = 0; i < len; i++) {

                    // 거리 정보 추가 지역 이름 
                    // * 이름을 클릭하면 링크로 이동합니다
                    // 추가
                    
                    var name = itemlist[i].place_name;
                    var url = itemlist[i].place_url;

                    var iwContent = `<div style="width=400px height:100px"; onclick=log(\`` + url + `\`);>` + name + `</div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                        iwRemoveable = true;
                    position = {
                        content: iwContent,
                        removable: iwRemoveable,
                        latlng: new kakao.maps.LatLng(itemlist[i].y, itemlist[i].x),
                    }


                    positions.push(position)
                }




                // 마커 이미지의 이미지 주소입니다
                var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

                for (var i = 0; i < positions.length; i++) {

                    // 마커 이미지의 이미지 크기 입니다
                    var imageSize = new kakao.maps.Size(24, 35);

                    // 마커 이미지를 생성합니다
                    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                    // 마커를 생성합니다
                    var marker = new kakao.maps.Marker({
                        map: map, // 마커를 표시할 지도
                        position: positions[i].latlng // 마커를 표시할 위치
                    });

                    var infowindow = new kakao.maps.InfoWindow({
                        content: positions[i].content,
                        removable: positions[i].removable
                    });
                    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));

                }

                // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
                function makeOverListener(map, marker, infowindow) {
                    return function () {
                        infowindow.open(map, marker);
                    };
                }

            }

        </script>


        <script>

            function onGeoOk(position) {
                const lat = position.coords.latitude;
                const lng = position.coords.longitude;
                console.log("You live in", lat, lng);
            }
            function onGeoError() {
                alert("Can't find you. No weather for you.");
            }

            function init() {
                navigator.geolocation.getCurrentPosition(fetchData, onGeoError);
                // 충전소 위치 표시
            }

            init()

        </script>

    </body>

    </html>