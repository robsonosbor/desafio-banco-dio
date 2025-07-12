# Desafio Banco Digital com Java e Orientação a Objetos

Este projeto é a resolução do desafio proposto no Bootcamp: Santander 2025 - Back-End com Java realizado pela  Digital Innovation One (DIO) para a criação de um sistema bancário simples utilizando os conceitos fundamentais de Orientação a Objetos (POO) em Java.

## Índice
* [Descrição do Projeto](#descrição-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Conceitos de POO Aplicados](#conceitos-de-poo-aplicados)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Como Executar](#como-executar)
* [Autor](#autor)

## Descrição do Projeto

O desafio consiste em abstrair e implementar um sistema bancário básico em Java. Este sistema permite a criação de diferentes tipos de contas (corrente e poupança) e a realização de operações bancárias essenciais como depósito, saque e transferência entre contas da própria instituição. O foco principal é a aplicação prática de Abstração, Encapsulamento, Herança e Polimorfismo.

## Funcionalidades

* Criação de Clientes
* Criação de Contas Correntes
* Criação de Contas Poupança
* Operação de Depósito
* Operação de Saque (com validação de saldo)
* Operação de Transferência entre contas (com validação de saldo)
* Emissão de Extrato para cada tipo de conta
* Gerenciamento de Clientes e Contas dentro da classe `Banco`

## Conceitos de POO Aplicados

Este projeto foi desenvolvido com forte adesão aos quatro pilares da Orientação a Objetos:

1.  **Abstração**:
    * `Cliente`: Abstrai as informações básicas de um cliente.
    * `IConta`: Define a interface para as operações comuns de qualquer conta (sacar, depositar, transferir, imprimirExtrato).
    * `Conta` (Classe Abstrata): Abstrai as características e comportamentos comuns a todas as contas bancárias (agência, número, saldo, cliente), definindo um contrato através da interface `IConta`.
    * `ContaCorrente` e `ContaPoupanca`: Abstraem os tipos específicos de conta.
    * `Banco`: Abstrai a instituição bancária que gerencia clientes e contas.

2.  **Encapsulamento**:
    * Todos os atributos das classes (`Cliente`, `Conta`, `Banco`) são privados (`private` ou `protected`) e o acesso e modificação são controlados por métodos `get` e `set` públicos.
    * A lista de contas e clientes dentro da classe `Banco` é gerenciada internamente e exposta apenas através de uma `Collections.unmodifiableList()`, prevenindo modificações externas diretas e garantindo a integridade dos dados.

3.  **Herança**:
    * `ContaCorrente` e `ContaPoupanca` herdam da classe abstrata `Conta`, reutilizando a lógica e os atributos comuns, como `saldo`, `agencia`, `numero`, e os métodos de `sacar`, `depositar` e `transferir`.

4.  **Polimorfismo**:
    * A interface `IConta` permite que objetos de `ContaCorrente` e `ContaPoupanca` sejam tratados de forma genérica como `IConta` ou `Conta`.
    * O método `imprimirExtrato()` é um exemplo claro de polimorfismo, sendo sobrescrito (`@Override`) em `ContaCorrente` e `ContaPoupanca` para fornecer uma implementação específica para cada tipo de conta.
    * O método `transferir` em `Conta` aceita um `IConta` como destino, permitindo transferências para qualquer tipo de conta que implemente a interface.

## Estrutura do Projeto
```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Banco.java
│   │   │   ├── Cliente.java
│   │   │   ├── Conta.java
│   │   │   ├── ContaCorrente.java
│   │   │   ├── ContaPoupanca.java
│   │   │   ├── IConta.java
│   │   │   └── Main.java
└── README.md
```

## Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/robsonosbor/desafio-banco-dio.git](https://github.com/robsonosbor/desafio-banco-dio.git)
    ```
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd desafio-banco-dio
    ```
3.  **Compile os arquivos Java:**
    ```bash
    javac src/main/java/*.java
    ```
4.  **Execute a classe principal:**
    ```bash
    java src/main/java/Main.java
    ```

---
Feito com ❤️ por Robson Osbor para o Desafio DIO.
