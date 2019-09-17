var locationLat = new Array();
var locationLng = new Array();
var locationAddress = new Array();
var map;
var length;

function loadMap(){
      var options = {
        zoom: 5
      };

      map = new google.maps.Map(document.getElementById('map'), options );

      var locations = document.querySelectorAll("[id='playgroundName']");
      hasGeocoded= false;
      length = locations.length;

      for (i=0; i!=locations.length; i++){
        var address = locations[i].value;
        var geocoder =  new google.maps.Geocoder();
        geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var lat = results[0].geometry.location.lat();
            var lng = results[0].geometry.location.lng();
            var add = results[0].formatted_address;
            createLatLngArray(lat,lng, add);
            }
        });
      }
}

function createLatLngArray(lat, lng, add){
    locationLat.push(lat);
    locationLng.push(lng);
    locationAddress.push(add);

    if(locationLat.length == length)
    {
    putMarkers();
    console.log(locationLat.length);
    console.log(length);
    }

}

function putMarkers(){

var infowindow = new google.maps.InfoWindow();
var bounds = new google.maps.LatLngBounds();

var marker, i;

for (i = 0; i < locationLat.length; i++) {
    marker = new google.maps.Marker({
         position: new google.maps.LatLng(locationLat[i], locationLng[i]),
         map: map
    });
    marker.setMap(map);

    google.maps.event.addListener(marker, 'click', (function(marker, i) {
         return function() {
             infowindow.setContent(locationAddress[i]);
             infowindow.open(map, marker);
         }
    })(marker, i));
    bounds.extend(marker.getPosition());
}
map.fitBounds(bounds);
}