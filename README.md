🧪 Projeto de Testes de API - GoRest
Automação de testes de API REST utilizando a API pública GoRest, com foco em validação de endpoints, geração de evidências em PDF e integração contínua.

🚀 Tecnologias Utilizadas
✅ Java 17

✅ Maven

✅ RestAssured

✅ Cucumber

✅ JUnit

✅ iText (para geração de evidências em PDF)

✅ SLF4J + Logback (logging)

✅ GitHub Actions (CI)

✅ Jenkins (execução remota)

✅ Funcionalidades Cobrindo
 Listagem paginada de usuários

 Consulta por usuário específico

 Criação de usuários válidos/inválidos

 Atualização de dados de usuários

 Exclusão de usuários

 Validação de erros e status HTTP

 Geração de evidências automatizadas em PDF

⚙️ Como Executar
🖥️ Requisitos
Java 17 instalado

Maven instalado

🧪 Comando de Execução
Para rodar todos os testes, basta usar o comando:

bash
Copy
Edit
mvn clean test
📁 Evidências
Os arquivos de evidência são gerados automaticamente e salvos no seguinte diretório:

swift
Copy
Edit
Evidences/API/<nome-do-cenário>/
Cada cenário de teste gerará um arquivo PDF contendo o código de status, corpo da resposta e cabeçalhos, como evidência da execução dos testes.

🔐 Autenticação
Para acessar os endpoints que exigem autenticação, você precisa obter um token de acesso. Siga os passos abaixo:

Acesse GoRest API.

Gere um token de autenticação pessoal.

No código, adicione o header com o token de autenticação no formato Bearer:

pgsql
Copy
Edit
.header("Authorization", "Bearer SEU_TOKEN_AQUI")
🤖 Integração Contínua
Este projeto utiliza GitHub Actions para integração contínua. A cada push ou pull request no repositório, um pipeline de testes será executado. O arquivo de configuração do GitHub Actions está localizado em .github/workflows/ci.yml. Ele é responsável por rodar os testes automaticamente, garantindo que as mudanças não quebrem funcionalidades existentes.

Se preferir rodar o projeto no Jenkins, basta configurar um job freestyle ou pipeline e executar:

bash
Copy
Edit
mvn clean test
As evidências geradas, como arquivos PDF, podem ser arquivadas no Jenkins como artefatos, garantindo que todos os resultados dos testes sejam mantidos e visíveis.
