<%-- 
    Document   : index
    Created on : Feb 10, 2017, 10:34:21 AM
    Author     : vikto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Small Chat Thingy</title>
        <%
            ChatClient client = new ChatClient("localhost", 8080);
            // Ved ikke om klienten skal modtage dataen fra serveren og skrive ind, eller om det er serveletten der skal håndtere det???
            // Virker som om vi har teoretisk viden om hvordan opgaven kan fuldføres, men ingen praktisk, og der er 1000 måder at løse opgaverne på, men ingen passer sammen.
        %>
    </head>
    <body>
        <form action="Front" method="GET">
            <textarea rows="10" cols="70"><% %></textarea>
            <button type="submit">Get Data</button>
        </form>
        <form action="Front" method="GET">
            Text: <input type="text" name="newText"><br>
            <button type="submit">Enter Data</button>
        </form>
        
    </body>
</html>
