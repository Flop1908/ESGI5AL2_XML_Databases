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

	<?php
	if ($_SESSION['prv'] == 1)
	{
		?>
		<div style="margin-top:50px;">
			<h4>Consulter les bases des autres users : </h4>
			<?php
			$object_users = simplexml_load_file('user.xml');
			echo '<ul>';
			$exist = false;
			foreach ($object_users->user as $user)
			{
				if(strcasecmp($user->login, $_SESSION['login']) != 0)
				{
					$exist = true;
					echo '<li><a href="user.php?user='.$user->login.'">'. $user->login .'</a></li>';
				}
			}
			
			if(!$exist) echo 'Aucun user enregistré sur ce site !';
			
			?>
		</div>
		<?php
	}
	?>


</body>
<html>