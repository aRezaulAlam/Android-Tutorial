<?php

include_once 'db_connect.php';
// connecting to database
  $db = new DB_Connect();
  $db->connect();

  $get=mysql_query("SELECT 	contact FROM gcm_users");

?>



<html>
<body>

<form method="post" action="getnotification.php">

    <select name="contact">
<?php
        while($row=mysql_fetch_array($get,MYSQL_ASSOC)) {
            ?>
            <option value="<?php echo $row['contact'] ?>"><?php echo $row['contact'] ?></option>
            <?php
        }
            ?>


    </select>



    <textarea name="msg" rows="10" cols="50">Write something here</textarea><br>
    <input type="submit" name="submit" value="Submit" >
</form>




</body>
</html>

