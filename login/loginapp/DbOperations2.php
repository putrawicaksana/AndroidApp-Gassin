<?php

  class DbOperation
  {
  
      private $con;
      
      function __construct(){
    
          require_once dirname(__FILE__).'/connect2.php';

          $db = new DbConnect();

          $this->con = $db->connect();

      } 

      public function createUser($name, $password, $email){
	    if($this->isUserExist($name,$email)){
		return 0;
	   }else{

		$stmt = $this->con->prepare("INSERT INTO `login2` (`id`, `name`
		, `password`, `email`) VALUES (NULL, ?, ?, ?);");
		$stmt->bind_param("sss",$name,$password,$email);

		if($stmt->execute()){
			return 1;
		}else{
			return 2;
		}
      	    }
      } 
      public function userLogin($name, $password){
     	$stmt = $this->con->prepare("SELECT id FROM login2 WHERE name = ? AND password = ?");
	$stmt->bind_param("ss",$name,$password);
	$stmt->execute();
	$stmt->store_result();
	return $stmt->num_rows > 0;
      }
      public function getUserByUsername($name){
     	$stmt = $this->con->prepare("SELECT id FROM login2 WHERE name = ?");
	$stmt->bind_param("ss",$name);
	$stmt->execute();
	return $stmt->get_result->fetch_assoc();
     }
      private function isUserExist($name, $email){
     	$stmt = $this->con->prepare("SELECT id FROM login2 WHERE name = ? OR email = ?");
	$stmt->bind_param("ss",$name,$email);
	$stmt->execute();
	$stmt->store_result();
	return $stmt->num_rows > 0;
     }
}

?>