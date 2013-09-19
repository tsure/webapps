$(function(){
  ApartmentListingView = Backbone.View.extend({
      
	  events: {
          'click button#showApartmentListings': 'showApartmentListings'
      },
	  initialize: function(){
    	 console.log("view initialized ...");
      },
      showApartmentListings: function(){
    	  /*var jqxhr = $.get("/jspwebapp/getApartmentListing", function() {
    		  alert("success");
    		})
    		.done(function() { alert("second success"); })
    		.fail(function() { alert("error"); })*/
    	  $("#target").submit();
      }
  });
  var apartmentListingView = new ApartmentListingView({ el: $("#testContainer") });
})