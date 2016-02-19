
$(function() {
    var icons = {
        header: "ui-icon-circle-arrow-e",
        headerSelected: "ui-icon-circle-arrow-s"
    };
    $( "#accordion" ).accordion({
        icons: icons
    });

}); 

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

    options = {title:"My team Activities", is3D: true};
    drawChart(getData("myteamactivitieschart_visualization"), options, "myteamactivitieschart_visualization");

    options = {title:"My Building(s)", is3D: true};
    drawChart(getData("mybuildingschart_visualization"), options, "mybuildingschart_visualization");                

    options = {title:"Last 3 days", is3D: true};
    drawChart(getData("last3dayschart_visualization"), options, "last3dayschart_visualization");                

    options = {title:"Today + 2 days", is3D: true};
    drawChart(getData("today2dayschart_visualization"), options, "today2dayschart_visualization");    

    options = {title:"Occupancy ", is3D: true};
    drawChart(getData("occupancy_visualization"), options, "occupancy_visualization");    
}

function drawChart(data, options, divId) {                
    var container = document.getElementById(divId);
    if ( !container ){
        alert( "Div id not found [" + divId + "]" );
    } else {
        var chart = new google.visualization.PieChart(container);
        chart.draw(data, options);
    }
    
    var idPieChartsAllowedClickable = ['myactivitieschart_visualization', 'myteamactivitieschart_visualization', 'mybuildingschart_visualization' ];
    if ($.inArray(divId, idPieChartsAllowedClickable) > -1) {        
        alert("Yes");
    }
    else {
        alert("No");
    }
}

function refreshOccupancyChart() {
    var date = $("#dateField").datepicker("getDate");
    var formattedDate = $.datepicker.formatDate('yymmdd', date);
    if ( console ){
        console.log( " Formatted date " + formattedDate );
    }
    var landlordId = document.getElementById('landlord').value;
    if ( console ){
        console.log( " Landlord id " + landlordId );
    }
    var bookingStatus = document.getElementById('bookingStatus');
    var arrayBookingStatus = new String("&");    
    for (x=0;x<bookingStatus.length;x++) {
        if (bookingStatus[x].selected) {
            if ( console ){
                console.log( " BookingStatus id " + bookingStatus[x].value );
            }
            arrayBookingStatus = arrayBookingStatus.concat(bookingStatus[x].value, "&");
        }
    }  
    
    
    try
    {
        alert('landlordId:' + landlordId + ' dateString:' + formattedDate + ' arrayBookingStatus:' + arrayBookingStatus);
        WSMock.getData({'landlordId': landlordId, 'dateString': formattedDate, 'arrayBookingStatus': arrayBookingStatus, $callback:reportCallback});
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

function reportCallback(code, request, value){
    alert('reportCallback');
    
    alert("value.hola=> " + value.hola);
    alert("value.adios=> " + value.adios);    
}

//$('a[id^="ma_"]').click(function() {
//    var options = {title:"My Activities", is3D: true}; 
//    drawChart(getData("myactivitieschart_visualization"), options, "myactivitieschart_visualization");    
//    return false;
//});
$('a[id^="ma_"]').click(function() {
//  alert("Menu My Activities - Clickable");    
    
  var myForm = document.createElement("form");
  
  myForm.method="get" ;
  myForm.target='_blank';
  myForm.action='http://localhost:8091/enterprise/handlers/searchH.jsp';
  
//  var myInput1 = document.createElement("input") ;
//  myInput1.setAttribute("type", "hidden");
//  myInput1.setAttribute("name", "_entity");
//  myInput1.setAttribute("value", "Activity");
//  myForm.appendChild(myInput1) ;  
  
  var name  = ['_entity',  'Activity.type',       '_targetUrl',             'subsearch' ];
  var value = ['Activity', '4320057098886781837', '../Activity/select.jsp', 'false' ];
  
  var i;
  for (i=0; i<name.length; i++) {
    var myInput = document.createElement("input") ;
    myInput.setAttribute("type", "hidden");  
    myInput.setAttribute("name", name[i]);
    myInput.setAttribute("value", value[i]);
    myForm.appendChild(myInput);      
  }  
  
  document.body.appendChild(myForm);  
  myForm.submit();
  document.body.removeChild(myForm);    

  var options = {title:"My Activities", is3D: true}; 
  drawChart(getData("myactivitieschart_visualization"), options, "myactivitieschart_visualization");    
  return false;
});

$('a[id^="mt_"]').click(function() {
    var options = {title:"My team Activities", is3D: true}; 
    drawChart(getData("myteamactivitieschart_visualization"), options, "myteamactivitieschart_visualization");    
    return false;
});

$('a[id^="mb_"]').click(function() {
    var options = {title:"My Building(s)", is3D: true}; 
    drawChart(getData("mybuildingschart_visualization"), options, "mybuildingschart_visualization");    
    return false;
});

$(function() {
    $("#dateField").datepicker({ dateFormat: 'dd/mm/yy'});
}); 
