<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
    <head>
        <title>New PEX Dashboard MOCK</title>
        <link href="styles.css" rel="stylesheet" type="text/css" />
        
        <link href="../jquery/js/jquery-ui-1.8.21.custom/css/ui-lightness/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css" />        
        <script src="../jquery/js/jquery-ui-1.8.21.custom/js/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../jquery/js/jquery-ui-1.8.21.custom/js/jquery-ui-1.8.21.custom.min.js" type="text/javascript"></script>        
        
        <script src="js/newdashboard.js" type="text/javascript"></script>        
        
        <script>
            $(function() {
                var icons = {
                    header: "ui-icon-circle-arrow-e",
                    headerSelected: "ui-icon-circle-arrow-s"
                };
                $( "#accordion" ).accordion({
                    icons: icons
                });

            });
        </script>   
        
        
        
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            google.load('visualization', '1', {packages: ['corechart']});
        </script>
        
        
        <script type="text/javascript">     
            function getData(divId) {
                // Create and populate the data table.
                var data0 = google.visualization.arrayToDataTable([
                    ['Sample 1', 'Description 1'],
                    ['Work', 11],
                    ['Eat', 2],
                    ['Commute', 2],
                    ['Watch TV', 2],
                    ['Sleep', 7]
                    ]);

                var data1 = google.visualization.arrayToDataTable([
                    ['Sample 2', 'Description 2'],
                    ['Roses', 11],
                    ['Daisies', 2],
                    ]);
                    
                var data2 = google.visualization.arrayToDataTable([
                    ['Sample 3', 'Description 3'],
                    ['Bread', 11],
                    ['Eggs', 2],
                    ['Butter', 2],                    
                    ]);   
                    
                var mockData=new Array();
                mockData[0]=data0;
                mockData[1]=data1;
                mockData[2]=data2;                                    
            
                return mockData[Math.floor(Math.random()*mockData.length)];
            }                    
            
            function drawVisualization() {
                // Create and draw the visualization.
                var options = {title:"My Activities", is3D: true};               
                
                drawChart(getData("myactivitieschart_visualization"), options, "myactivitieschart_visualization");
                drawChart(getData("myteamactivitieschart_visualization"), options, "myteamactivitieschart_visualization");
                drawChart(getData("mybuildingschart_visualization"), options, "mybuildingschart_visualization");                
            }
            
            function drawChart(data, options, divId) {                
                // Create and populate the data table
                var data = getData("bla bla");

                var container = document.getElementById(divId);
                if ( !container ){
                    alert( "Div id not found [" + divId + "]" );
                }else{
                    var chart = new google.visualization.PieChart(container);
                    chart.draw(data, options);
                }
            }            
            
        </script>
        
        
        
    </head>
    <body>
        <div id="leftnavigation">         
            <div id="accordion">
                <h3><a href="#">My Activities</a></h3>
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
            <h2>Right Column</h2>
            <p>
                Ut aliquip ex ea commodo consequat. Ut labore et dolore magna aliqua. Quis nostrud exercitation duis aute irure dolor cupidatat non proident. Lorem ipsum dolor sit amet, sunt in culpa mollit anim id est laborum. Ut aliquip ex ea commodo consequat. Velit esse cillum dolore eu fugiat nulla pariatur. Ut enim ad minim veniam, excepteur sint occaecat ut aliquip ex ea commodo consequat. Consectetur adipisicing elit, mollit anim id est laborum. Cupidatat non proident, sunt in culpa sed do eiusmod tempor incididunt. Eu fugiat nulla pariatur. 
            </p>
            <h2>Lorem Ipsum</h2>
            <p>
                Ullamco laboris nisi lorem ipsum dolor sit amet, mollit anim id est laborum. Quis nostrud exercitation cupidatat non proident, ut labore et dolore magna aliqua. Ut labore et dolore magna aliqua. Excepteur sint occaecat consectetur adipisicing elit, cupidatat non proident. Lorem ipsum dolor sit amet, ullamco laboris nisi ut labore et dolore magna aliqua. Sed do eiusmod tempor incididunt ut aliquip ex ea commodo consequat. Velit esse cillum dolore sunt in culpa cupidatat non proident. Ullamco laboris nisi sed do eiusmod tempor incididunt excepteur sint occaecat. Mollit anim id est laborum. Consectetur adipisicing elit. Velit esse cillum dolore quis nostrud exercitation duis aute irure dolor.
            </p>
        </div>
        


    <script src="js/newdashboard.js" type="text/javascript"></script>            
    <script>
        google.setOnLoadCallback(drawVisualization);        
    </script>
        
    </body>
</html>