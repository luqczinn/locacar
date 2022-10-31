# Trabalho Final: Locacar
#### REQUISITOS/PROTÓTIPOS
Físicos: estação de trabalho PC ou Mobile com conexão estável com a internet.
Não-físicos: banco de dados hospedado na nuvem para maior tráfego e velocidade de dados; servidor
web capaz de construir e compilar os códigos de sistema de forma que fique suave e nítido ao usuário.
#### LISTA DE FUNCIONALIDADES
Conseguir adicionar/remover veículos no estoque; capacidade de definir status de veículo; capacidade
de listar clientes; capacidade de listar contas a pagar/receber; capacidade de cadastrar clientes;
capacidade de autoatendimento do cliente. Resumindo: todo um processo de locação de veículos do
início ao fim.
#### ORDEM DE DEPENDÊNCIAS
Cadastramento de estoque; cadastramento de usuários; definição dos status dos veículos; inserção de
dados no BD; visualização de dados do BD.
#### PROTÓTIPO
As entradas serão dadas por formulários WEB, nos quais os gestores da empresa conseguirão
administrar estoque, caixa, clientes etc.; e que os clientes conseguiram realizar um cadastro e
informar o veículo que deve ser alugado.
O armazenamento se dará inicialmente por meio de MySQL, podendo sofrer alterações para algum
serviço de armazenamento in Cloud.
As saídas se darão em páginas WEB que receberam instruções das classes de controle e que
“imprimirá” os dados na tela.
#### TECNOLOGIAS A UTILIZAR
Serão utilizadas as funcionalidades de Java, as quais serão usadas para fazer as interações de
operação do usuário e controle de banco de dados. Além disso, elementos HTML, CSS e JavaScript
serão utilizados para fazer a parte WEB.
#### ARQUITETURA DO SISTEMA
O MVC do sistema será dividido em 2 camadas, uma de visão (o que será mostrado ao usuário) e uma
de controle + modelo (responsável para controlar e validar as operações/requisições do usuário e para
manipular os dados).
#### TEMPLATES
Utilizaremos uma paleta de cores que compõe principalmente as cores: verde (#009338) relacionado à
harmonia e equilíbrio, e amarelo(#f6e300), que remete leveza. Falando de formas, utilizaremos
predominantemente modais arredondados nas bordas. Algumas funcionalidades, como a tela de login,
se posicionaram no centro das janelas para melhor administração do espaço e melhor visibilidade do
cliente.
#### PLANEJAMENTO
Utilizaremos o modelo de programação Top-Down, o qual começaremos pelas partes de maiores
complexidades até o mais simples. Iremos iniciar pela interface (front-end) e após tê-la feita de forma
que seja possível enxergar as funcionalidades do sistema por ela, iremos implementar essas
funcionalidades a partir do back-end, de forma que elas estejam condizentes com a interface
representada.



![image](https://user-images.githubusercontent.com/82380592/198911067-c16e01c5-1891-4cc8-88c2-d3b48253f9dc.png)
