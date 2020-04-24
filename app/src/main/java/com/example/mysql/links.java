package com.example.mysql;

public class links {
    
    public static String url = "http://192.168.42.230/mysqldata.php/register";
    public static String url1 = "http://192.168.42.230/mysqldata.php/login";
    public static String url2 = "http://192.168.42.230/mysqldata.php/roll_no";
    
}

//    <?php
//            $conn = mysqli_connect('localhost','root','','mysqldata') or die(mysqli_connect_error());
//        if($conn)
//        {
////echo "I am working";
//        }
//        else
//        {
//        echo "connection not working"; }
//
///* ===============This for getting the url with function==================*/
//@$request = explode('/', trim($_SERVER['PATH_INFO'],'/'));
//        $action = preg_replace('/[^a-z0-9_]+/i','',array_shift($request));
//        $key = array_shift($request)+0;
//        $secondkey = array_shift($request)+0;
//        /*=================== End Here============================================*/
//        ini_set("display_errors", "1");
//        error_reporting(E_ALL);
//
//        switch($action)
//        {
//        case "register":
//        register();
//        break;
//
//        case "login":
//        login();
//        break;
//
//        case "roll_no":
//        roll_no();
//        break;
//
//default;
//	echo "nothing";
//            break;
//            }
//            function register()
//            {
//            $conn = mysqli_connect('localhost','root','','mysqldata') or die(mysqli_connect_error());
//
//            $email= $_POST["email"];
//            $password= $_POST["password"];
//            $roll_no= $_POST["roll_no"];
//
//
//
//            if ($email)
//            {
//            $chkemail= "SELECT* FROM sqltable WHERE email='$email'";
//
//            $result = mysqli_query($conn,$chkemail);
//
//
//            if (mysqli_num_rows($result) > 0)
//            {
//            echo $emali." is already in our mysqldata";
//            }
//            else
//            {
//            $conn = mysqli_connect('localhost','root','','mysqldata') or die(mysqli_connect_error());
//
//
//            $mysqli_qry1 = "INSERT into sqltable(email,password,roll_no) values('$email','$password', '$roll_no')";
//
//            $result1 = mysqli_query($conn,$mysqli_qry1);
//
//
//            if ($result1)
//            {
//            echo "Registered Successfully";
//            }
//            else
//            {
//            echo "Registration Failed";
//            }
//            }
//            }
//            else
//            {
//            echo "Registration failed ";
//            }
//            }
//            function login()
//            {
//            $conn = mysqli_connect('localhost','root','','mysqldata') or die(mysqli_connect_error());
//
//            $email = $_POST["email"];
//            $pass = $_POST["password"];
//
//            $query = "SELECT * FROM  sqltable WHERE  email = '$email' and password='$pass'";
//            $result = mysqli_query($conn,$query);
//            if (mysqli_num_rows($result) > 0)
//            {
//            $data=array();
//
//            while($row=mysqli_fetch_assoc($result))
//            {
//            $data["data"][]=$row;
//            }
//            header('Content-Type:Application/json');
//            echo json_encode($data);
//            }
//            else
//            {
//            echo "Login Failed";
//            }
//            }
//
//            function roll_no()
//            {
//            $conn = mysqli_connect('localhost','root','','mysqldata') or die(mysqli_connect_error());
//
//
//
//            $roll_no = $_POST["roll_no"];
//
//            $query = "SELECT * FROM  sqltable WHERE  roll_no = '$roll_no'";
//            $result = mysqli_query($conn,$query);
//            if (mysqli_num_rows($result) > 0)
//            {
//            $data=array();
//
//            while($row=mysqli_fetch_assoc($result))
//            {
//            $data["data"][]=$row;
//            }
//            header('Content-Type:Application/json');
//            echo json_encode($data);
//            }
//            else
//            {
//            echo "roll_no error";
//            }
//            }
//
//            ?>

