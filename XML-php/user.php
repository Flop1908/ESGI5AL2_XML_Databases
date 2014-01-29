<?php 
session_start (); 
include ("webservice.php"); 
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
		<li class="active"><a href="admin.php">Home</a></li>
		<li><a href="databases.php">Databases</a></li>
		<?php 
		if(strcasecmp($_SESSION['prv'],1) == 0) 
		{ 
			echo '<li><a href="CreateUser.php">Add User</a></li>'; 
		} 
		?>
		<li style="float:right;"><a href="index.php">Disconnect</a></li>
	</ul>
</header>
<body class="well"  style="width:70%;margin: 0 auto;">

	<div style="margin-top:50px;">
		
		<?php
		$object_database = simplexml_load_file('database_'.$_GET['user'].'.xml');
		echo '<h4>Database</h4>';
		foreach ($object_database->database as $db)
		{
			
			echo '<ul>';
			echo '<li>'.$db->name.'</li>';
			
			$tables = $db->tables;
			if($tables->table)
			{
				echo '<ul>';
				foreach ($tables->table as $table)
				{
					
					echo '<li>'.$table->name.'</li>';
				}
				echo '</ul>';
			}
			echo '</ul>';
		}
		
		
		?>
	</div>

</body>
<html>