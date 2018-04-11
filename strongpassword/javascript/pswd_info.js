/**
 * For use with pswd_info div tag on the registration page and in aexample.css
 */
$(document).ready(function() {
	
	 // modify default settings for validation
	 jQuery.validator.setDefaults({
	  // where to display the error relative to the element
	  errorPlacement: function(error, element) {
	      error.appendTo(element.parent().find('div.valErrors'));
	     }
	 });
	
	$('input[name="password"]').keyup(function() {
		// set password variable
		var pswd = $(this).val();
		var greenchk = 0;
		var matchpswd = $('#matchingPassword').val();
		//validate the length
		if ( pswd.length < 8 ) {
		    $('#length').removeClass('isvalid').addClass('notvalid');
		    $('#password').removeClass('isvalid').addClass('notvalid');		    
		} else if(pswd.length == 0){
		    $('#password').removeClass('isvalid').removeClass('notvalid');			
		}else {		
		    $('#length').removeClass('notvalid').addClass('isvalid');
		    greenchk += 1;
		}
		//validate  letter
		if ( pswd.match(/[a-zA-Z]/) ) {
		    $('#letter').removeClass('notvalid').addClass('isvalid');
		    greenchk += 1;
		} else {
		    $('#letter').removeClass('isvalid').addClass('notvalid');
		    $('#password').removeClass('isvalid').addClass('notvalid');		    

		}
		//validate capital letter
		if ( pswd.match(/[A-Z]/) ) {
		    $('#capital').removeClass('notvalid').addClass('isvalid');
		    greenchk += 1;
		} else {
		    $('#capital').removeClass('isvalid').addClass('notvalid');
		    $('#password').removeClass('isvalid').addClass('notvalid');		    
		}
		//validate number
		if ( pswd.match(/\d/) ) {
		    $('#number').removeClass('notvalid').addClass('isvalid');
		    greenchk += 1;
		} else {
		    $('#number').removeClass('isvalid').addClass('notvalid');
		    $('#password').removeClass('isvalid').addClass('notvalid');		    
		}
		//validate special character
		if ( pswd.match(/[!@#$%\^&*(){}[\]<>?/|\-]/) ) {
		    $('#special').removeClass('notvalid').addClass('isvalid');
		    greenchk += 1;
		} else {
		    $('#special').removeClass('isvalid').addClass('notvalid');
		    $('#password').removeClass('isvalid').addClass('notvalid');		    
		}		
		
		
		if(greenchk == 5){
			$('#password').addClass('isvalid');
			$('#pswd_info h4').removeClass('notverified').addClass('isverified');
			if ($('#password').val() == $('#matchingPassword').val()) {
				$('#matchingPassword').addClass('isvalid');
			}
		}else if(greenchk > 0){
		    $('#password').removeClass('isvalid').addClass('notvalid');
			$('#pswd_info h4').removeClass('isverified').addClass('notverified');		    
		    $('#matchingPassword').val('');
		    $('#matchingPassword').removeClass('isvalid').removeClass('notvalid');	
		}else{
		    $('#password').removeClass('isvalid').removeClass('notvalid');
			$('#pswd_info h4').removeClass('isverified').addClass('notverified');		    
		    $('#matchingPassword').val('');		    
		    $('#matchingPassword').removeClass('isvalid').removeClass('notvalid');				
		}
		
		
	}).focus(function() {
	    $('div.pswd_info').show();
	}).blur(function() {
	    $('div.pswd_info').hide();
	});

	$('input[name="matchingPassword"]').keyup(function() {	
		var mpswd = $(this).val();
		var regpswd = $('#password').val();
		if(mpswd === regpswd){	
			console.log("passwords match, marking matchingPassword valid");
			$('#matchingPassword').removeClass('notvalid').addClass('isvalid');
		}else if(mpswd.length == 0){
			console.log("matchingPassword length is zero");
		    $('#matchingPassword').removeClass('isvalid').removeClass('notvalid');			
		}else{
		    $('#matchingPassword').removeClass('isvalid').addClass('notvalid');
		    console.log("marking matchingPassword as not valid");
		}	
	});	
});
function submitForm(){
	 console.log("submit form validator routine");
	 
	 var validator = $("#registration-form").validate({
	  rules: {                   
	   firstName: "required",
	   lastName: "required",   
	   email: {
		   required : true,
		   email: true
	   	},
	    password: {
	 	   required: true
	    },
	    matchingPassword: {
	 	   required: true,
	 	   equalTo: "#password"
	    },
	     messages: {
	      firstName: " Enter First Name",
	      lastName: " Enter Last Name",      
	      email: " Enter Email",
	     }
	    }
	   });

		 if(validator.form()){ // validation perform
			 console.log("Form validated, submitting");
		  $('form#registration-form').attr({action: '/website/user/registration'});   
		  $('form#registration-form').submit();
		 }
} 
