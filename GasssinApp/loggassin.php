<?php

$username = filter_input(INPUT_POST, "usernamelogin");
$password = filter_input(INPUT_POST, "passwordlogin");

if ($username == "dimas" && $ password == "putra" ) {
   echo '1';
}else {
   echo '0';
}

?>