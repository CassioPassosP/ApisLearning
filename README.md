# SiteFilmes

Projeto de estudos em Java sobre consumo de APIs REST, desserializacao de JSON com Gson e persistencia de dados em arquivos JSON.

## Funcionalidades

- Busca filmes pelo nome na [OMDb API](https://www.omdbapi.com/).
- Converte a resposta da OMDb em objetos Java (`Titulo` e `TituloOmdb`).
- Mantem os filmes consultados em memoria e salva a lista em `filmes.json`.
- Consulta enderecos pelo CEP usando a [ViaCEP](https://viacep.com.br/).
- Salva o endereco consultado em um arquivo JSON com o numero do CEP no nome.

## Tecnologias

- Java 17 ou superior
- Java HTTP Client (`java.net.http`)
- Gson 2.13.2
- IntelliJ IDEA

## Como executar

### IntelliJ IDEA

1. Clone este repositorio e abra a pasta no IntelliJ IDEA.
2. Configure um JDK 17 ou superior para o projeto.
3. Adicione o arquivo `gson-2.13.2.jar` como uma dependencia do modulo. O arquivo `primeiroProjeto.iml` ja aponta para essa biblioteca em `../../../../../../JAR/gson-2.13.2.jar`; ajuste o caminho caso o JAR esteja em outro local.
4. Execute uma das classes abaixo pela opcao **Run** do IntelliJ.

### Busca de filmes

Execute `PrincipalComBusca`. Digite o nome de um filme no terminal e use `sair` para encerrar.

> A chave da OMDb esta definida na variavel `chave` dentro de `PrincipalComBusca`. Para usar outra chave, substitua o valor diretamente no codigo antes de executar. Evite versionar chaves reais em repositorios publicos.

### Consulta de CEP

Execute `cep.Principal`. O exemplo consulta o CEP `94198040`, imprime o endereco e gera o arquivo `94198040.json`.

Para consultar outro CEP, altere o valor passado para `buscaEndereco` em `src/cep/Principal.java`.

## Estrutura principal

```text
src/
|-- PrincipalComBusca.java       # Busca filmes na OMDb
|-- Titulo.java                  # Modelo convertido para o projeto
|-- TituloOmdb.java              # Modelo da resposta da OMDb
|-- ErroDeConversaoDeAnoException.java
|-- cep/
|   |-- ConsultaCep.java         # Cliente da ViaCEP
|   |-- Endereco.java            # Modelo do endereco
|   |-- GeradorDeArquivo.java    # Escrita do endereco em JSON
|   `-- Principal.java           # Exemplo executavel de consulta de CEP
`-- a2025/                       # Exercicios complementares de Java
```

## Arquivos gerados

- `filmes.json`: lista de filmes consultados pela aplicacao principal.
- `<cep>.json`: endereco retornado pela ViaCEP.

Esses arquivos sao exemplos de saida e podem ser recriados ao executar os programas.

## APIs utilizadas

- [OMDb API](https://www.omdbapi.com/): informacoes de filmes e series. Requer uma chave de API.
- [ViaCEP](https://viacep.com.br/): consulta de enderecos por CEP. Nao requer chave para este uso.

## Objetivo do projeto

Praticar requisicoes HTTP, leitura e conversao de respostas JSON, tratamento de excecoes e geracao de arquivos durante os estudos de Java.