<?php
include ("webservice.php");  

session_start();
$model = new Webservice();
$database = "";
if(isset($_POST['new_database']))
{
	$model->CreateDatabase($_POST['new_database'], $_SESSION['login']);
	$database = $model->GetDatabase($_POST['new_database'], $_SESSION['login']);
}
else if(isset($_GET['db']))
{
	if(isset($_POST['cols']))
	{
		foreach($_POST['cols'] as $cols)
		{
			$model->CreateColumn($_GET['db'], $_POST['table'], $cols['name'], $cols['type'], $_SESSION['login']);
		}
	}
	$database = $model->GetDatabase($_GET['db'], $_SESSION['login']);
	
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

		<form role="form" action="createCols.php" method="POST">
			<input type="hidden" name="database" value="<?php echo $database;?>"/>
			<div class="form-group">
				<label for="new_table">New Table</label>
				<input type="text" class="form-control" id="new_table" name="new_table" style="width:350px;" placeholder="Enter table">
			</div>
			<div class="form-group">
				<label for="nb_columns">Columns Number</label>
				<input type="text" class="form-control" id="nb_columns" name="nb_columns" style="width:350px;" placeholder="Enter number">
			</div>
			
			

			<br/>
			<button type="submit" class="btn btn-default">Create</button>
		</form>
		
		<div class="well" style="margin-top:30px;">
		
			<?php
			$object_databases = simplexml_load_file('database_'.$_SESSION['login'].'.xml');
			foreach($object_databases->database as $db)
			{
				if(strcasecmp($db->name, $database) == 0)
				{
					$tables = $db->tables;
					if($tables)
					{				
						echo '<table class="table table-striped well" ><tr><th>Tables</th></tr>';
						foreach($tables->table as $table)
						{						
							echo '<tr><td><a href="rows.php?db='.$database.'&tab='.$table->name.'">'.$table->name.'</a></td></tr>';
						}
						echo '</table>';
					}
					else
					{
						echo 'No tables in this database !';
					}
				}
			}
			?>		
		</div>
	</div>
</body>
</html>