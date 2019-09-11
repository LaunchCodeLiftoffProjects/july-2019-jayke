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
  var infoWindow = new google.maps.InfoWindow();
  var marker = new google.maps.Marker();
  var infoWindowContent;

  <!-- Calculate Latitude and Longitude for location -->
  for (i=0; i!=locations.length; i++){
   var loc = locations[i].value;
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
                     marker[i] = new google.maps.Marker({
                                position : {lat: lat, lng: lng},
                                map : map,
                                title: loc
                     });

                      <!-- Info window for marker -->
                      infoWindowContent= {content:'<h4> ' + marker[[i]].title +' </h4>'};
                      infoWindow[i] = new google.maps.InfoWindow( infoWindowContent );
                      marker[i].addListener('click', function(){
                                infoWindow.open(map, marker[i]);
                      });

                      <!-- Form a boundary for map -->
                      bounds = new google.maps.LatLngBounds();
                      bounds.extend(marker[i].getPosition());

                      <!-- Fit all markers on a map -->
                       map.setCenter(bounds.getCenter());
                       map.fitBounds(bounds);
      });

      }

                      map.setZoom(9);
}


