<%-- 
    Document   : keyup
    Created on : 07-Jan-2015, 16:48:06
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Keyup event sample</title>
        <script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
        <script type="text/javaScript">
                $('#ContactEvent.content').bind('keyup', function() {
                    if($(this).val() === '') {
                        alert("hola");
                        $('#ContactEvent.receiver').removeAttr('disabled');
                    } else {                
                        $('#ContactEvent.receiver').input.attr( "disabled", '' );
                    }            
                });
        </script>
    </head>
    <body>
        <form>
            Content:<br />
            <input type="text" id="ContactEvent.content" name="ContactEvent_content" /><br />   
            <input type="submit" id="ContactEvent.receiver" disabled value="Register" />
        </form>
        <div id="test">
        </div>
    </body>
</html>