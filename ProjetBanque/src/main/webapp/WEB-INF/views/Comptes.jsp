<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Comptes</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/heroic-features.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">Accueil</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Banques</a>
                    </li>
                    <li>
                        <a href="Comptes">Comptes</a>
                    </li>
                    <li>
                        <a href="#">Employés</a>
                    </li>
                    <li>
                        <a href="ClientsBanques">Clients</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>Comptes</h1>
            <p></p>
            <!--<p><a class="btn btn-primary btn-large">Call to action!</a>-->
            </p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row"> 
        	<div class="panel-group">
    			<div class="panel panel-default">
      				<div class="panel-heading">
        				<h4 class="panel-title">
         				 <a data-toggle="collapse" href="#collapse1">Banques : LCL</a>
         				 </h4>
     				</div>
     			</div>
     			<div id="collapse1" class="panel-collapse collapse">
	        		<ul class="table-groupe">
			        	<table class="table table-striped table-hover">
							<tr>
								<th>Identifiant</th>
								<th>Solde</th>
								<th>Date_creation</th>
								<th>Delete</th>
							</tr>		
							<c:forEach items = "${coModel.listeComptes}" var="co" >
								<tr>
									<td><a href="Compte?id=${co.idCompte}">${co.idCompte}</a></td>
									<td>${co.solde}</td>
									<td>${co.date_creation}</td>
									<td><a href="RemoveCompte?id=${co.idCompte}">Supprimer</a></td>
								</tr>
							</c:forEach>
						</table>
						</ul>
           			</div>
        		</div>
        	</div>
        	<div class="row">
        	<div class="panel-group">
    			<div class="panel panel-default">
      				<div class="panel-heading">
        				<h4 class="panel-title">
         				 <a data-toggle="collapse" href="#collapse2">Banques : BNP</a>
         				 </h4>
     				</div>
     			</div>
     			<div id="collapse2" class="panel-collapse collapse">
	        		<ul class="table-groupe">
			        	<table class="table table-striped table-hover">
							<tr>
								<th>Identifiant</th>
								<th>Solde</th>
								<th>Date_creation</th>
								<th>Delete</th>
							</tr>		
							<c:forEach items = "${coModelb.listeComptes}" var="cob" >
								<tr>
									<td><a href="Compte?id=${cob.idCompte}">${cob.idCompte}</a></td>
									<td>${cob.solde}</td>
									<td>${cob.date_creation}</td>
									<td><a href="RemoveCompte?id=${cob.idCompte}">Supprimer</a></td>
								</tr>
							</c:forEach>
						</table>
						</ul>
           			</div>
        		</div>
        	</div>
        	<div class="row">
        	<div class="panel-group">
    			<div class="panel panel-default">
      				<div class="panel-heading">
        				<h4 class="panel-title">
         				 <a data-toggle="collapse" href="#collapse3">Banques : CIC</a>
         				 </h4>
     				</div>
     			</div>
     			<div id="collapse3" class="panel-collapse collapse">
	        		<ul class="list-groupe">
			        	<table class="table table-striped table-hover">
							<tr>
								<th>Identifiant</th>
								<th>Solde</th>
								<th>Date_creation</th>
								<th>Delete</th>
							</tr>		
							<c:forEach items = "${coModelc.listeComptes}" var="coc" >
								<tr>
									<td><a href="Compte?id=${coc.idCompte}">${coc.idCompte}</a></td>
									<td>${coc.solde}</td>
									<td>${coc.date_creation}</td>
									<td><a href="RemoveCompte?id=${coc.idCompte}">Supprimer</a></td>
								</tr>
							</c:forEach>
						</table>
						</ul>
           			</div>
        		</div>
        	</div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">
        
        		
            
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-3-offset-3">
                    <p>Copyright &copy; Formation Java 2016</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

</body>

</html>
