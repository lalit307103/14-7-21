<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>webpractice</title>
</head>
<body>
<h1 align ="center">StudentSignup</h1><p><p>
<form action ="webpractice" method="get">
<input type ="text" name ="studentid" placeholder ="studnetid"/>
<p>
<input type= "text" name="studentname" placeholder="studnetname"/>
<p>
  Gender

                    male<input type="radio" name="r1" value="male" checked/><p>
                    female<input type="radio" name="r1" value="female"/><p>
  Stream 
                   computer Science<input type ="radio" name="r2" value= "csc"/> 
                   machanical<input type = "radio" name="r2" value="mach"/>
                   electrical<input type="radio" name="r2" value="ele"/>
                   <p><p>
                   <input type ="submit" value="signup"/>                   
</form>
</body>
</html>