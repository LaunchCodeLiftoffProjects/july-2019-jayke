var map;
function initMap(){
  <!--set Map Options -->
      var options = {
        center: {lat: 38.6270, lng: -90.1994},
        zoom: 9
      };

      <!--New map-->
      var map = new google.maps.Map(document.getElementById('map'), options );

      <!-- Call getLatLng-->
      var latLng = getLatLng();
      var lat = latLng[0];
      var lng = latLng[1];


      <!-- Add marker -->
      var marker = new google.maps.Marker({
                  position : {lat: lat, lng: lng},
                  map : map,
      });

      <!-- Info window for marker -->
      var info = document.getElementById('playgroundName').value;
      var infoWindow = new google.maps.InfoWindow( {content:'<h4> ${info}</h4>'} );

      marker.addListener('click', function(){
          infoWindow.open(map,marker);
      });
}

function getLatLng(){
    var location = document.getElementById('playgroundName').value;
    //var location = 'Chesterfield, St louis, Mo';
    console.log(location);
    axios.get('https://maps.googleapis.com/maps/api/geocode/json',{
        params:{
            address:location,
            key:'AIzaSyC2jmqjcdqlm96ZPw0HSyDhXpdTC5qwazA'
        }
    })
    .then(function(response){
    // Log full response
    console.log(response);

    // Geometry
    var lat = response.data.results[0].geometry.location.lat;
    var lng = response.data.results[0].geometry.location.lng;

    return [lat, lng]
    })
    .catch(function(error){
        console.log(error);
    });
}