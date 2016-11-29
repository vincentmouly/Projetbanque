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

    <title>Client : ${clModel.nom}</title>

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
            <h1>Client : ${clModel.nom}</h1>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Client</h3>
                <p>
	                <table class="table table-striped table-hover">
							<tr>
								<th>Identifiant</th>
								<th>nom</th>
								<th>prenom</th>
								<th>date_naisssance</th>
								<th>adresse</th>
							</tr>		
							<tr>
								<td>${clModel.idClient}</td>
								<td>${clModel.nom}</td>
								<td>${clModel.prenom}</td>
								<td>${clModel.date_naissance}</td>
								<td>${clModel.adresse}</td>
								<td><input type="submit" value="Update" data-toggle="modal" data-target="#myModal"></td>
							</tr>
					</table>
					<input type="submit" value="Create Compte" data-toggle="modal" data-target="#myModal2">
					<h3>Liste des Comptes</h3>
					<p>
					<table class="table table-striped table-hover">
						<tr>
							<th>Identifiant</th>
							<th>Solde</th>
							<th>Date_creation</th>
						</tr>
						<c:forEach items = "${clModel.listeComptes}" var="c" >
							<tr>
								<td>${c.idCompte}</td>
								<td>${c.solde}</td>
								<td>${c.date_creation}</td>
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
		        <h4 class="modal-title">Update Client</h4>
		      </div>
		      <div class="modal-body">
		        <form action="updateClient" method="get">
	         		<input type="text" hidden="true" name="id" value="${clModel.idClient}"/> 
			        <label>Modif Nom :</label>
	         		<input type="text" name="nom" value="${clModel.nom}"/><br>  
			        <label>Modif Prenom :</label>
	         		<input type="text" name="prenom" value="${clModel.prenom}"/><br> 
			        <label>Modif Date de Naissance :</label>
	         		<input type="Date" name="date_naissance" value="${clModel.date_naissance}"/><br> 
			        <label>Modif Adresse :</label>
	         		<input type="text" name="adresse" value="${clModel.adresse}"/>
	         		<input type="submit" value="Update">
         		</form>
		      </div>
		    </div>
		
		  </div>
		</div>
        <!-- Modal -->
		<div id="myModal2" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Update Client</h4>
		      </div>
		      <div class="modal-body">
		        <form action="CreateCompte" method="get">
	         		<input type="text" hidden="true" name="idClient" value="${clModel.idClient}"/> 
			        <label for ="Banques"> Quelle type de compte souhaitez-vous créer? </label>
						<select name ="Compte">
							<option value="0" >Toutes les types</option>
								<option value="Courant">Courant</option>
								<option value="Epargne">Epargne</option>
						</select> 
			        <label for ="Banques"> Dans quelle banque souhaitez-vous créez un compte? </label>
						<select name ="idBanque">
							<option value="0" >Toutes les banques</option>
			 				<c:forEach items = "${clModel.listeBanques}" var="bq">
								<option value="${bq.idBanque}">${bq.nomAgence}</option>
								</c:forEach>
						</select>
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
