# 🔐 Projeto Login - Spring Boot

Este projeto é um sistema básico de login com **Spring Boot**, utilizando **cookies para autenticação**, cadastro de novos usuários e persistência de dados com JPA.

---

## 📌 Funcionalidades

- ✅ Tela de Login
- ✅ Cadastro de Usuário
- ✅ Armazenamento de Sessão via Cookie
- ✅ Validação de Dados com Jakarta Validation
- ✅ Redirecionamento após login
- ✅ Integração com Banco de Dados via Spring Data JPA

---

## ⚙️ Tecnologias Utilizadas

- Java 21 (JDK)
- Spring Boot
- Spring MVC
- Spring Data JPA
- Jakarta EE (Servlets e Validation)
- Thymeleaf (para templates HTML)
- Maven
- H2 ou outro banco de dados relacional
- Lombok (opcional)

---

## 📁 Estrutura do Projeto

src/
├── main/
│ ├── java/com/recupera/Login/
│ │ ├── controller/
│ │ │ └── LoginController.java
│ │ ├── controller/repositories/
│ │ │ └── UsuarioRepository.java
│ │ ├── model/
│ │ │ └── Usuario.java
│ │ ├── service/
│ │ │ └── CookieService.java
│ │ └── service/autenticador/
│ │ ├── LoginInterceptor.java
│ │ └── LoginInterceptorAppConfig.java
│ └── resources/
│ ├── templates/
│ │ ├── login.html
│ │ ├── index.html
│ │ └── cadastro.html
 └── application.properties


---

## 🚀 Como Executar

### 1. Clone o repositório

```bash
git clone https://github.com/Danielly2007/LoginWithSpringBoot.git
cd LoginWithSpringBoot
```

### 2. Execute com Maven
```bash
mvn clean spring-boot:run
```

### 🧪 Exemplos de Uso
- Login
- Método: POST /logar

### Parâmetros: email e senha
```bash
Resultado: Redireciona para /index ou retorna erro.
```
### Cadastro
- Método: POST /cadastroUser
- Validações: Nome, email e senha não podem ser vazios

```bash
Resultado: Redireciona para /login se sucesso.
```

### 🍪 Autenticação com Cookies
- Cookies são utilizados para:
- usuarioId – ID do usuário logado
- usuarioNome – Nome exibido na tela index

Cookies são lidos com:
```bash
CookieService.getCookie(request, "usuarioNome");
```
E criados com:
```bash
CookieService.setCookie(response, "usuarioNome", nome, tempo);
```
### 💡 Observações
- Banco de dados: configure application.properties para seu banco.
- Validações são feitas com anotações @NotEmpty
- Código usa Model para passar dados entre controller e templates Thymeleaf.

📄 Licença
Projeto com fins educacionais 


