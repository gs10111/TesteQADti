# Teste para QA DTi
# Testes Automatizados com Selenium 

## 📄 Descrição
Este projeto contém testes automatizados desenvolvidos em **Java** utilizando o **Selenium WebDriver** para validar as funcionalidades de login e recuperação de senha do site Automation Practice. Os testes foram estruturados com **JUnit 5** para garantir a execução confiável e organizada.

### Funcionalidades
- **Teste de Sucesso no Login**: Valida que o usuário consegue fazer login com credenciais corretas.
- **Teste de Login Inválido**: Garante que mensagens de erro apropriadas são exibidas para credenciais inválidas.
- **Teste de Recuperação de Senha**: Verifica o redirecionamento para a página de recuperação de senha.

---

## 🚀 Como Executar

### Pré-requisitos
1. Instale o **Java 11** ou superior.
2. Instale o **Maven**.
3. Baixe o **ChromeDriver** compatível com a versão do seu navegador Chrome.
   - Você pode baixar o ChromeDriver através do [site oficial]([https://sites.google.com/chromium.org/driver/](https://chromedriver.storage.googleapis.com/index.html?path=72.0.3626.69/)


### Passo a Passo

#### 1️⃣ Clone o Repositório
Execute o seguinte comando no terminal para clonar o projeto:
```bash
git clone (https://github.com/gs10111/TesteQADti.git)
cd TesteQADti
```
### 2️⃣ Configuração do WebDriver
Coloque o arquivo chromedriver.exe na pasta drivers do projeto (ou crie essa pasta se não existir).
Atualize o método setup no arquivo Testes.java com o caminho correto do chromedriver:
``` java
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
```
### 3️⃣ Execute os Testes
Via Maven: Execute os seguintes comandos no terminal:
```bash
mvn install( para instalar as dependencias do projeto)
mvn test
```
###CENARIOS DE TESTE 
### 1
🎥 Cenário: Sucesso no login da conta
Contexto: Validar que o login com credenciais corretas permite o acesso à conta do usuário no site "Automation Practice".
Dado que o usuário esteja na página de login do "Automation Practice" acessando a URL http://www.automationpractice.pl/index.php?controller=authentication&back=my-account
Quando o usuário preencher o campo de email com um email valido( usado no teste testedtiqa@gmail.com )
E preencher o campo de senha com uma senha valida ( usada no teste vKFx797187:~ )
E clicar no botão de login identificado pelo ID SubmitLogin
Então a página deve redirecionar o usuário para a URL http://www.automationpractice.pl/index.php?controller=my-account
E o usuário deve visualizar informações da sua conta.

### 2 
🎥 Cenário: Login com credenciais inválidas
Contexto: Garantir que o sistema exiba a mensagem de erro apropriada quando o usuário tentar realizar login com credenciais inválidas, mantendo a segurança do sistema.
Dado que o usuário esteja na página de login do "Automation Practice" acessando a URL http://www.automationpractice.pl/index.php?controller=authentication&back=my-account
Quando o usuário preencher o campo de email com contaInvalida@gmail.com
E preencher o campo de senha com 123456789inv
E clicar no botão de login identificado pelo ID SubmitLogin
Então a página deve permanecer na URL http://www.automationpractice.pl/index.php?controller=authentication
E exibir a mensagem de erro:
There is 1 error
Authentication failed.
E destacar o erro em um elemento com a classe alert alert-danger.

### 3 
🎥 Cenário: Verificar botão de esquecimento de senha
Contexto: Garantir que o link de recuperação de senha redirecione para a página correta, facilitando a recuperação de contas pelos usuários.
Dado que o usuário esteja na página de login do "Automation Practice" acessando a URL http://www.automationpractice.pl/index.php?controller=authentication&back=my-account
Quando o usuário clicar no link "Forgot your password?" identificado pelo texto do link
Então a página deve redirecionar para a URL http://www.automationpractice.pl/index.php?controller=password
E exibir o formulário de recuperação de senha com o campo para email e botão de envio.

