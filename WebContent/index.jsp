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
            
            <div style="color: black; width: 77%; height: 65%; background: #c3ced5; font-family: Roman; border: solid 1px black;  float: left">
                 &nbsp date: <%out.println(" " + Buffer.date);%>
                <br>&nbsp begin cash: <%out.println(" " + Buffer.begin_cash);%>
                <br>&nbsp end cash: --- ---
                <br>&nbsp total value of deals: ---
                
                <p>&nbsp result income: ---
                <br>&nbsp result payment: ---
                
                <p>&nbsp online income: from sber = ---; from tinkoff = ---; from po4ta-bank = ---
                <br>&nbsp income from nicom: ---
                
                <p>&nbsp print ---</p>
                <p>&nbsp copy ---</p>
                <p>&nbsp foto ---</p>
                
                	
					
	&nbsp<%out.println("text_area: " + Buffer.text + "   <===");%>
	<br>
                
                
               
                <br>online
                 <br>online
                  <br>online
           
            </div>
<! modul_two>
            
             <script src="script.js"></script>
            
            
            <div style="color: white; width: 22%; min-height: 400 px; background: #1C6956; font-family: Roman; border: solid 1px black; float: right">
            <p align="center"><textarea  style= "background-color: #ffe; color: #930; width: 70%; height: 500 px" rows="21" cols="95" name= "statement"></textarea>
            
            </p>
                 
                 <p align="center"><input  onclick="my_f()" id="mybutton" type = "submit" value = "Отправить текст">
            </p>
            
            </div>
                 
<! modul_three>
</form>
            <div id = "div_main">
             <p>&nbsp</p>
              
            </div>
            
            <div style="color: black; width: 100%; height: 25%; background: #96aab6; font-family: Roman; border: solid 1px black;  float: left">
                 
                <br>&nbsp date <input type="text" size="10">&nbsp &nbsp<input type="text" size="10">
                 <p>&nbsp use only today data&nbsp<input name="name" type="checkbox" value="true" ></p>
                 <p>&nbsp displays only nicome &nbsp<input name="name" type="checkbox" value="true" ></p>
                 <p>&nbsp displays only online income &nbsp<input name="name" type="checkbox" value="true" ></p>
                 
            </div>
       
</body>
</html>