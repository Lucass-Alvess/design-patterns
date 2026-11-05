# Padrão de Projeto: Factory Method (Criacional)

Documentação conceitual, objetivos arquiteturais e critérios de decisão para o padrão criacional **Factory Method** (Método de Fábrica).

---

## 🎯 Problema que Resolve

1. **Acoplamento Direto a Classes Concretas:** Evita que o código cliente instancie implementações específicas diretamente usando `new`, reduzindo a rigidez do sistema.
2. **Violação do Princípio Aberto/Fechado (OCP):** Elimina cadeias extensas de condicionais (`if/else` ou `switch/case`) espalhadas pelo código para determinar qual classe instanciar.
3. **Delegação da Decisão de Criação:** Estabelece um contrato abstrato para a criação de um produto, transferindo para as subclasses concretas a responsabilidade de decidir qual implementação instanciar.

---

## 📐 Diagrama Arquitetural

```text
       «interface»
         Produto
    +-----------------+
    | + operacao()    |
    +-----------------+
        ▲         ▲
        |         |  implementam
   +----+         +----+
   |                   |
ProdutoConcretoA    ProdutoConcretoB
   ▲                   ▲
   : cria              : cria
   :                   :
   |                   |
CreatorConcretoA    CreatorConcretoB
   |                   |
   +----+         +----+
        |         |  herdam de
        ▲         ▲
    +--------------------------------+
    |       «abstract class»         |
    |            Creator             |
    +--------------------------------+
    | # factoryMethod() : Produto    |  <-- Método de Fábrica (abstrato)
    | + executarRegraDeNegocio()     |  <-- Utiliza o produto criado
    +--------------------------------+
```

---

## ⚙️ Componentes Estruturais

* **Produto (`Product`):** Interface ou classe abstrata comum que define o contrato de comportamento para os objetos criados pelo padrão.
* **Produtos Concretos (`Concrete Products`):** Implementações específicas do contrato do produto.
* **Criador (`Creator`):** Classe abstrata que declara o método abstrato `factoryMethod()`. Geralmente contém regras de negócio centrais que dependem do produto abstrato, delegando apenas o instanciamento às filhas.
* **Criadores Concretos (`Concrete Creators`):** Subclasses que sobrescrevem o `factoryMethod()` para instanciar e retornar um produto concreto específico.

---

## ⚖️ Relação com os Princípios SOLID

* **Single Responsibility Principle (SRP):** Centraliza a lógica de instanciação em classes dedicadas (fábricas), mantendo a lógica de negócio separada da montagem de objetos.
* **Open/Closed Principle (OCP):** Permite adicionar novas variações de produtos e fábricas ao sistema sem alterar o código dos clientes ou dos criadores abstratos existentes.
* **Dependency Inversion Principle (DIP):** O código cliente depende de abstrações (`Produto` e `Creator`), nunca de implementações concretas (`ProdutoConcretoA`).

---

## 🔍 Factory Method vs. Outras Abordagens de Fábrica

| Característica | Static Factory Method | Simple Factory | Factory Method (GoF) | Abstract Factory (GoF) |
| :--- | :--- | :--- | :--- | :--- |
| **Mecanismo Central** | Método estático em uma classe | Classe utilitária com lógica condicional | Herança e polimorfismo via subclasses | Composição de interfaces |
| **Escalabilidade** | Baixa (método fixo na classe) | Média (exige alterar o switch a cada novo tipo) | Alta (basta criar nova subclasse criadora) | Alta (cria famílias inteiras de produtos) |
| **Quantidade de Produtos** | Único objeto | Único produto por chamada | Único produto por hierarquia de criador | Múltiplos produtos relacionados |

---

## ⚖️ Critérios de Decisão Técnica

| Cenário | Usar Factory Method? | Justificativa |
| :--- | :---: | :--- |
| O cliente não sabe com antecedência quais tipos exatos de objetos precisa criar | **Sim** | O desacoplamento permite plugar novos tipos em tempo de execução. |
| O processo de criação de um objeto exige apenas um ou dois atributos simples | **Não** | Pode gerar complexidade acidental desnecessária (overengineering). |
| Você deseja estender frameworks ou bibliotecas internas | **Sim** | Usuários da biblioteca podem estender o `Creator` e injetar seus próprios componentes. |
| Necessidade de criar famílias de objetos complementares | **Não** | O padrão indicado para conjuntos de produtos interligados é o **Abstract Factory**. |