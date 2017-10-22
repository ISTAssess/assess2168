<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="description" content="">
    <meta name="author" content="">
    <title>Assessment Tool</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin.css" rel="stylesheet">
    
    <script>
      function validateForm()  {
    	  var flag=0;
    	  console.log(document.getElementById("outOf"));
   		 var x = document.getElementById("outOf");
   		 var y = document.getElementById("enterGrades");
   		var numbers = /^[0-9]+$/; 
   		var pattern = /^\d+$/;
   		var lines = $('textarea').val().split('\n');
   		for(var i = 0;i < lines.length;i++){
   			
   			if(!(pattern.test(lines[i])))  
   	   		{  
   				flag=1;  
   	   		}
   			
   		}
   		
   		if(x.value.match(numbers)&&flag==0)  
   		{  
   		 return true;
   		}  
   		else  
   			
   			
   		{  
   			if(flag==1){
   				alert('Must be a Positive Integer Value'); 
   			y.focus();
   		}
   			else {
   		alert('Must be a Positive Integer Value');  
   		x.focus();  
   		
   			}
   		return false;  
   		}
   		
   	
			}
</script>

  </head>

  <body class="bg-dark">

    <div class="container">

      <div class="card mx-auto mt-5" width="900">
        <div class="card-header">
          ${sec} 
        </div>
        <div class="card-body">
          <form action="/insert.do" method="post" onsubmit="return validateForm();" name="myform">
            <div class="form-group">
           
            <b>Grade Item:</b> ${ins} <br /><br />
            <b>Program Outcome:</b> ${desc} <br /><br />
            
              <b><label for="gr">Grades are out of</label></b>  <input type="text" id = "outOf"  name="outOf" required> <br /><br />
              <b><label for="engr">Enter grades (Copy from MyCourses and paste here)</label></b> <br />
              <font size="3" color="red">${status}</font>
              <br />
              <textarea class="form-control" rows="6" name="enterGrades" id= "enterGrades" required></textarea>
              </div>
             <input type="hidden" name="sec" value = "${sec}|${ins}|${desc}">
            <input type="submit" class="btn btn-primary mx-auto mt-3">
            <input type="button" value = "Cancel" class="btn btn-primary mx-auto mt-3" onclick="self.close()">
            
          </form>
         </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
