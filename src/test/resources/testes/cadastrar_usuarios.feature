#language: pt

Funcionalidade: Cadastrar usuário
		Como um usuário do sistema
		eu quero cadastrar meus dados de usuário 
		para que eu tenha acesso interno ao sistema
		
Cenário: Cadastro com sucesso
	Dado Acessar a página de cadastro 
	E Informar no campo nome "Hugo Ledertheil Ruffo"
	E Informar no campo email "email18383@email.com"
	E Informar no campo senha de acesso "@Admin1234"
	E Informa no campo confirme a senha de acesso "@Admin1234"
	Quando Clicar no botão Realizar Cadastro
	Então Uma mensagem de cadastro com sucesso deve ser exibida

Cenário: Cadastro negado
	Dado Acessar a página de cadastro 
	E Informar no campo nome "Hugo Ledertheil Ruffo"
	E Informar no campo email "email@email.com"
	E Informar no campo senha de acesso "@Admin1234"
	E Informa no campo confirme a senha de acesso "@Admin1234"
	Quando Clicar no botão Realizar Cadastro
	Então Uma mensagem de cadastro negado deve ser exibida
	
Cenário: Validação dos campos
	Dado Acessar a página de cadastro 
	Quando Clicar no botão Realizar Cadastro
	Então As mensagens de validação deverão ser exibidas
