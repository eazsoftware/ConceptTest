<%@page import="sun.awt.SunHints.Value"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%  
    java.util.ArrayList list = new java.util.ArrayList();
    list.add("$0.00 to $1,000,000.00");
    list.add("$1,000,000.00 to $1,000,000,000.00");
    session.setAttribute("list", list);
%>

<%  
    String strSVMyActivities = "*:All,referencechecks:Reference checks,ARRANGE#PVIEW:Customer viewing,CARFAI:Payment failures";
    
    String[] aSVMyActivities = null;
    if (strSVMyActivities != null) {
        aSVMyActivities = strSVMyActivities.split(",");
    }
    session.setAttribute("aSVMyActivities", aSVMyActivities);
%>

<html>
    <head>
        <title>JSTL Foreach samples</title>        
        
        <script>                    
        </script>
                
    </head>
    <body>
        <div id="center"> 
            <h2>JSTL Foreach samples 3</h2>   
            
            <c:forEach var="i" begin="1" end="20" step="1" varStatus ="status">
                <c:out value="${i}" /> 
            </c:forEach>            
            
            <c:forEach items ="${acTypesToSave}" var ="activityType">

                <tr style ="border: 1px solid">                                        
                    <td> <c:out value="${activityType.name}"/> </td> 
                    <td> <c:out value="${activityType.code}"/> </td> 
                    <td> <c:out value="${activityType.position}"/> </td>                                   

                    <td> <a href ="../ActivityType/view.jsp?id=${activityType.ID}"/> <c:out value="${activityType.ID}"/></td> 
                    <td> <c:out value=" "/> </td>          
                </tr>    

            </c:forEach> 
            
            <c:forEach items="${list}" var="value">
                <li><c:out value="${value}"/></li>
            </c:forEach>
                
            <c:forEach items="${aSVMyActivities}" var="value">
                <%                     
                    String[] aValue = pageContext.getAttribute("value").toString().split(":");     
                    for(String str : aValue) {
                        System.out.println(str);
                    }
                    request.setAttribute("aValue", aValue);
                %>
                <c:forEach items="${aValue}" var="innerValue">
                    <li><c:out value="${innerValue}"/></li>
                </c:forEach>                  
            </c:forEach>                
                    
                    
            <c:forEach items="${aSVMyActivities}" var="value">
                <%                     
                    String[] aValues = pageContext.getAttribute("value").toString().split(":");     
                    session.setAttribute("aValueCode", aValues[0]);
                    session.setAttribute("aValueName", aValues[1]);
                %>
                
                <li><c:out value="${aValueCode}"/></li>
                <li><c:out value="${aValueName}"/></li>
                
            </c:forEach>                      
            
        </div>
    </body>
    
</html>