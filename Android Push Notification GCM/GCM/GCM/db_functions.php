<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        include_once 'db_connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {

    }

    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name, $contact, $gcm_regid) {
        // insert user into database
        $result = mysql_query("INSERT INTO gcm_users(name, contact, gcm_regid, created_at) VALUES('$name', '$contact', '$gcm_regid', NOW())");

        // check for successful store
        if ($result) {
            // get user details
            $id = mysql_insert_id(); // last inserted id
            $result = mysql_query("SELECT * FROM gcm_users WHERE id = $id") or die(mysql_error());
            // return user details
            if (mysql_num_rows($result) > 0) {
                return mysql_fetch_array($result);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Get user by email and password
     */
    public function getUserByEmail($contact) {
        $result = mysql_query("SELECT * FROM gcm_users WHERE contact = '$contact' LIMIT 1");
        return $result;
    }

    /**
     * Getting all users
     */
    public function getAllUsers() {
        $result = mysql_query("select * FROM gcm_users");
        return $result;
    }

    /**
     * Check user is existed or not
     */
    public function isUserExisted($contact) {
        $result = mysql_query("SELECT contact from gcm_users WHERE contact = '$contact'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            // user existed
            return true;
        } else {
            // user not existed
            return false;
        }
    }

    public function getGcmID($contact) {
        $result = mysql_query("SELECT * from gcm_users WHERE contact = '$contact'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {

            $user_details = mysql_fetch_assoc($result);

            return $user_details['gcm_regid'] ;
        } else {
            // user not existed
            return "";
        }
    }


}

?>