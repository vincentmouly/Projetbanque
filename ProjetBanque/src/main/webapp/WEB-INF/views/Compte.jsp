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

    <title>Compte id :</title>

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
            <h1>Compte ${comModel.idCompte}</h1>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Compte</h3>
                <p>
	                <table class="table table-striped table-hover">
						<tr>
						<th>Identifiant</th>
						<th>Solde</th>
						<th>Date_creation</th>
						</tr>
							<tr>
								<td>${comModel.idCompte}</td>
								<td>${comModel.solde}</td>
								<td>${comModel.date_creation}</td>
								<td><input type="submit" value="Update" data-toggle="modal" data-target="#myModal"></td>
							</tr>
					</table>
					<h3>Liste des Opérations</h3>
					<p>
					<table class="table table-striped table-hover">
						<tr>
						<th>Identifiant</th>
						<th>Date</th>
						<th>Montant</th>
						</tr>
						
						<c:forEach items = "${comModel.operations}" var="o" >
							<tr>
								<td>${o.ido}</td>
								<td>${o.date}</td>
								<td>${o.montant}</td>
							</tr>
						</c:forEach>
					</table>
					</p>
                </p>
            </div>
        </div>
        <!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Update Compte</h4>
		      </div>
		      <div class="modal-body">
		        <p>Nouveau Solde.</p>
		        <form action="updateCompte" method="get">
         		<input type="text" hidden="true" name="id" value="${comModel.idCompte}"/> 
         		<input type="text" name="soldeup" value="${comModel.soldeup}"/> 
         		<input type="submit" value="Update">
         		</form>
		      </div>
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
