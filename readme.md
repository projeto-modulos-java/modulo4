### Modulo 4

Esse modulo tem 4 apis, sendo 3 delas consumidoras de mensagens de topicos do kafka e uma delas a produtora, a api que gerara os eventos a serem processados.

# api

Esse projeto é uma api REST que deve ser usada para gerar os eventos de criacao e exclusao dos pedidos e produtos. Ela será responsavel por exibir essas entidades e por realizar seu cadastro e exclusao. Um pedido representa uma compra de um cliente de determinado produto cadastrado, em que é possivel selecionar a quantidade de produtos comprado e o controle de quantos produtos ainda estao em estoque.

# pedido

Aplicacao responsavel por consumir os eventos de cadastro de pedido e processa-los. Ele cadastra cada pedido no banco de dados e diminui a quantidade de produtos em estoque dos produtos que foram comprados no pedido.

# fornecimento

Responsavel pelo gerenciamento dos produtos e suas quantidades em estoque. Quando um produto é excluido, todos os pedidos relacionados a ele sao cancelados.

# Cancelamento

Aplicacao responsavel por executar o cancelamento de um pedido, restaurando o numero de produtos em estoque.

# Explicacao

Em todos os projetos foi utilizada uma arquitetura em camadas, sendo elas: entidades, use cases (servicos), camada de adaptadores (controllers e repositories) e a camada de interface e drivers. Foram utilizados adaptadores entre todas as camadas da arquitetura para que o sistema tivesse menor acoplamento. Foi utilizado o banco de dados MySQL junto com o agregador de logs Graylog para todas as aplicacoes.