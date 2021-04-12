Jessica-API

Introduction
Documentação para utilização da Doc Api – Jessica-Pedidos.

Overview
Api desenvolvida Rest Usando Spring boot

Authentication
Não é preciso utilizar autenticação para fazer requisições a esta API.

Error Codes
400 – Bad Request

Dados enviados de forma incorreta ou fora do padrão

403 – Forbidden

Sem autorização suficiente para acessar o recurso desejado

Pedidos

Está pasta representa um objeto do tipo Pedidos na Doc Jessica - API

GET Listar Pedidos
http://localhost:8080/pedidos


Example Request
Listar Pedidos
curl --location --request GET 'http://localhost:8080/pedidos'
GET ListarPaginado
http://localhost:8080/pedidos?pagina=0&qtd=1
PARAMS
pagina0
qtd1

Example Request
ListarPaginado
curl --location --request GET 'http://localhost:8080/pedidos?pagina=0&qtd=1'
POST CadastrarPedido
http://localhost:8080/pedidos
HEADERS
Content-Typeapplication/json
BODY raw
{"titulo" : "Pedido de sapatos",
"descricao": "sapatenis",
"nomeCategoria" : "Calçados"
}


Example Request
CadastrarPedido
curl --location --request POST 'http://localhost:8080/pedidos' \
--header 'Content-Type: application/json' \
--data-raw '{"titulo" : "Pedido de sapatos",
"descricao": "sapatenis",
"nomeCategoria" : "Calçados"
}'
GET DetalharPedido
http://localhost:8080/pedidos/2


Example Request
DetalharPedido
curl --location --request GET 'http://localhost:8080/pedidos/2'
DEL DeletarPedido
http://localhost:8080/pedidos/2

