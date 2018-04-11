<html>
<head>
<title>Our Registration</title>

<link href="/website/resources/css/aexample.css" rel="stylesheet" type="text/css" />
<script src="/website/resources/scripts/jquery-3.2.1.js"></script>
<script src="/website/resources/scripts/jquery.validate.js"></script>
<script src="/website/resources/scripts/additional-methods.js"></script>
<script src="/website/resources/scripts/pswd_info.js"></script>
</head>
<body>
<span style="float: right">
	<a href="?lang=en">en</a> 
</span>

	<div id="container">
		<h2>Andrews Spring Example</h2>
		<h6>Registration</h6>

		<div id="form-div">

			<form:form id="registration-form" modelAttribute="userDto" 
				action="/j_spring_security_check" method="POST" enctype="utf8">
				<div class="formdiv">
					<form:label path="firstName">First Name:</form:label>
					<form:input id="firstName" type="text" path="firstName" />
					<form:errors path="firstName" cssClass="valErrors" element="div" />
       				<div class="valErrors"></div>  <!-- errors via jquery -->						
				</div>
			
				<div class="formdiv">
					<form:label path="lastName">Last Name:</form:label>
					<form:input id="lastName" type="text" path="lastName" />
					<form:errors path="lastName" cssClass="valErrors" element="div" />
       				<div class="valErrors"></div>  <!-- errors via jquery -->						
				</div>
				<div class="formdiv">
					<form:label path="email">Email Address:</form:label>
					<form:input id="email" type="email" path="email" />
					<form:errors path="email" cssClass="valErrors" element="div" />
					<div>
						<c:if test="${not empty errorMessage}">
	  						<span class="valErrors">${errorMessage}</span>
						</c:if>
					</div>
       				<div class="valErrors"></div>  <!-- errors via jquery -->						
				</div>
				<div class="formdiv">
					<form:label path="password">Password:</form:label>
					<form:input id="password" type="password" path="password" />
					<form:errors path="password" cssClass="valErrors" element="div" />
       				<div class="valErrors"></div>  <!-- errors via jquery -->						
				</div>
					<div class="pswd_info" id="pswd_info">
						<h4 id="pswd_header" class="notverified">Password must meet the following requirements:</h4>
						
						<ul>
							<li id="letter" class="invalid">At least <strong>one
									letter</strong></li>
							<li id="capital" class="invalid">At least <strong>one
									capital letter</strong></li>
							<li id="number" class="invalid">At least <strong>one
									number</strong></li>
							<li id="special" class="invalid">At least <strong>one special 
									character</strong></li>									
							<li id="length" class="invalid">Be at least <strong>8
									characters</strong></li>
						</ul>
					</div>
				<div class="formdiv">
					<form:label
						path="matchingPassword">Matching Password</form:label>
					<form:input id="matchingPassword" type="password"
						path="matchingPassword" />
					<form:errors path="matchingPassword" cssClass="valErrors" element="div" />
       				<div class="valErrors"></div>  <!-- errors via jquery -->						
				</div>
				<div class="buttondiv">
					<!-- <button type="submit" text="${label.form.submit}">Submit</button>  -->
					<input id="submit" type="submit" text="${label.form.submit}" value="submit"
						onClick="submitForm();" /> <a href="/website/login.html"
						text="${label.form.loginLink}">Login</a>
				</div>

			</form:form>

			<!-- form used to be here -->

		</div>
	</div>
</body>
</html>