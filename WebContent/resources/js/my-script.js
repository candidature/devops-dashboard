
//https://codepen.io/taboo09/pen/YXKzaP

function change_left() {
  $('div').removeClass('slide-right').addClass('slide-left');
}

function change_right() {
  $('div').removeClass('slide-left').addClass('slide-right');
  //change_title();
}

function to_left() {
setInterval(change_left, 10000);
};

function to_right() {
  setInterval(change_right, 20000);
};

to_left();
to_right();



function getValue(obj)
{
	//alert("You have selected Kind: " + obj.value);
	
	if (obj.value == 'UNPLANNED') {
		$('#mySelect').attr('hidden',true)
	} else {
		$('#mySelect').attr('hidden',false)
	}

}

$(document).ready(function($){
	$('#endDatePicker').datepicker({minDate: new Date()});
	
	$('#startDatePicker').datepicker({minDate: new Date()});
	
	$('#startTimePicker').timepicker({});
	$('#endTimePicker').timepicker({});
	
});
  



