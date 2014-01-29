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

		<form role="form" action="createCols.php" method="POST">
		
			<?php
			$object_databases = simplexml_load_file('database_'.$_SESSION['login'].'.xml');
			
			foreach($object_databases->database as $db)
			{
				if(strcasecmp($db->name, $_GET['db']) == 0)
				{
					$tables = $db->tables;
					if($tables)
					{				
						foreach($tables->table as $table)
						{	
							if(strcasecmp($table->name, $_GET['tab']) == 0)
							{
								$columns = $table->columns;
								$i = 0;
								foreach ($columns->column as $column)
								{
									echo '<label>'. $column->name .' : </label><input type="text" class="form-control" id="new_table" name="rows['. $i .']" style="width:250px;" >';
									$i++;
								}
							}
						}
					}
				}
			}
			?>
			
			

			<br/><br/>
			<button type="submit" class="btn btn-default">Create</button>
		</form>
		
		<div class="well" style="margin-top:30px;">
	
		<?php
			$object_databases = simplexml_load_file('database_'.$_SESSION['login'].'.xml');
			foreach($object_databases->database as $db)
			{
				if(strcasecmp($db->name, $_GET['db']) == 0)
				{
					$tables = $db->tables;
					if($tables)
					{				
						$exist = false;
						
						foreach($tables->table as $table)
						{	
							if(strcasecmp($table->name, $_GET['tab']) == 0)
							{
								$rows = $table->rows;
								if($rows->row)
								{
									$exist = true;
									echo '<table class="table table-striped well" ><tr><th>Tables</th></tr>';
									echo '<table class="table table-striped well" ><tr>';
									
									$columns = $table->columns;
									foreach ($columns->column as $column)
									{
										echo '<th style="font-size:12px;">'. $column->name .'</th>';
									}
									echo '<th colspan="2" style="font-size:12px;" >Action</th>';
									echo '</tr>';
									
									
									$exist = true;
									foreach($rows->row as $row)
									{
										$fields = $row->fields;
										echo '<tr>';
										foreach ($fields->field as $field)
										{
											echo '<td style="font-size:12px;">'. $field .'</td>';
										}
										echo '<td><button type="button" class="btn btn-primary">Update</button></td>';
										echo '<td><button type="button" class="btn btn-danger">Delete</button></td>';
										echo '</tr>';
									}
								
									echo '</table>';
								}
							}
						}
						if (!$exist)
						{
							echo 'No rows in this table !';
						}
					}
				}
			}
			?>		
		</div>
	</div>
</body>
</html>