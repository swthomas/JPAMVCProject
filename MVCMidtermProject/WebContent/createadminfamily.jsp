<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frugal</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
<link rel="shortcut icon" href="/pics/favicon.ico" type="image/x-icon"/>
</head>
<body>


	<div class="container">
		<div class="row text-center" id="h1">
			<h1>frugal</h1>
			<!-- <p>Budgeting through amalgamation.</p> -->
		</div>
		<div class="row text-center">
			<p>Add your info.</p>
		</div>



		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<form  method="POST">
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="username" id="usernamename"
										placeholder="Enter your Username" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">First
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="fName" id="email"
										placeholder="Enter family member first name" />
								</div>
								<div class="form-group">
									<label for="password" class="cols-sm-2 control-label">Last
										Name</label>
									<div class="cols-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
												type="text" class="form-control" name="lName" id="email"
												placeholder="Enter family member first name" />
										</div>
									</div>
								</div>
								<div class="text-center">
									<span id="badlogin"> <c:if test="${! empty badLogin}">
									${badLogin}
								</c:if>
									</span>
								</div>
								</div>
								</div>

						<div class="form-group text-center">
						<c:choose>
							<c:when test="${family != null}">
								<button formaction="CreateAdminMember.do" type="submit" name="familyId" value="${family.id}" hidden="family"
									class="btn btn-default btn-block">Add Another Member</button>
							</c:when>
							<c:when test="${familyCorrection != null}">
								<button formaction="CreateAdminMember.do" type="submit" name="familyId" value="${familyCorrection.id}" hidden="family"
									class="btn btn-default btn-block">Add Another Member</button>
							</c:when>
						</c:choose>
						</div>
											<c:choose>
							<c:when test="${family != null}">
								<button formaction="goAdminHome.do" type="submit" name="familyId" value="${family.id}" hidden="family"
									class="btn btn-default btn-block">Finish</button>
							</c:when>
							<c:when test="${familyCorrection != null}">
								<button formaction="goAdminHome.do" type="submit" name="familyId" value="${familyCorrection.id}" hidden="family"
									class="btn btn-default btn-block">Finish</button>
							</c:when>
						</c:choose>

					</form>
 				</div>
			</div>
		</div>
	</div>


</body>
</html>