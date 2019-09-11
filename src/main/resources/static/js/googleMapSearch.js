var map;
function searchMap(){
    var location = new Object();
    <!-- Get location from browser -->
    navigator.geolocation.getCurrentPosition(function(pos){
        location.lat = pos.coords.latitude;
        location.long= pos.coords.longitude;

    <!-- Set Map -->
        map = new google.maps.Map(document.getElementById('map'),{
            center: {lat:location.lat, lng:location.long},
            zoom: 15
        });

    <!-- Function to get parks info -->
        getParks(location);
   });
}

function getParks(location){
    <!-- Get Longitude and Latitude from current browser location -->
    var location = new google.maps.LatLng(location.lat, location.long);

    <!-- Form request for parks at current location and radius-->
    var parkRequest = {
        location: location,
        radius: 3000,
        type: ['park']
        };

    <!-- Request for parks-->
    service = new google.maps.places.PlacesService(map);
    service.nearbySearch(parkRequest, callback);
}

function callback(results, status) {

    var bounds = new google.maps.LatLngBounds();

    if (status== google.maps.places.PlacesServiceStatus.OK) {
        <!-- Results array will have parks list-->
        for (var i=0; i<results.length; i++) {
            var place = results[i];
            name = place.name;

            <!-- Content for infoWindow-->
            content = `<h3> ${place.name} </h3>
            <h3>${place.vicinity} </h3>`


        var marker = new google.maps.Marker({
            position: place.geometry.location,
            map: map,
            title: place.name
        });
        bounds.extend(marker.getPosition());

        var infoWindow = new google.maps.InfoWindow({content: content});

        bindInfoWindow(marker, map, infoWindow, content);

        marker.setMap(map);
        }
        map.fitBounds(bounds);
    }
}

function bindInfoWindow(marker, map, infoWindow, htmlContent){
    marker.addListener('click', function(){
        infoWindow.setContent(htmlContent);
        infoWindow.open(map, this);
    })
}