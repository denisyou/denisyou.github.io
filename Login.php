<?php
	$con = mysqli_connect("localhost", "id114079_lungalter", "Aa841001", "id114079_lungalter");
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	mysqli_stmt_execute($statement);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $userID, $username, $password);
	
	$response = array();
	$response["success"] = false;
	
	where(mysqli_stmt_fetch($statement)) {
		$response["success"] = true;
		$response["username"] = $username;
		$response["password"] = $password;
	}
	
	echo json_encode($response);
?>