<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>jQuery UI Tabs - Simple manipulation</title>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>        


        <style>
            #dialog label, #dialog input { display:block; }
            #dialog label { margin-top: 0.5em; }
            #dialog input, #dialog textarea { width: 95%; }
            #tabs { margin-top: 1em; }
            #tabs li .ui-icon-close { float: left; margin: 0.4em 0.2em 0 0; cursor: pointer; }
            #tabs-1 { cursor: pointer; }
        </style>
        <script>
            $(function() {
                var tabTitle = $("#tab_title"),
                        tabContent = $("#tab_email"),
                        tabTemplate = "<li><a href='REPLACE#href#'>REPLACE#label#</a> <span class='ui-icon ui-icon-close' role='presentation'>Remove Tab</span></li>",
                        tabCounter = 2,
                        maxTabCounter = 3, //Tab '+' counts for maxTabCounter!
                        currentTabCounter = 0;
                        
                var tabs = $("#tabs").tabs({
                    event: "mouseover"
                });
                
                $('a#ui-id-1').unbind('mouseover');

                // modal dialog init: custom buttons and a "close" callback resetting the form inside
                var dialog = $("#dialog").dialog({
                    autoOpen: false,
                    modal: true,
                    buttons: {
                        Add: function() {
                            addTab();
                            $(this).dialog("close");
                        },
                        Cancel: function() {
                            $(this).dialog("close");
                        }
                    },
                    close: function() {
                        form[ 0 ].reset();
                    }
                });

                // addTab form: calls addTab function on submit and closes the dialog
                var form = dialog.find("form").submit(function(event) {
                    addTab();
                    dialog.dialog("close");
                    event.preventDefault();
                });

                // actual addTab function: adds new tab using the input from the form above
                function addTab() {
                    var label = tabTitle.val() || "Tab " + tabCounter,
                            id = "tabs-" + tabCounter,
                            li = $(tabTemplate.replace('REPLACE#href#', "#" + id).replace('REPLACE#label#', label)),
                            tabContentHtml = tabContent.val() || "Tab " + tabCounter + " content.";

                    tabs.find(".ui-tabs-nav").append(li);
                    tabs.append("<div id='" + id + "'><p>" + tabContentHtml + "</p></div>");
                    tabs.tabs("refresh");
                    tabCounter++;
                    currentTabCounter = $('#tabs ul li').length;
                    if (currentTabCounter >= maxTabCounter) {                        
                        $('a#ui-id-1').hide();
                        $('#tabs-1').hide();
                    }
                }

                // a#ui-id-1-1 link: just opens the dialog
                $("a#ui-id-1").click(function() {
                    dialog.dialog("open");
                });

                // close icon: removing the tab on click
                tabs.delegate("span.ui-icon-close", "click", function() {
                    var panelId = $(this).closest("li").remove().attr("aria-controls");
                    $("#" + panelId).remove();
                    tabs.tabs("refresh");
                    currentTabCounter = $('#tabs ul li').length;
                    if (currentTabCounter < maxTabCounter) {                        
                        $('a#ui-id-1').show();
                        $('#tabs-1').show();
                    }                    
                });

                tabs.bind("keyup", function(event) {
                    if (event.altKey && event.keyCode === $.ui.keyCode.BACKSPACE) {
                        var panelId = tabs.find(".ui-tabs-active").remove().attr("aria-controls");
                        $("#" + panelId).remove();
                        tabs.tabs("refresh");
                    }
                });
            });
        </script>
    </head>
    <body>
        <div id="dialog" title="Search Person">
            <form>
                <fieldset class="ui-helper-reset">
                    <label for="tab_email">Email</label>
                    <textarea name="tab_email" id="tab_email" class="ui-widget-content ui-corner-all">user@pexsoftware.com</textarea>
                </fieldset>
            </form>
        </div>

        <div id="tabs">
            <ul>
                <li><a id="ui-id-1">+</a></li>
            </ul>
            <div id="tabs-1">
                No additional tenants
            </div>
        </div>

    </body>
</html>