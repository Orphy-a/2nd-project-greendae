document.addEventListener("DOMContentLoaded", function () {
    var mapContainer = document.getElementById('map'),
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3
        };
    var map = new kakao.maps.Map(mapContainer, mapOption);
    var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map);
});

    new daum.roughmap.Lander({
    "timestamp" : "1740384680358",
    "key" : "2n5rj",
    "mapWidth" : "763",
    "mapHeight" : "400"
}).render();

