<?php

include_once 'db_connect.php';
include_once 'GCM.php';
// connecting to database
$db = new DB_Connect();
$db->connect();

if(isset($_POST["submit"]) && isset($_POST["contact"]) && isset($_POST["msg"])){

    $contact = $_POST["contact"];
    $msg = $_POST["msg"];


    $get_reg = mysql_query("SELECT gcm_regid FROM gcm_users where contact='{$contact}'");
    $row=mysql_fetch_array($get_reg,MYSQL_ASSOC);


    $id_reg = $row['gcm_regid'];

    $gcm = new GCM();

    $registatoin_ids = array($id_reg);
    $message = array("Notification" => $msg);
    $result = $gcm->send_notification($registatoin_ids, $message);
    echo $result;



    //$notification = new GCM();
    //$notification->send_notification($id_reg,$msg);

}

?>