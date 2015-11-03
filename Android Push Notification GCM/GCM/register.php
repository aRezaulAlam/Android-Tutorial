<?php

if(isset($_GET["name"]) && isset($_GET["contact"]) && isset($_GET["reg_id"])){

    $name = $_GET["name"];
    $contact = $_GET["contact"];
    $gcm_regid = $_GET["reg_id"];

    include_once 'db_functions.php';

    $db  = new DB_Functions();

    $res = $db->storeUser($name,$contact,$gcm_regid);


    if($res){

        echo "success";

    }else{

        echo "failure";
    }


    } else {
    // user details missing
    echo "missing";
   }



?>