<%-- 
    Document   : callServlet
    Created on : 11-Oct-2012, 11:53:33
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   
        <style>
            p {
                text-transform: lowercase;
            }

            p:first-letter {
                text-transform: uppercase;
            }        
        </style>        
        
    </head>
    <body>
        <form id="simpleServlet" method="post" action="SimpleServlet">
            SimpleServlet call! 
            <input type="submit" value="Click me!" />
        </form>
        
        <p>THIS IS AN EXAMPLE SENTENCE.</p>
        <p>THIS IS ANOTHER EXAMPLE SENTENCE.
           AND THIS IS ANOTHER, BUT IT WILL BE ENTIRELY LOWERCASE.</p>
        
    </body>
</html>