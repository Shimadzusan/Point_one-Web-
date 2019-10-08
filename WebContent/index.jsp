<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "main.*"  %>
     <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#div_main{
width:100%;
min-height:400px;
background: grau;
border: 0px solid red;
}

#div1{
float: left;
width:100px;
min-height:200px;
background: yellow;
}

#div2{
float: right;
width:200px;
min-height:200px;
background: green;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Point_one</title>
</head>
<body bgcolor = #d4dee4>
		<form method = "POST" action = "Servlet_betta">
       
            <div id="object_button">
            <a href  = 'index.jsp' style="color: white">Главная страница</a>
            </div>
            
            <div id="object_button">
            <a href  = 'support.html' style="color: white">Поддержка</a>
            </div>
            
             <div style="color: white; background: #1C6956; height: 3%; width: 10%; float: left; border: solid 1px black; margin: 2px; text-align: center">
             <a href  = 'settings.html' style="color: white">Настройки</a>
            </div>
            
            <div style = "font-family: brush script mt"; align = "center"><h1>Simple analysis of the data</h1>
            </div>
            <! modul_one>
            
            <div style="color: black; width: 77%; height: 65%; background: #B4C2CA; font-family: Roman; border: solid 1px black;  float: left">
                <p>&nbsp date: -- -- ----</p>
                <p> </p>
                <p>&nbsp print ---</p>
                <p>&nbsp copy ---</p>
                <p>&nbsp foto ---</p>
                
                	
					
	&nbsp<%out.println("text_area: " + Buffer.text + "   <===");%>
	<br>
                
                <p>&nbsp</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
            </div>
<! modul_two>
            
             <script src="script.js"></script>
            
            
            <div style="color: white; width: 22%; min-height: 400 px; background: #1C6956; font-family: Roman; border: solid 1px black; float: right">
            <p align="center"><textarea  style= "background-color: #ffe; color: #930; width: 70%; height: 500 px" rows="21" cols="95" name= "comment"></textarea>
            
            </p>
                 
                 <p align="center"><input  onclick="my_f()" id="mybutton" type = "submit" value = "Отправить текст">
            </p>
            
            </div>
                 
<! modul_three>
</form>
            <div id = "div_main">
             <p>&nbsp</p>
              
            </div>
            
            <div style="color: black; width: 100%; height: 25%; background: #B0CACD; font-family: Roman; border: solid 1px black;  float: left">
                <p>date: -- -- ----</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
                <p>&nbsp</p>
                
            </div>
       
</body>
</html>