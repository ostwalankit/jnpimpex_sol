<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <title>SO question 4112686</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>
$.ajaxSetup({ cache: false });
$(document).ready(function() {   
$('#submit').click(function(event) {
	alert("hi");
    var form = (event.target.form),
        url = "/Main"
            + "?lName=" + escape(form.elements.lName.text)
            + "&fName=" + escape(form.elements.fName.text);

    $.get(url, function(getData) { 
        $('#somediv').text(getData);         
    });
});
});
</script>

</head>
<body>
<form id="Main" action="Main" method="post">
<h4>AJAX Demo using Jquery in JSP and Servlet</h4>
Enter your Name:
<br/><input type="text" id="fName" name="fName"/>
<br/><input type="text" id="lName" name="lName"/>
<br/><input type="submit" id="submit" value="Ajax Submit"/>
<br/>
</form>

<div id="somediv">....</div>
</body>
</html> -->