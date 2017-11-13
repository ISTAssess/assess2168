<%@page import="java.util.*"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Assessment-Tool</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet">
    
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
    <style>
	    label, input { display:block; }
	    input.text { margin-bottom:12px; width:95%; padding: .4em; }
	    fieldset { padding:0; border:0; margin-top:25px; }
	    h1 { font-size: 1.2em; margin: .6em 0; }
	    div#users-contain { width: 350px; margin: 20px 0; }
	    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
	    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
	    .ui-dialog .ui-state-error { padding: .3em; }
	    .validateTips { border: 1px solid transparent; padding: 0.3em; }
	    TH{font-family: Arial; font-size: 8pt;}
	    TD{font-family: Arial; font-size: 8pt;}
	    .btn-primary {font-size: 10px;}
	    .btn-danger {font-size: 10px;}
	    .content-wrapper {padding-right: 15px;
                          padding-left: 15px;}
	</style>

    <!-- Custom styles for this template -->
    <link href="css/sb-admin.css" rel="stylesheet">
    
    <script>
    
    
    
	    function doPost(obj,term) {
			window.open("/Report.do?parm1="+obj+"&term="+term);
	    }
	    function changeContent(userName,Role,term) {
	    	
	 // var $dialog = $('<div><select><option value="item1">item1</option></select></div>').dialog({});
           // 
	    	window.open("section.do?InputUserName1="+userName+"&Role="+Role+"&Term="+term.value,"_self");
	    	//alert(term.value);
	    //	document.getElementById("t1").value = term.value;
	       // $('#content').load('login.jsp');
	    }
    </script>

  </head>

  <body class="fixed-nav sticky-footer bg-dark" id="page-top" >

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
      <a class="navbar-brand" href="#">Assessment-Tool</a>
      <button style="margin: 0 auto;" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
          <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
              <a class="nav-link" href="#">
              
             <span class="nav-link-text">
                Welcome ${name} </span>
                <img src="${path}" />
              </a>
          </li>
       <c:forEach items="${userRoles}" var="item">
          <li class="nav-item active" data-toggle="tooltip" data-placement="right" title="Dashboard">
            <a class="nav-link" href="javascript:changeContent('${username}','${item}','2165')">
              <i class="fa fa-fw fa-dashboard"></i>
              <span class="nav-link-text">
                  ${item}</span>
            </a>
         
         </li>
      </c:forEach>  
    </ul>
       
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle mr-lg-2" href="#" id="messagesDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fa fa-fw fa-envelope"></i>
              <span class="d-lg-none">Messages
                <span class="badge badge-pill badge-primary">12 New</span>
              </span>
              <span class="new-indicator text-primary d-none d-lg-block">
                <i class="fa fa-fw fa-circle"></i>
                <span class="number">12</span>
              </span>
            </a>
  
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle mr-lg-2" href="#" id="alertsDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fa fa-fw fa-bell"></i>
              <span class="d-lg-none">Alerts
                <span class="badge badge-pill badge-warning">6 New</span>
              </span>
              <span class="new-indicator text-warning d-none d-lg-block">
                <i class="fa fa-fw fa-circle"></i>
                <span class="number">6</span>
              </span>
            </a>
    
          </li>
           <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
              <i class="fa fa-fw fa-sign-out"></i>
              Logout</a>
          </li>
        </ul>
      </div>
    </nav>
    
    
    <div class="content-wrapper" id="content">
       <%  if(request.getParameter("Role")!=null) {
    	   %>
		<h2><%= request.getParameter("Role") %> View</h2>
		<% } %>
		
		
		
		
		<%  if(request.getParameter("Role")!=null) 
		   if(request.getParameter("Role").equals("Faculty")) {
					%>
		
		<font size="3" color="green">Select term </font> <select class="selectpicker" data-style="btn-primary" id = "t1" onchange="changeContent('${username}','${Role}',this)">
		<c:forEach items="${terms}" var="term"> 
		<option>${term} </option>
		</c:forEach> 
		</select><br />
		
		
		<p>Submit class and section reports here.</p>
		
		
		
		<font size="3" color="green">Term: ${term}</font>
	    <table class="table table-hover" style="width:90%">
			<thead>
			  <tr>
			  	<th>Action</th>
			    <th>Course</th>
			    <th>Section</th>
			    <th>Name</th>
			    <th>Department</th>
			  </tr>
			</thead>
			<tbody>
	    		<c:forEach items="${section}" var="item">
	    		
					<%
						String sec = ((String)pageContext.getAttribute("item"));
						String secSplit[] = sec.split("\\|");
					%>
					<tr>
						<td>
							<span class="nav-link-text">
							<% if(secSplit[4].equals(" Report"))  {%>
								<button type="button" id= "report" class="btn btn-danger btn-block btn-sm" onclick="doPost( '${item}','${term}');">
									<%=secSplit[4] %>
								</button>
								<% }%>
							<% if(secSplit[4].equals(" Update")) { %>
							<button type="button" id= "report" class="btn btn-primary btn-block btn-sm" onclick="doPost( '${item}','${term}');">
									<%=secSplit[4] %>
							</button>
							<% }%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[0]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[1]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[2]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[3]%>
							</span>
						</td>
					</tr>
				</c:forEach>
	        </tbody> 
		</table>
		<% } %>
		
		<%  if(request.getParameter("Role")!=null) 
		   if(request.getParameter("Role").equals("Assessment Coordinator")) {
					%>
		
		<font size="3" color="green">Select term </font> <select class="selectpicker" data-style="btn-primary" id = "t1" onchange="changeContent('${username}','${Role}',this)">
	    <c:forEach items="${terms}" var="term"> 
		<option>${term} </option>
		</c:forEach> 
		</select><br />
		
		
		<p>Submit class and section reports here.</p>
		
		
		
		<font size="3" color="green">Term: ${term}</font>
	    <table class="table table-hover" style="width:45%">
			<thead>
			  <tr>
			  	<th>Program</th>
			    <th>Course</th>
			    <th>Section</th>
			    <th>Course name</th>
			    <th># reported</th>
			    <th># met/exceed</th>
			    <th>Percent</th>
			    <th>Outcome description</th>
			    <th>Instrument</th>
			    <th>% of</th>
			    <th>meet/exceed</th>
			  </tr>
			</thead>
			<tbody>
	    		<c:forEach items="${info}" var="item">
	    		
					<%
						String sec = ((String)pageContext.getAttribute("item"));
						String secSplit[] = sec.split("\\|");
					%>
					<tr>
						<td>
							<span class="nav-link-text">
									<%=secSplit[0] %>
								
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[1]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[2]%>
							</span>
						</td>
						<td style="min-width:200px;">
							<span class="nav-link-text">
								<%=secSplit[3]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[4]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[5]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[6]%>
							</span>
						</td>
						<td style="min-width:200px;">
							<span class="nav-link-text">
								<%=secSplit[7]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[8]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[9]%>
							</span>
						</td>
						<td>
							<span class="nav-link-text">
								<%=secSplit[10]%>
							</span>
						</td>
					</tr>
				</c:forEach>
	        </tbody> 
		</table>
		<% } %>
		
		
		
		
		
		
		
		
	</div>

    <!-- /.content-wrapper -->

    

    <!-- Scroll to Top Button -->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>

    <!-- Logout Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            Select "Logout" below if you are ready to end your current session.
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="/logout.do">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    
  
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/sb-admin.min.js"></script>

  </body>

</html>
