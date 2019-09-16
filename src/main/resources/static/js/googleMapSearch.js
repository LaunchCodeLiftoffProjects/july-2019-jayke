var map;
var lastOpenedInfoWindow;
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

function searchByLocationMap(){
    <!-- Get location from Form -->
    var loc = document.getElementById('location');

    var geocoder =  new google.maps.Geocoder();
        geocoder.geocode(
                { 'address': loc.value}, function(results, status) {
              if (status == "OK") {
                location.lat =  results[0].geometry.location.lat();
                location.long=  results[0].geometry.location.lng();
              } else {
                alert("Something got wrong " + status);
              }

    <!-- Set Map -->
        map = new google.maps.Map(document.getElementById('map'),{
            center: {"lat":location.lat, "lng":location.long},
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
    var service = new google.maps.places.PlacesService(map);
    service.nearbySearch(parkRequest, callback);
}

function callback(results, status) {

    var bounds = new google.maps.LatLngBounds();

    if (status== google.maps.places.PlacesServiceStatus.OK) {
        <!-- Results array will have parks list-->
        for (var i=0; i<results.length; i++) {
            var place = results[i];

            <!-- Content for infoWindow-->
            let content = `<h4> ${place.name} </h4>
            <h5>Address: ${place.vicinity} </h5>
            <p>Rating: ${place.rating}<br>`

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
        closeLastOpenedInfoWindow();
        infoWindow.setContent(htmlContent);
        infoWindow.open(map, this);
        lastOpenedInfoWindow = infoWindow;
    })
}

function closeLastOpenedInfoWindow(){
    if (lastOpenedInfoWindow) {
        lastOpenedInfoWindow.close();
    }
}
