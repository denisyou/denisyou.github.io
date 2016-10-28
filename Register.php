<?php
	$con = mysqli_connect("localhost", "id114079_lungalter", "Aa841001", "id114079_lungalter");
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($con, "INSERT INTO user (username, password) VALUES (?, ?)");
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
?>