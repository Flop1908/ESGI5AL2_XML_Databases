<?php
include ("webservice.php");  
?>
<?php
session_start();
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
		<li class="active"><a href="databases.php">Databases</a></li>
		<?php 
		if(strcasecmp($_SESSION['prv'],1) == 0) 
		{ 
			echo '<li><a href="CreateUser.php">Add User</a></li>'; 
		} 
		?>
		<li style="float:right;"><a href="index.php">Disconnect</a></li>
	</ul>

</header>
<body class="well" style="width:70%;margin: 0 auto;">


	<div style="margin-top:50px;">

		<form role="form" action="tables.php" method="POST">

			<div class="form-group">
				<label for="new_database">New Database</label>
				<input type="text" class="form-control" id="new_database" name="new_database" style="width:350px;" placeholder="Enter database">
			</div>

			<br/>
			<button type="submit" class="btn btn-default">Create</button>
		</form>
		
		<div class="clearfix"></div>
		
		<div class="well" style="margin-top:30px;">
			<table class="table table-striped well">
				<tr>
					<th>My Databases</th>
				</tr>
				
				<?php		
				$object_databases = simplexml_load_file('database_'.$_SESSION['login'].'.xml');
				if ($object_databases->database)
				{
					foreach($object_databases->database as $database)
					{
						echo '<tr><td><a href="tables.php?db='.$database->name.'">'.$database->name.'</a></td></tr>';
					}
				}
				?>
			</table>
		</div>
	
	
	</div>
	
	
</body>
<html>