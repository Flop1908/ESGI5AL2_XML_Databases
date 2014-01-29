<?php
session_start();
session_unset();
session_destroy();

?>

<html>
	<head>
		<title>Authentification requise</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
<body class="well">
	<div class="well">
	<center>
	<h2>Merci de vous authentifier</h2>
	
	<form role="form" action="auth.php" method="POST">
		<center>
		<div class="form-group">
			<label for="login">Login</label>
			<input type="text" class="form-control" id="login" name="login" style="width:350px;" placeholder="Enter login">
		</div>

		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" id="password" name="password" style="width:350px;" placeholder="Password">
		</div>


		<br/>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	</center>
	</div>
</body>
<html>