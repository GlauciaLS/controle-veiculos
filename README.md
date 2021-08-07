# Controle de Veículos
<p> Desafio de API Rest para controle de veículos, permitindo cadastros e consultas de veículos/usuários. Há 5 endpoints: </p>

- GET /api/usuarios: Retorna todos os usuários cadastrados.
- POST /api/usuarios: Cadastra um usuário, o corpo da requisição deve conter o nome, e-mail, CPF e a data de nascimento.
- GET /api/usuarios/{id}: Busca um usuário específico com base no id informado.
- GET /api/veiculos: Retorna todos os veículos cadastrados.
- POST /api/veiculos: Cadastra um veículo, o corpo da requisição deve conter a marca, modelo, ano e id do proprietário.

<h2>🛠 Tecnologias</h2>

  - Java 8
  - Spring Boot
  - Spring Cloud Feign
  
<h2>▶️ Como executar o projeto</h2>

Pré-requisitos: Git, Java 8 e Maven.

```bash
# Clonar o repositório
git clone https://github.com/GlauciaLS/controle-veiculos.git

# Entrar dentro do repositório
cd controle-veiculos

# Subir o backend
mvn spring-boot:run 
```
