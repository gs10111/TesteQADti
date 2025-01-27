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
   - Você pode baixar o ChromeDriver através deste link ([https://sites.google.com/chromium.org/driver/](https://chromedriver.storage.googleapis.com/index.html?path=72.0.3626.69/)


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
# 📝 Cenários de Teste

## 🎥 Cenário: Sucesso no Login da Conta

### Contexto
Validar que o login com credenciais corretas permite o acesso à conta do usuário no site **"Automation Practice"**.

### Passos do Teste
1. **Dado que** o usuário esteja na página de login do **"Automation Practice"** acessando a URL:  
   [http://www.automationpractice.pl/index.php?controller=authentication&back=my-account](http://www.automationpractice.pl/index.php?controller=authentication&back=my-account)
2. **Quando** o usuário:
   - Preencher o campo de email com um email válido (usado no teste: `testedtiqa@gmail.com`)
   - Preencher o campo de senha com uma senha válida (usada no teste: `vKFx797187:~`)
   - Clicar no botão de login identificado pelo ID `SubmitLogin`
3. **Então**:
   - A página deve redirecionar o usuário para a URL:  
     [http://www.automationpractice.pl/index.php?controller=my-account](http://www.automationpractice.pl/index.php?controller=my-account)
   - O usuário deve visualizar informações da sua conta.

---

## 🎥 Cenário: Login com Credenciais Inválidas

### Contexto
Garantir que o sistema exiba a mensagem de erro apropriada quando o usuário tentar realizar login com credenciais inválidas, mantendo a segurança do sistema.

### Passos do Teste
1. **Dado que** o usuário esteja na página de login do **"Automation Practice"** acessando a URL:  
   [http://www.automationpractice.pl/index.php?controller=authentication&back=my-account](http://www.automationpractice.pl/index.php?controller=authentication&back=my-account)
2. **Quando** o usuário:
   - Preencher o campo de email com `contaInvalida@gmail.com`
   - Preencher o campo de senha com `123456789inv`
   - Clicar no botão de login identificado pelo ID `SubmitLogin`
3. **Então**:
   - A página deve permanecer na URL:  
     [http://www.automationpractice.pl/index.php?controller=authentication](http://www.automationpractice.pl/index.php?controller=authentication)
   - Exibir a mensagem de erro:  
     ```
     There is 1 error
     Authentication failed.
     ```
   - Destacar o erro em um elemento com a classe `alert alert-danger`.

---

## 🎥 Cenário: Verificar Botão de Esquecimento de Senha

### Contexto
Garantir que o link de recuperação de senha redirecione para a página correta, facilitando a recuperação de contas pelos usuários.

### Passos do Teste
1. **Dado que** o usuário esteja na página de login do **"Automation Practice"** acessando a URL:  
   [http://www.automationpractice.pl/index.php?controller=authentication&back=my-account](http://www.automationpractice.pl/index.php?controller=authentication&back=my-account)
2. **Quando** o usuário clicar no link **"Forgot your password?"** identificado pelo texto do link.
3. **Então**:
   - A página deve redirecionar para a URL:  
     [http://www.automationpractice.pl/index.php?controller=password](http://www.automationpractice.pl/index.php?controller=password)
   - Exibir o formulário de recuperação de senha com:
     - Campo para email
     - Botão de envio

