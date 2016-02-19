<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.pexsoftware.enterprise.dashboard.ws.WSMock"%>

<html>
    <head>
        <title>New PEX Dashboard MOCK - Clickable</title>
        <link href="styles.css" rel="stylesheet" type="text/css" />
        
        <link href="../jquery/js/jquery-ui-1.8.21.custom/css/ui-lightness/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css" />        
        <script src="../jquery/js/jquery-ui-1.8.21.custom/js/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../jquery/js/jquery-ui-1.8.21.custom/js/jquery-ui-1.8.21.custom.min.js" type="text/javascript"></script>        
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/rest-js"></script>
        
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            google.load('visualization', '1', {packages: ['corechart']});
        </script>      
        
        
        <script>            
            function refreshOccupancyChart2() {
                try
                {
                    alert('landlordId:' + "landlordId" + ' dateString:' + "formattedDate" + ' arrayBookingStatus:' + "arrayBookingStatus");
                    WSMock.getData({'landlordId': "landlordId", 'dateString': "formattedDate", 'arrayBookingStatus': "arrayBookingStatus", $callback:reportCallback2});
                }
                catch(err)
                {
                    txt="There was an error on this page.\n\n";
                    txt+="Error description: " + err.message + "\n\n";
                    alert(txt);
                }

                var options = {title:"Occupancy ", is3D: true};
                drawChart(getData("occupancy_visualization"), options, "occupancy_visualization");     
            }

            function reportCallback2(code, request, value){
                alert('reportCallback');

                alert("value.hola=> " + value.hola);
                alert("value.adios=> " + value.adios);    
            }            
            
        </script>
        
        
    </head>
    <body>
        <!-- /home/user/projects/enterprise/web/Activity/search.jsp -->
        <input type="hidden" id="ActivityType" name="ActivityType" value="vacio" />
        <input type="hidden" name="_entity" value="Activity" />
        <input type="hidden" name="_targetURL" value="../Activity/select.jsp" />
        
        <div id="leftnavigation">
            <div id="accordion">                
                <h2><a href="#">My Activities</a></h2>
                <div>
                    <div><p><a id="ma_referencechecks">Reference checks</a><p></div>
                    <div><p><a id="ma_creditchecks">Credit checks</a><p></div>
                    <div><p><a id="ma_customer_viewing">Customer viewing</a><p></div>
                    <div><p><a id="ma_paymentfailures">Payment failures</a><p></div>
                </div>
                
                <h3><a href="#">My team Activities</a></h3>
                <div>
                    <div><p><a id="mt_maintenance">Maintenance</a><p></div>
                    <div><p><a id="mt_checkins">Check ins</a><p></div>
                    <div><p><a id="mt_expiringonholds">Expiring on holds</a><p></div>
                </div>
                
                <h3><a href="#">My Building(s)</a></h3>
                <div>
                    <div><p><a id="mb_maintenance">Maintenance</a><p></div>
                    <div><p><a id="mb_checkins">Check ins</a><p></div>
                    <div><p><a id="mb_expiringonholds">Expiring on holds</a><p></div>
                </div>
            </div>            
        </div>

        <div id="centralnavigation">            
            <div id="myactivitieschart">
                <div id="myactivitieschart_visualization" style="width: 400px; height: 250px;"></div>
            </div>
            
            <div id="myteamactivitieschart">
                <div id="myteamactivitieschart_visualization" style="width: 400px; height: 250px;"></div>
            </div>

            <div id="mybuildingschart">
                <div id="mybuildingschart_visualization" style="width: 400px; height: 250px;"></div>
            </div>
        </div>
        
        <div id="rightnavigation">
            <div id="occupancy">
                <center><h2>Occupancy</h2></center>

                <div id="formDiv" class="inline" style="border: 1px solid black;">                
                    <label for="date">Date</label><input type="text" value="11/08/2012" name="date" id="dateField"><br/>
                    <label for="landlord">Landlord</label>
                    <select name="landlord" id="landlord">
                        <option value="Urbanest UK">Urbanest UK</option>
                        <option value="Urbanest Southbank">Urbanest Southbank</option>
                    </select><br/>
                    <label for="bookingStatus">Tenancy status</label>                
                    <select name="bookingStatus" id="bookingStatus" multiple="multiple">
                        <option value="ONHOLD">1. On Hold</option>
                        <option value="FUTURE">2. Booking confirmed</option>
                    </select><br/>
                    <div style="text-align: right;">
                        <input type="button" onclick="refreshOccupancyChart2()" value="Refresh Report" />
                    </div>
                    
                    <div id="occupancychart">
                        <div id="occupancy_visualization" style="width: 400px; height: 250px;"></div>
                    </div>                    
                </div>   
                
            </div>            

            <div id="activitystatusstats">
                <center><h2>Activity Status Stats</h2></center>
                <div id="last3dayschart">
                    <div id="last3dayschart_visualization" style="width: 400px; height: 250px;"></div>
                </div>                            
                <div id="today2dayschart">
                    <div id="today2dayschart_visualization" style="width: 400px; height: 250px;"></div>
                </div>                
            </div>  

        </div>        

    <script src="js/newdashboard.js" type="text/javascript"></script>                
    
    <script>
        google.setOnLoadCallback(drawVisualization);              
    </script>
        
    </body>
</html>