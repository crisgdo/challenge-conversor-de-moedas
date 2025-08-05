# Conversor de Moedas :currency_exchange:

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=openjdk&logoColor=white)

Um conversor de moedas para terminal, desenvolvido em Java, que utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/) para obter cotações em tempo real e salva um histórico de todas as operações. Este projeto foi um challenge oferecido pela Alura por meio do programa ONE (Oracle Next Education) desenvolvido com foco em boas práticas de programação orientada a objetos e separação de responsabilidades.

## Índice

* [Sobre o Projeto](#sobre-o-projeto)
* [Funcionalidades](#funcionalidades)
* [Demonstração](#demonstração)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Como Executar](#como-executar)
    * [Pré-requisitos](#pré-requisitos)
* [Estrutura do Projeto](#estrutura-do-projeto)

## Sobre o Projeto

Este projeto consiste em uma aplicação de console (CLI) que permite ao usuário realizar conversões entre diferentes pares de moedas. As taxas de câmbio são buscadas em tempo real, garantindo que os valores sejam sempre atuais.

Além da conversão, a aplicação gera um arquivo de log (`historicoConversões.txt`) que registra cada operação com data e hora, criando um histórico completo para consulta.

## Funcionalidades

-   :chart_with_upwards_trend: **Cotações em Tempo Real:** Conecta-se a uma API para buscar as taxas de câmbio mais recentes.
-   :computer: **Interface de Linha de Comando:** Menu interativo e fácil de usar diretamente no terminal.
-   :page_with_curl: **Histórico de Conversões:** Salva cada operação em um arquivo de texto para referência futura.
-   :bricks: **Arquitetura Limpa:** Desenvolvido com classes bem definidas e responsabilidades separadas para facilitar a manutenção e expansão.
-   :warning: **Tratamento de Erros:** Valida as entradas do usuário e trata possíveis falhas de conexão com a API.

## Demonstração

Abaixo, um exemplo de como a aplicação funciona no terminal.

Buscado taxas de câmbio...
Taxas atualizadas com sucesso!

**************************************************
Seja bem-vindo ao Conversor de Moedas
1. Dólar (USD) => Real (BRL)
2. Real (BRL) => Dólar (USD)
3. Euro (EUR) => Dólar (USD)
4. Dólar (USD) => Euro (EUR)
5. Peso argentino (ARS) => Dólar (USD)
6. Dólar (USD) => Peso argentino (ARS)
7. Sair
**************************************************
Digite uma opção: 1
Digite o valor que deseja converter: 1
--------------------------------------------------
O valor de 1,00 [USD] corresponde a 5,54 [BRL]
--------------------------------------------------
Após a operação, o arquivo `historicoConversões.txt` é atualizado:

```txt
04/08/2025 22:32 - O valor de 1,00 [USD] corresponde a 5,54 [BRL]
04/08/2025 22:33 - O valor de 30,00 [BRL] corresponde a 5,42 [USD]
04/08/2025 22:44 - O valor de 1,00 [USD] corresponde a 5,54 [BRL]
```

## Tecnologias Utilizadas

- ****Java (JDK 17+)****
- ****Gson:**** Biblioteca do Google para fazer o "parse" (análise) de JSON.
- ****ExchangeRate-API:**** API externa para obter dados de câmbio.
- ****Maven/Gradle:**** Gerenciador de dependências do projeto.

## Como Executar

Siga as instruções abaixo para obter uma cópia local do projeto e executá-la.

Pré-requisitos

- #### Java Development Kit (JDK) 17 ou superior.

- #### Maven ou Gradle instalado e configurado no seu sistema.

- #### Uma chave de API gratuita da ExchangeRate-API.

## Estrutura do Projeto

O código está organizado em classes com responsabilidades bem definidas para promover um baixo acoplamento e alta coesão.

- `AplicacaoPrincipal.java`: Classe principal que contém o método main. Responsável pela interface com o usuário e pela orquestração das outras classes.
- `ConsultaCambio.java`: Responsável por toda a comunicação com a API externa (requisição HTTP e tratamento da resposta).
- `TaxasDeCambio.java`: Objeto de Transferência de Dados (DTO) que modela e armazena os dados recebidos da API de forma estruturada.
- `ConversorDeMoeda.java`: Contém a lógica de negócio para realizar os cálculos de conversão.
- `GeradorDeArquivo.java`: Responsável por criar e escrever no arquivo de histórico de conversões.
