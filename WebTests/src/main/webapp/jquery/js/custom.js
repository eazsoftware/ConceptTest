//$(document).ready(function() {
//    $("a").click(function() {
//        alert("Hello world!");
//    });
//});

//$(document).ready(function(){
//   $("a").toggle(function(){
//     $(".stuff").hide('slow');
//   },function(){
//     $(".stuff").show('fast');
//   });
//});
 
$(document).ready(function() {
   $("#orderedlist").addClass("red");
});

$(function() {
   $("#orderedlist > li").addClass("blue");
});

//$(document).ready(function() {
//   $("#orderedlist > li").addClass("blue");
//});

$(document).ready(function() {
   $("#orderedlist li:last").hover(function() {
     $(this).addClass("green");
   },function(){
     $(this).removeClass("green");
   });
 });
 
$(document).ready(function() {
   $("#orderedlist").find("li").each(function(i) {
     $(this).append( " BAM! " + i );
   });
});

//$(document).ready(function() {
//   // use this to reset a single form
//   $("#reset").click(function() {
//     $("form")[0].reset();
//   });
//});

$(document).ready(function() {
   // use this to reset several forms at once
   $("#reset").click(function() {
     $("form").each(function() {
       this.reset();
     });
   });
});

$(document).ready(function(){
   $("a").hover(function(){
     $(this).parents("p").addClass("highlight");
   },function(){
     $(this).parents("p").removeClass("highlight");
   });
});

$(document).ready(function() {
   // generate markup
   $("#rating").append("Please rate: ");
   
   for ( var i = 1; i <= 5; i++ ) {
     $("#rating").append("<a href='#'>" + i + "</a> ");
   }
   
   // add markup to container and apply click handlers to anchors
   $("#rating a").click(function(e) {
     // stop normal link click
     e.preventDefault();
     
     // send request
     $.post("rate.php", {rating: $(this).html()}, function(xml) {
       // format and output result
       $("#rating").html(
         "Thanks for rating, current average: " +
         $("average", xml).text() +
         ", number of votes: " +
         $("count", xml).text()
       );
     });
   });
 });
 
  $(document).ready(function(){
   $("a").toggle(function(){
     $(".stuff").animate({ height: 'hide', opacity: 'hide' }, 'slow');
   },function(){
     $(".stuff").animate({ height: 'show', opacity: 'show' }, 'slow');
   });
 });
 
$(document).ready(function(){
   $("#large").tablesorter();
 });
 
$(document).ready(function() {
   $("#large").tablesorter({
     // striping looking
     widgets: ['zebra']	
   });
 });