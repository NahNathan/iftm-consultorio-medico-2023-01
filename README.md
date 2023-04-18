<!-- <script src="https://gist.github.com/rxaviers/7360908.js"></script>
 -->
 # Sistema de Gerenciamento de Franquias de Consultorios Medicos

![Status](https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-green?style=for-the-badge)

## Descrição do Projeto

Projeto em desenvolvimento para disciplina Programação Orientada a Objetos do curso de Análise e Desenvolvimento de Sistemas. O projeto será desenvolvido utilizando a linguagem Java e consiste em um **sistema de gerenciamento de franquias de consultórios médicos**.

##Detalhes e Funcionalidades do projeto

####1. CRUD de Pessoa
* Atributos:
	* id
	* Nome
	* Endereço
	* CPF
	* Telefone
	* Login
	* Senha
	* Tipo de Usuario
	* Data de Criação
	* Data de Modificação

* Todos podem criar/adicionar uma pessoa no sistema e editar dados da pessoa.
* O usuário pode ser dono de uma franquia, dono de uma unidade de franquia, funcionário administrativo, médico ou paciente.
* Existirá sempre um dono de franquia pré-cadastrado.
* As pessoas podem se cadastrar automaticamente. Após o cadastro, por padrão, as pessoas recebem o papel de paciente.
* O dono da franquia e o dono da unidade podem modificar o estado de uma determinada pessoa.
* Uma pessoa pode ser cadastrada com diferentes papéis.
* O login irá diferenciar os usuários.
* As atividades no software são sempre feitas com o usuário logado.

####2. CRUD de Médico
* Atributos:
	* id
	* CRM
	* Pessoa (Classe)
	* Especialidade
	* Data de Criação
	* Data de Modificação

* Apenas donos da franquia ou donos de uma unidade de franquia podem criar/adicionar um médico no sistema e editar seus dados.
* Um médico tem apenas uma especialidade.
* Um médico pode trabalhar em qualquer franquia.

####3. CRUD de Franquia
* Atributos:
	* id
	* Nome
	* CNPJ
	* Cidade
	* Endereço
	* Responsável (Pessoa cadastrada)
	* Data de Criação
	* Data de Modificação

* Apenas donos da franquia podem criar/adicionar uma nova franquia no sistema e editar seus dados.

####4. CRUD de Unidade da Franquia
* Atributos:
	* id
	* Franquia (Classe)
	* Cidade
	* Endereço
	* Responsável (Pessoa cadastrada)
	* Data de Criação
	* Data de Modificação
	
* Apenas donos da franquia podem criar/adicionar uma nova unidade da franquia no sistema.
* Apenas donos da franquia ou donos de uma unidade de franquia podem editar seus dados.

####5. CRUD de Consulta
* Atributos: 
	* id
	* Dia e horário 
	* Estado (Vazio, Agendada, Cancelada, Realizada)
	* Medico (Classe)
	* Paciente
	* Valor
	* Unidade
	* Data de Criação
	* Data de Modificação

* Todos, exceto os pacientes, que só podem ver as suas consultas, podem criar/adicionar uma consulta no sistema e editar seus dados.
* O médico e o paciente conseguem visualizar informações a respeito das consultas e dos procedimentos.
* O médico consegue visualizar a sua agenda de consultas.
* O médico consegue visualizar as consultas já realizadas por ele.

####6. CRUD de Informações de Consulta
* Atributos: 
	* id
	* Consulta (Classe)
	* Descrição
	* Data de Criação
	* Data de Modificação

* Um médico pode registrar informações da consulta e também buscar informações de consultas já feitas por ele.

####7. CRUD de Procedimento
* Atributos: 
	* id
	* Nome
	* Consulta (Classe)
	* Dia e Horário
	* Estado (Vazio, Agendada, Cancelada, Realizada)
	* Valor
	* Laudo
	* Data de Criação
	* Data de Modificação

* O procedimento pode ser gerado a partir de uma consulta ou a partir do interesse de um paciente
* Apenas os médicos podem criar/adicionar um procedimento  no sistema e editar os suas informações.
* Pacientes podem apenas visualizar o procedimento.

####8. CRUD de Financeiro Administrativo 
* Atributos: 
	* id
	* Tipo do movimento (entrada, saída)
	* Valor
	* Unidade
	* Descritivo do movimento (Consulta, Procedimento, Salário de Funcionário, Energia, Água, Pagamento da Franquia)
	* Data de Criação 
	* Data de Modificação

* Donos da franquia, donos de uma unidade de franquia e administrativos podem criar/editar informações da administração Financeira no Sistema.
* A cada consulta/procedimento é gerado uma entrada para a unidade de franquia.

####9. CRUD de Financeiro Médico
* Atributos: 
	* id
	* Valor do médico
	* Estado (Agendado, Pago)
	* Franquia (Classe)
	* Data de Criação
	* Data de Modificação

* Todo dia 01 o software pesquisa todas as consultas e procedimentos feitos pelo médico no último mês e registra no software o montante total pago a ele.
* O médico ganha 70% do valor da consulta.
* O médico ganha 50% do valor do procedimento.

####10. O software contém um calendário para o ano considerado. Todo dia 01, é ser pago o valor de R$1000,00 a administradora + 5% do faturamento total da clínica relativo a consultas e procedimentos.
* Donos da franquia, donos de uma unidade de franquia e  administrativos podem editar essas informações no sistema.

####11. Relatórios
* Um relatório pode ser gerado com os dados financeiros mensais da Franquia.	
	* Estes dados contém as entradas e saídas administrativas e as saídas de pagamentos aos médicos.
	* Apenas donos da franquia podem gerar este relatório.
* Um relatório pode ser gerado com os dados financeiros mensais das Unidades de Franquia.
	* Este relatório contém as entradas e saídas administrativas e as saídas de pagamentos aos médicos
	* Apenas donos de uma unidade de franquia podem gerar este relatório.
* Um relatório pode ser gerado com os dados de consultas e procedimentos e um dado paciente.
	* Médicos e pacientes podem gerar este relatório.
* Um relatório pode ser gerado com os dados de valores recebidos pelo médico.
	* Apenas médicos podem gerar este relatório.

####12. Permissões de Perfis (logado)
* Administrador
	* Todos os privilégios do software. Esta pessoa tem as permissões do dono da empresa.
* Responsável pela Franquia
	* Todos os privilégios do software. O dono da franquia possui todas as permissões de software de uma dada franquia.
* Administrativo
	* Gerencia consultas e procedimentos.
* Médico
	* Gerencia consultas e procedimentos. 

## Técnicas, tecnologias e ferramentas utilizadas

* Java
* Apache NetBeans IDE 17 
* Programação Orientada a Objetos

## Autores
| [<img src="https://avatars.githubusercontent.com/u/110427113?v=4" width=115><br><sub>Luiz Felippe</sub>](https://github.com/luiz-felippelb) | [<img src="https://avatars.githubusercontent.com/u/97409681?v=4" width=115><br><sub>Nathan Rodrigues</sub>](https://github.com/NahNathan) |
| :---: | :---: |


## Readme em construção...