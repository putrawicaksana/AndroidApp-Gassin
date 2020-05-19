<?php

require_once '../loginapp/DbOperations2.php';

$response = array();

if ($_SERVER['REQUEST_METHOD']=='POST'){
    if(
      isset($_POST['name']) and
 	  isset($_POST['password']) and
 	    isset($_POST['email']))
    { 

     $db = new DbOperation();
     
     $result = $db->createUser($_POST['name'],
        		       $_POST['password'],
        		       $_POST['email']
     			     );
     if($result == 1){
     	$response['error'] = false;
     	$response['message'] = "User registered successfully";
     }elseif($result == 2){
     	$response['error'] = true;
     	$response['message'] = "Some Erorr Occured, Please Try Again";
     }elseif($result == 0){
     	$response['error'] = true;
     	$response['message'] = "It seems you are already registered, please choose a
		different email and username";
     }
   }else{
     	$response['error'] = true;
     	$response['message'] = "Required field missing";
    } 
  }else{
      $response['error'] = true;
      $response['message'] = "invalid request";
 }

 echo json_encode($response);

?>