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
<title>Contato</title>
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
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath}/views/login-page.jsp">
								<i class="bi bi-box-arrow-in-right"></i> Login
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="bg-dark text-light text-center py-5">
			<h1>Contato</h1>
		</div>
	</header>
	Ï

	<main>
		<section class="p-5">
			<div class="container p-4">
				<div class="row">
					<div class="col-lg-6">
						<h2 class="mb-4">Informações de Contato</h2>
						<p>
							<i class="bi bi-geo-alt-fill fs-3"></i> Endereço: Rua UFF, 123,
							Niteroi, RJ
						</p>
						<p>
							<i class="bi bi-envelope-fill fs-3"></i> E-mail:
							dev-webers@meusite.com
						</p>
						<p>
							<i class="bi bi-phone-fill fs-3"></i> Telefone: (21) 3456-7890
						</p>
					</div>
					<div class="col-lg-6">
						<h2 class="mb-4">Entre em Contato</h2>
						<form>
							<div class="mb-3">
								<label for="name" class="form-label">Nome</label> <input
									type="text" class="form-control" id="name"
									placeholder="Seu nome" required />
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">E-mail</label> <input
									type="email" class="form-control" id="email"
									placeholder="Seu e-mail" required />
							</div>
							<div class="mb-3">
								<label for="message" class="form-label">Mensagem</label>
								<textarea class="form-control" id="message" rows="5"
									placeholder="Digite sua mensagem"></textarea>
							</div>
							<button type="submit" class="btn btn-secondary">Enviar</button>
						</form>
					</div>
				</div>
			</div>
		</section>
	</main>

	<footer class="bg-custom text-center text-lg-start">
		<div class="bg-dark text-light text-center p-4">
			<p>
				2023 <i class="bi bi-c-circle"></i> Smart Bank | Desenvolvido por
				Bruna - Henrique - Tiago | Todos os direitos reservados.
			</p>
		</div>
	</footer>

</body>
</html>
