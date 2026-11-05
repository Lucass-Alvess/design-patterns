# Padrão de Projeto: Abstract Factory (Criacional)

Documentação conceitual, objetivos arquiteturais e critérios de decisão para o padrão criacional **Abstract Factory** (Fábrica Abstrata).

---

## 🎯 Problema que Resolve

1. **Incompatibilidade em Famílias de Produtos:** Impede a mistura acidental de componentes de variantes ou ecossistemas distintos (ex.: instanciar um botão de Windows em uma janela de macOS, ou misturar componentes de Tema Claro com Tema Escuro).
2. **Acoplamento a Múltiplas Implementações Concretas:** Desacopla o código cliente de todas as classes concretas que compõem uma suíte de produtos interligados.
3. **Complexidade de Troca de Ecossistema:** Permite alternar plataformas, temas ou provedores de infraestrutura inteiros trocando apenas a instância da fábrica injetada no início da aplicação.

---

## 📐 Diagrama Arquitetural

```
                      «interface»
                    AbstractFactory
       +---------------------------------------+
       | + criarProdutoA() : ProdutoA          |
       | + criarProdutoB() : ProdutoB          |
       +---------------------------------------+
                           ▲
          +----------------+----------------+
          |                                 |
FábricaConcreta1                  FábricaConcreta2
+-----------------------+         +-----------------------+
| + criarProdutoA()     |         | + criarProdutoA()     |
|   -> ProdutoA1        |         |   -> ProdutoA2        |
| + criarProdutoB()     |         | + criarProdutoB()     |
|   -> ProdutoB1        |         |   -> ProdutoB2        |
+-----------------------+         +-----------------------+

=============================================================

       «interface»                       «interface»
        ProdutoA                          ProdutoB
   +-----------------+               +-----------------+
   | + metodoA()     |               | + metodoB()     |
   +-----------------+               +-----------------+
       ▲         ▲                       ▲         ▲
       |         |                       |         |
   ProdutoA1  ProdutoA2              ProdutoB1  ProdutoB2
   (Família1) (Família2)             (Família1) (Família2)
```

---

## ⚙️ Componentes Estruturais

* **Abstract Factory (`AbstractFactory`):** Interface que declara uma lista de métodos de criação, um para cada produto abstrato pertencente à família de componentes.
* **Fábricas Concretas (`ConcreteFactories`):** Classes que implementam a interface da fábrica abstrata. Cada fábrica concreta cria exclusivamente produtos de uma variante/família específica (garantindo compatibilidade).
* **Produtos Abstratos (`AbstractProducts`):** Conjunto de interfaces que definem as operações para cada tipo distinto de produto na família (ex.: `Botao`, `Janela`, `BarraDeRolagem`).
* **Produtos Concretos (`ConcreteProducts`):** Implementações específicas organizadas por famílias (ex.: `BotaoClaro`/`JanelaClara` vs. `BotaoEscuro`/`JanelaEscura`).
* **Cliente (`Client`):** Consome apenas as interfaces dos produtos e da fábrica abstrata, sem conhecer as implementações concretas em uso.

---

## ⚖️ Relação com os Princípios SOLID

* **Single Responsibility Principle (SRP):** Centraliza o conhecimento sobre como montar uma família inteira de componentes compatíveis em classes dedicadas.
* **Open/Closed Principle (OCP):** Introduzir uma nova família de produtos (ex.: Tema Alto Contraste) exige apenas criar uma nova fábrica concreta e suas classes de produto correspondentes, sem alterar o código dos clientes ou das famílias já existentes.
* **Dependency Inversion Principle (DIP):** O código cliente depende exclusivamente de abstrações (`AbstractFactory`, `ProdutoA`, `ProdutoB`), desacoplando a camada de aplicação de qualquer detalhe de implementação.

---

## 🔍 Factory Method vs. Abstract Factory

| Característica | Factory Method | Abstract Factory |
| :--- | :--- | :--- |
| **Mecanismo Central** | Herança e polimorfismo via subclasses | Composição de interfaces |
| **Escopo de Criação** | **Um único** produto por hierarquia de criador | **Uma família** de múltiplos produtos interligados |
| **Relação entre Produtos** | Produtos não possuem dependência mútua | Produtos devem ser rigorosamente compatíveis entre si |
| **Complexidade** | Média | Alta (exige interfaces para fábrica e para cada produto) |
| **Como Adicionar Produtos** | Cria-se uma nova subclasse criadora | Exige alterar a interface da fábrica base (quebra a interface existente) |

---

## ⚖️ Critérios de Decisão Técnica

| Cenário | Usar Abstract Factory? | Justificativa |
| :--- | :---: | :--- |
| O sistema precisa ser configurado com uma família inteira de produtos compatíveis | **Sim** | Garante que objetos de ecossistemas diferentes não sejam misturados por engano. |
| O sistema precisa criar apenas variações isoladas de um único objeto | **Não** | O **Factory Method** ou **Builder** resolvem com menor sobrecarga de código. |
| A aplicação suporta múltiplos temas de interface (UI) ou múltiplos provedores de nuvem (AWS/Azure/GCP) | **Sim** | Facilita a substituição completa de todos os drivers/componentes com uma única injeção. |
| A família de produtos muda de estrutura com alta frequência (novos métodos na fábrica) | **Não** | Adicionar um novo tipo de produto exige modificar a interface base e todas as fábricas concretas implementadas. |