function loadMap(location){
  <!--set Map Options -->
      var options = {
        center: {lat: 38.6270, lng: -90.1994},
        zoom: 9
      };

  <!--New map-->
      map = new google.maps.Map(document.getElementById('map'), options );

  <!-- Get Latitude and Longitude -->
      axios.get('https://maps.googleapis.com/maps/api/geocode/json',{
                    params:{
                            address:location,
                            key:'AIzaSyC7hSUws5hbDKi3JScfBgPEKeGo4EbJb_s'
                            }
                    })
                    .then(function(response){
                    // Geometry
                    var lat = response.data.results[0].geometry.location.lat;
                    var lng = response.data.results[0].geometry.location.lng;

                    <!-- Add marker -->
                     var marker = new google.maps.Marker({
                                position : {lat: lat, lng: lng},
                                map : map,
                     });

                      <!-- Info window for marker -->
                      var infoWindow = new google.maps.InfoWindow( {content:'<h4> ' + location +' </h4>'} );
                      marker.addListener('click', function(){
                                infoWindow.open(map,marker);
                      });
      });
}
