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
<title>Smart Bank</title>
</head>

<body class="bg-light">
	<header>
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
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/views/login-page.jsp">
								<i class="bi bi-box-arrow-in-right"></i> Login
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div>
			<img
				src="${pageContext.request.contextPath}/resources/images/dev-smart-bank.png"
				class="img-fluid" alt="Imagem de Header">
		</div>
	</header>

	<main>
		<section>
			<div class="container-fluid p-5">
				<div class="row">
					<div class="col-md-6 col-lg-6 text-center">
						<h3 class="text-uppercase">Sobre o Website</h3>
						<p>Esse site foi desenvolvido para a disciplina de dev web</p>
					</div>

					<div class="col-md-6 col-lg-6 text-center">
						<h3 class="text-uppercase">Redes Sociais</h3>
						<ul
							class="d-flex gap-2 justify-content-center justify-content-lg-center list-unstyled">
							<li><a href="#" class="social-icon text-dark"><i
									class="bi bi-envelope fs-2"></i></a></li>
							<li><a href="#" class="social-icon text-dark"><i
									class="bi bi-facebook fs-2"></i></a></li>
							<li><a href="#" class="social-icon text-dark"><i
									class="bi bi-instagram fs-2"></i></a></li>
							<li><a href="#" class="social-icon text-dark"><i
									class="bi bi-twitter fs-2"></i></a></li>
						</ul>
					</div>
				</div>
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

	<!-- Scripts do Bootstrap (jQuery, Popper.js, Bootstrap JS) via CDN -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Zd3nAaMDYYArAJ86B/KbKBPFIyLjv7W/TsCjbp3E7LgIfZe8zRb8RLLOESwl/j1a"
		crossorigin="anonymous"></script>

	<!-- Script para manipular o formulário de login -->
	<script src="/src/js/login-script.js"></script>
</body>
</html>
