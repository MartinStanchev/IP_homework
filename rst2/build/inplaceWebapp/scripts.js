function get_cars_table(page_num) { //help from http://stackoverflow.com/questions/28816995/displaying-json-object-array-in-html-as-response-from-jersey
	$.getJSON('http://localhost:8080/rst2/api/cars?page=' + page_num + '&perPage=4', function(data) {
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
				window.location.href = "http://localhost:8080/rst2/";
			}
		});
	});
}

function pager(j) {
	$('#nextPage').on("click", function() {
		j += 1;
		$('#cars tbody tr').remove();
		get_cars_table(j);	
	});
	$('#prevPage').on("click", function() {
		j -= 1;
		$('#cars tbody tr').remove();
		get_cars_table(j);	
	});
	get_cars_table(j);
}

$(document).ready(function() {
	var j = 0;
	//get_cars_table(0);
	pager(j);
	addCar();
	
});