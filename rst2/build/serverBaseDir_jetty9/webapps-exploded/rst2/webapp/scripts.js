function get_cars_table() { //reference http://stackoverflow.com/questions/28816995/displaying-json-object-array-in-html-as-response-from-jersey
	$.getJSON('http://localhost:8080/rst2/api/cars?page=0&perPage=10', function(data) {
		$.each(data, function(k, arr) {
			for(i = 0; i < arr.length; i++) {
				createElementsInTable(arr[i]);				
			}
		}); 
	});
}

function toJSON() {		// got help from http://stackoverflow.com/questions/10955017/sending-json-to-php-using-ajax
	return JSON.stringify({
		"make": $('#make').val(),
		"model": $('#model').val(),
		"engine_cap": $('#engine_cap').val(),
		"hp": $('#hp').val(),
		"transmission": $('#transmission').val(),
	});
}

function createElementsInTable(car) {
	$('#cars tbody').append('<tr><td>' + car.make + '</td><td>' + car.model + '</td><td>' + car.engine_cap + '</td><td>' + car.hp + '</td><td>' + car.transmission + '</td></tr>');	
}

function addCar() {
	$('.addCar').submit(function(event) {
		event.preventDefault();
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: 'http://localhost:8080/rst2/api/cars', 
			dataType: 'json',
			data: toJSON(),
			success: function(result) {
				createElementsInTable(result);
			}
		});
	});
}

$(document).ready(function() {
	get_cars_table();
	addCar();
	
});