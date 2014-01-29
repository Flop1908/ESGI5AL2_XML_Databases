<?php

if(isset($_GET['login']) && isset($_GET['password']))
{


	$objet = simplexml_load_file("user.xml");
	$nom_utilisateur = $_GET['login'];
	$mdp_utilisateur = $_GET['password'];
	$privilege_utilisateur = "KO";
	$etat_connexion = False;

	foreach($objet->user as $user)
	{
		if($nom_utilisateur == $user->login && $mdp_utilisateur == $user->password)
		{
			$privilege_utilisateur = (string)$user->privilege; 
			$etat_connexion = True;
		}		
	}
	
	if($etat_connexion)
	{
		echo "<etat_connexion>OK</etat_connexion>";
		echo "<nom_utilisateur>" . $nom_utilisateur . "</nom_utilisateur>";
		echo "<mdp_utilisateur>" . $mdp_utilisateur . "</mdp_utilisateur>";
		echo "<privilege_utilisateur>" . $privilege_utilisateur . "</privilege_utilisateur>";
		
	}
	else echo "<etat_connexion>KO</etat_connexion>";
}

?>