<?php
include ("webservice.php");  
session_start();

$msg = "";
if(isset($_POST['user']) && isset($_POST['password']))
{
	$model = new Webservice();
	$msg = $model->AddUser($_POST['user'], $_POST['password']);
}

?>


<html>
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head> 

<header>

	<center>
	<div>
		<span style="float:right;margin-right:20px;"> <?php echo $_SESSION['login']; ?></span>
		<h2>XML Project</h2>
	
	</div></center>
	<div class="clearfix"></div>
	<ul class="nav nav-tabs">
		<li><a href="admin.php">Home</a></li>
		<li><a href="databases.php">Databases</a></li>
		<?php 
		if(strcasecmp($_SESSION['prv'],1) == 0) 
		{ 
			echo '<li class="active"><a href="CreateUser.php">Add User</a></li>'; 
		} 
		?>
		<li style="float:right;"><a href="index.php">Disconnect</a></li>
	</ul>

</header>

<body class="well" style="width:70%;margin: 0 auto;">
	
	<label style="margin-top:50px;"><?php echo $msg; ?></label>
	<div style="margin-top:20px;">
				
		<form role="form" action="createUser.php" method="POST">
			<div class="form-group">
				<label for="user">User</label>
				<input type="text" class="form-control" id="user" name="user" style="width:350px;" >
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<input type="text" class="form-control" id="password" name="password" style="width:350px;" >
			</div>			

			<br/>
			<button type="submit" class="btn btn-default">Create</button>
		</form>

	</div>
</body>
</html>