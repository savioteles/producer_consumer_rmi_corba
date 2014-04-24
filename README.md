producer_consumer_rmi
=====================

# Problema do Produtor e Consumidor usando Rmi: Estudo de caso no McDonald's

Problema do produtor e consumidor utilizando Rmi em um case no McDonald's. Existem três buffers compartilhados pelos produtores e consumidores. 
Cada buffer (com tamanho igual a 10) representa uma estufa de um sanduíche do McDonald's: BigMac, McChicken e McFish.
São simulados vários produtores e consumidores gerando, de forma randomica, requisições ao servidor Rmi por produção/consumo de sanduíches.

A simulação deste ambiente no McDonald's é iniciada com clique do botão "Iniciar". São apresentadas as três estufas de sanduíches, com dez quadrados que apresentam imagens dos sanduíches que estão na estufa e, consequentemente, no buffer. Além disso, existem dois campos de texto: a) Consumidores esperando: número de consumidores que está esperando pela produção daquele sanduíche, ou seja, o buffer está vazio e tem consumidores querendo retirar objetos deste buffer; b) Sanduíches na chapa: número de sanduíches que estão esperando para serem colocados na estufa, ou seja, o buffer está cheio e tem produtores querendo inserir objetos neste buffer.

Na aplicação existe um menu "File" no canto superior esquerdo com a opção "Exit" para terminar a execução da aplicação.

# Inicializando a aplicação

Para iniciar a aplicação basta realizar o download do jar "producer_consumer.jar" e executar o seguinte comando:

java -jar producer_consumer.jar 
