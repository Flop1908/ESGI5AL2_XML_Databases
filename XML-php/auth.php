<?php

if(isset($_POST['login']) && isset($_POST['password']))
{


	$objet = simplexml_load_file("user.xml");

	foreach($objet->user as $user)
	{
		if($_POST['login'] == $user->login && $_POST['password'] == $user->password)
		{
			session_start();
			$_SESSION['login'] = $_POST['login']; 
            $_SESSION['pwd'] = $_POST['password']; 
			$_SESSION['prv'] = (string)$user->privilege; 
			header("location: admin.php");
			return false;
		}		
	}
	
	header("location: index.php");
}

?>