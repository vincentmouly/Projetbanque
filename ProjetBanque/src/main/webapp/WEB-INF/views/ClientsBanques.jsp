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

    <title>ClientssBanques</title>

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
                <a class="navbar-brand" href="">Index</a>
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
            <h1>Clients par banques</h1>
            <p></p>
            <!--<p><a class="btn btn-primary btn-large">Call to action!</a>-->
            </p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
        <input type="submit" value="Add" data-toggle="modal" data-target="#myModal">
        </div>
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
								<th>nom</th>
								<th>prenom</th>
								<th>date_naissance</th>
								<th>adresse</th>
							</tr>		
							<c:forEach items = "${cbModel.listeClients}" var="col" >
								<tr>
									<td><a href="Client?id=${col.idClient}">${col.idClient}</a></td>
									<td>${col.nom}</td>
									<td>${col.prenom}</td>
									<td>${col.date_naissance}</td>
									<td>${col.adresse}</td>
									<td><a href="RemoveClient?id=${col.idClient}">Supprimer</a></td>
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
								<th>nom</th>
								<th>prenom</th>
								<th>date_naissance</th>
								<th>adresse</th>
							</tr>			
							<c:forEach items = "${cobModel.listeClients}" var="cob" >
								<tr>
									<td><a href="Client?id=${cob.idClient}">${cob.idClient}</a></td>
									<td>${cob.nom}</td>
									<td>${cob.prenom}</td>
									<td>${cob.date_naissance}</td>
									<td>${cob.adresse}</td>
									<td><a href="RemoveClient?id=${cob.idClient}">Supprimer</a></td>
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
								<th>nom</th>
								<th>prenom</th>
								<th>date_naissance</th>
								<th>adresse</th>
							</tr>			
							<c:forEach items = "${cbcModel.listeClients}" var="coc" >
								<tr>
									<td><a href="Client?id=${coc.idClient}">${coc.idClient}</a></td>
									<td>${coc.nom}</td>
									<td>${coc.prenom}</td>
									<td>${coc.date_naissance}</td>
									<td>${coc.adresse}</td>
									<td><a href="RemoveClient?id=${coc.idClient}">Supprimer</a></td>
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
         				 <a data-toggle="collapse" href="#collapse4">Clients sans Banques</a>
         				 </h4>
     				</div>
     			</div>
     			<div id="collapse4" class="panel-collapse collapse">
	        		<ul class="list-groupe">
			        	<table class="table table-striped table-hover">
							<tr>
								<th>Identifiant</th>
								<th>nom</th>
								<th>prenom</th>
								<th>date_naissance</th>
								<th>adresse</th>
							</tr>			
							<c:forEach items = "${comsModel.listeClients}" var="cos" >
								<tr>
									<td><a href="Client?id=${cos.idClient}">${cos.idClient}</a></td>
									<td>${cos.nom}</td>
									<td>${cos.prenom}</td>
									<td>${cos.date_naissance}</td>
									<td>${cos.adresse}</td>
									<td><a href="RemoveClient?id=${cos.idClient}">Supprimer</a></td>
								</tr>
							</c:forEach>
						</table>
						</ul>
           			</div>
        		</div>
        	</div>
        	<div class="row">
        	<label>Mot-clé</label>
	        	<form action="getByMc" method="get">
	        		<input type="text" name="mc">
	        		<input type="submit" value="Recherche">
        		</form>
        		<table class="table table-striped table-hover">
        		<tr>
					<th>Identifiant</th>
					<th>nom</th>
					<th>prenom</th>
					<th>date_naissance</th>
					<th>adresse</th>
				</tr>
        		<c:forEach items="${clModel2.listeClients}" var="c">
    				<tr>
				        <td><a href="Client?id=${c.idClient}">${c.idClient}</a></td>
		       			<td>${c.nom}</td>
		         		<td>${c.prenom}</td>
		         		<td>${c.date_naissance}</td>
						<td>${c.adresse}</td>
						<td><a href="RemoveClient?id=${cos.idClient}">Supprimer</a></td>
					</tr>
				</c:forEach>
				</table>
        	</div>
        	<div id="myModal" class="modal fade" role="dialog">
		    <div class="modal-dialog">
		    
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Add Client</h4>
		      </div>
		      <div class="modal-body">
		        <p>Nouveau Client.</p>
		        <f:form modelAttribute="clModel" action="addClient" method="get">
					<label>Nom : </label>
					<f:input type="text" path="nom" placeholder="nom"/><br>
					<f:errors path="nom" ></f:errors>
					<label>Prenom : </label>
					<f:input type="text" path="prenom" placeholder="prenom"/><br>
					<f:errors path="prenom" ></f:errors>
					<label>Date de Naissance : </label>
					<f:input type="Date" path="date_naissance" placeholder="date_naissance"/><br>
					<f:errors path="date_naissance" ></f:errors>
					<label>Adresse : </label>
					<f:input type="text" path="adresse" placeholder="adresse"/><br>
					<f:errors path="adresse" ></f:errors>
					<label for ="Banques"> Dans quelle banque voulez-vous ajouter un compte ? </label>
						<select name ="idBanque">
							<option value="0" >Toutes les banques</option>
			 				<c:forEach items = "${clModel.listeBanques}" var="bq">
								<option value="${bq.idBanque}">${bq.nomAgence}</option>
							</c:forEach>
						</select>
					<input type="submit" value="Ajouter un Client">
				</f:form>
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
