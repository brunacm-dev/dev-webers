<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/src/css/style.css">
<title>Login</title>
</head>

<body class="bg-light">
	<header>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fs-5">
			<div class="container-fluid">
				<span class="navbar-brand text-light">Smart Bank | </span>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#menu"
					aria-controls="menu" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="menu">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/views/contato.jsp">Contato</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="bg-dark text-light text-center py-5">
			<h1>Login</h1>
		</div>

	</header>
	<main>
		<section class="p-5">
			<div class="container mt-5 mb-5 py-5 mx-auto w-50">

				<form id="loginForm" action="/sistema-bancario/auth" method="post">
					<h3 class="mb-4">Insira seus dados</h3>
					<div class="mb-3">
						<label for="cpf" class="form-label">Usuário</label> <input
							type="text" class="form-control" id="username" name="cpf" />
					</div>

					<div class="mb-3 py-4">
						<label for="senha" class="form-label">Senha</label> <input
							type="password" class="form-control" id="senha" name="senha"
							required />
					</div>

					<button type="submit" class="btn btn-primary">Entrar</button>
				</form>
			</div>
		</section>
	</main>

	<footer class="bg-custom text-center text-lg-start ">
		<div class="bg-dark text-light text-center p-4">
			<p>
				2023 <i class="bi bi-c-circle"></i> Smart Bank | Desenvolvido por
				Bruna - Henrique - Tiago | Todos os direitos reservados.
			</p>
		</div>
	</footer>

</body>

</html>

</html>