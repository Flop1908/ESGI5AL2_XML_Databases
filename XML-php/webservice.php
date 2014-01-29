<?php

class Webservice{

	//var $object_user = simplexml_load_file('user.xml');
	//var $object_databases = simplexml_load_file('databases.xml');

	function CreateDatabase($name, $author)
	{
		$object_databases = simplexml_load_file('database_'.$author.'.xml');
		$exist = False;
		foreach($object_databases->database as $db)
		{
			if($db->name == $name) $exist = True;
		}
		if(!$exist)
		{
			$database = $object_databases->addChild('database');
			$database->addChild('name', $name);
			$database->addChild('tables');
			
			
			$object_databases->asXML('database_'.$author.'.xml');
		}
		return 0;
	}
	
	function CreateTable($database, $tab, $nb_cols, $author)
	{
		$object_databases = simplexml_load_file('database_'.$author.'.xml');

		foreach($object_databases->database as $db)
		{
			if(strcasecmp($db->name, $database) == 0)
			{
				$tables = $db->tables;
				$table = $tables->addChild('table');
				
				$table->addChild('name', $tab);
				$table->addChild('columns');
				$table->addChild('rows');
				
				
			}
		}
		$object_databases->asXML('database_'.$author.'.xml');

		return 0;
	}
	
	function CreateColumn($database, $tab, $col_name, $col_type, $author)
	{
		$object_databases = simplexml_load_file('database_'.$author.'.xml');

		foreach($object_databases->database as $db)
		{
			if(strcasecmp($db->name, $database) == 0)
			{
				$tables = $db->tables;
				
				foreach($tables->table as $table)
				{
					if(strcasecmp($table->name, $tab) == 0)
					{
						$columns = $table->columns;
						
						$column = $columns->addChild('column');
						$column->addChild('name', $col_name);
						$column->addChild('type', $col_type);
					}
				}
				
			}
		}
		$object_databases->asXML('database_'.$author.'.xml');

		return 0;
	}
	
	function GetDatabase($name, $author)
	{
		$object_databases = simplexml_load_file('database_'.$author.'.xml');
		foreach($object_databases->database as $database)
		{
			if($database->name == $name)
			{
				return $database->name;
			}
		}	
		
		return 0;
	}
	
	function AddUser($login, $password)
	{
		$objet = simplexml_load_file("user.xml");
		
		foreach($objet->user as $user)
		{
			if(strcasecmp($user->login, $login) == 0)
			{
				return "User already exist !";
			}
		}
		$user = $objet->addChild('user');
		$user->addChild('login', $login);
		$user->addChild('password', $password);
		$user->addChild('privilege', '2');
		
		$objet->asXML('user.xml');
		
		$f = fopen('database_'.$login.'.xml', 'x+');
		$content = '<?xml version="1.0" encoding="ISO-8859-1"?>
<databases xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="databases.xsd">
<metadata>
	<author>'.$login.'</author>
	<creation_date>'.date("d-m-Y").'</creation_date>
</metadata>
</databases>';
		fputs($f, $content );
		
		return "User created !";
	}


}


?>