INSERT INTO CLIENTE(nome, email, senha) VALUES('Igor', 'ig@email.com', '123456');
INSERT INTO CLIENTE(nome, email, senha) VALUES('Jessica', 'jg@email.com', '123');

INSERT INTO CATEGORIA(nome, categoria) VALUES('Roupas', 'Bermuda');
INSERT INTO CATEGORIA(nome, categoria) VALUES('Calçados', 'Chinelo');

INSERT INTO PEDIDO(titulo, descricao, data_criacao, status, cliente_id, categoria_id) VALUES('PromocaoRoupa', 'Blusa', '2021-08-05 18:00:00', 'RECEBIDO', 1, 1);
INSERT INTO PEDIDO(titulo, descricao, data_criacao, status, cliente_id, categoria_id) VALUES('PromocaoCalçado', 'Tenis', '2021-03-05 19:00:00', 'RECEBIDO', 1, 1);
INSERT INTO PEDIDO(titulo, descricao, data_criacao, status, cliente_id, categoria_id) VALUES('PromocaoToalha', 'Banhao', '2021-01-05 20:00:00', 'RECEBIDO', 1, 2);



