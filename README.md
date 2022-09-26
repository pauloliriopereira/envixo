Para executar o projeto é necessário que o banco de dados postgresql esteja rodando e para isso usaremos o arquivo docker-compose.yml que se encontra dentro deste projeto.

Comando para executar o banco de dados:
- docker-compose up -d

Obs.: criar database com nome envixo

Comando:
- create database envixo;

Em seguida executaremos atravês a aplicação na linha de comando com o maven.

Comando para executar a aplicação:
- mvn clean install spring-boot:run

Para inserir dados para teste deve-se utilizar a ferramenta postman e importar os casos de teste.

Consireções importantes:

- Como informado na documentação do teste os registros de categoria devem ser cadastrados antes de se cadastrar os produtos.
- Os arquivos de fotos estão sendos salvos /tmp.
- O path configurado para o volume do docker-compose deve ser alterado antes de executar o comando.