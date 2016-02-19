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
            <h1>Sample Content</h1>
            <p>
                This is the content section of the page. As you can see, I'll use structural markup
                like &lt;p&gt;&lt;/p&gt;, &lt;strong&gt;&lt;/strong&gt;, and &lt;em&gt;&lt;/em&gt;. This
                will help keep the page valid in XHTML. 
            </p>
            <p>
                Consectetur adipisicing elit, ut aliquip ex ea commodo consequat. Sed do eiusmod tempor incididunt in reprehenderit in voluptate lorem ipsum dolor sit amet. Excepteur sint occaecat qui officia deserunt duis aute irure dolor. Ut labore et dolore magna aliqua. Sed do eiusmod tempor incididunt sunt in culpa excepteur sint occaecat. Ut aliquip ex ea commodo consequat. In reprehenderit in voluptate eu fugiat nulla pariatur. Mollit anim id est laborum. Qui officia deserunt. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
            </p>
            <h2>Lorem Ipsum</h2>
            <p>
                Consectetur adipisicing elit, quis nostrud exercitation velit esse cillum dolore. Ullamco laboris nisi qui officia deserunt ut enim ad minim veniam. Cupidatat non proident, duis aute irure dolor sunt in culpa. Lorem ipsum dolor sit amet, ullamco laboris nisi excepteur sint occaecat. Ut aliquip ex ea commodo consequat. Ut labore et dolore magna aliqua. Quis nostrud exercitation. Ut labore et dolore magna aliqua. Sed do eiusmod tempor incididunt duis aute irure dolor sunt in culpa. Ullamco laboris nisi lorem ipsum dolor sit amet, ut aliquip ex ea commodo consequat. Mollit anim id est laborum. Excepteur sint occaecat ut enim ad minim veniam, quis nostrud exercitation.
            </p>
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
        
    </body>
</html>