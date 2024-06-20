#language:pt

Funcionalidade: Autenticar Usuário
	como um usuário do sistema já cadastrado
	eu quero acessar minha conta 
	para que eu possa utilizar os recursos da aplicação

Cenário: Autenticação de usuário com sucesso 
	Dado Acessar a página de autenticação
	E Informar o email de acesso "email@email.com"
	E Informar a senha de acesso "@Admin1234"
	Quando Solicitar o acesso à minha conta de usuário
	Então Sistema autentica meu usuário com sucesso 

Cenário: Validar campo
	Dado Acessar a página de autenticação
	Quando Solicitar o acesso à minha conta de usuário
	Então Mensagens de validação são exibidas


Cenário: Autenticação falhou
	Dado Acessar a página de autenticação
	E Informar o email de acesso "a@a.com"
	E Informar a senha de acesso "@Admin1234"
	Quando Solicitar o acesso à minha conta de usuário
	Então Sistema não autentica usuario
	