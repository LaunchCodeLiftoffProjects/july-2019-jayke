function loadMap(){
  <!--set Map Options -->
      var options = {
        zoom: 9
      };

  <!--New map-->
      var map = new google.maps.Map(document.getElementById('map'), options );

  <!--Get location to put marker-->
      var locations = document.querySelectorAll("[id='playgroundName']");

  var bounds= new google.maps.LatLngBounds();

  <!-- Calculate Latitude and Longitude for location -->
  for (i=0; i!=locations.length; i++){
      axios.get('https://maps.googleapis.com/maps/api/geocode/json',{
                    params:{
                            address:locations[i].value,
                            key:'AIzaSyC7hSUws5hbDKi3JScfBgPEKeGo4EbJb_s'
                            }
                    })
                    .then(function(response){
                    // Geometry
                    var lat = response.data.results[0].geometry.location.lat;
                    var lng = response.data.results[0].geometry.location.lng;

                    <!-- Add marker -->
                     marker = new google.maps.Marker({
                                position : {lat: lat, lng: lng},
                                map : map,
                                animation: google.maps.Animation.DROP,
                     });

                      <!-- Info window for marker -->
                      var infoWindow = new google.maps.InfoWindow( {content:'<h4> ' + locations +' </h4>'} );
                      marker.addListener('click', function(){
                                infoWindow.open(map,marker);
                      });

                      <!-- Form a boundary for map -->
                      bounds = new google.maps.LatLngBounds();
                      bounds.extend(marker.getPosition());
      });

      }
                      <!-- Fit all markers on a map -->
                      map.setCenter(bounds.getCenter());
                      map.fitBounds(bounds);
                      map.setZoom(9);
}


