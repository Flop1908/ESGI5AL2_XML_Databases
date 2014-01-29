<?php
include ("webservice.php");  
session_start();

$model = new Webservice();

if(isset($_POST['database']) && isset($_POST['new_table']) && isset($_POST['nb_columns']) )
{
	$model->CreateTable($_POST['database'], $_POST['new_table'], $_POST['nb_columns'], $_SESSION['login']);
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
		<form role="form" action="tables.php?db=<?php echo $_POST['database']; ?>" method="POST">
		<input type="hidden" name="table" value="<?php echo $_POST['new_table'];?>"/>
		<?php
		for($i = 0; $i < $_POST['nb_columns']; $i++)
		{
			echo '<label>Column '. ($i+1) .'</label><br/><br/>';
			echo '<label>Name : </label><input type="text" id="new_table" name="cols['. $i .'][name]" style="width:200px;margin-left:20px;" >';
			echo '<label style="margin-left:50px;">Type : </label><select name="cols['. $i .'][type]" style="width:150px;margin-left:20px;">
				<option value="primary key">Primary Key</option><option value="int">Int</option><option value="string">String</option><option value="foreign key">Foreign Key</option></select><br/><br/>';
		}
		
		?>
		
		<br/>
		<button type="submit" class="btn btn-default">Create</button>
		
		</form>
		
	</div>

</body>
</html>