# Padrão de Projeto: Prototype (Criacional)

Documentação conceitual, objetivos arquiteturais e critérios de decisão para o padrão criacional **Prototype**.

## 🎯 Problema que Resolve

1. **Custo Computacional Alto de Instanciação:** Evita a repetição de operações caras (leitura de arquivos, chamadas de rede, consultas a banco de dados ou cálculos complexos) ao duplicar um objeto já carregado em memória.

2. **Desacoplamento de Classes Concretas:** Permite clonar objetos sem que o cliente precise conhecer sua classe concreta ou seus detalhes internos de construção.

3. **Alternativa à Explosão de Subclasses:** Reduz a necessidade de criar subclasses apenas para representar configurações fixas ou variações previsíveis de um mesmo objeto.

## 🔬 Shallow Copy vs. Deep Copy

A integridade do padrão Prototype depende diretamente da estratégia de clonagem adotada:

| Tipo de Cópia | Tipos Primitivos / Wrappers / Imutáveis | Objetos e Coleções Referenciados | Risco Arquitetural |
| :--- | :--- | :--- | :--- |
| **Shallow Copy (Rasa)** | Copia o valor direto | Copia apenas o **ponteiro/endereço** de memória | **Alto:** Alterar uma coleção no clone corrompe os dados do objeto original. |
| **Deep Copy (Profunda)** | Copia o valor direto | **Instancia novas coleções/objetos** com os mesmos dados | **Nenhum:** O clone e o original tornam-se 100% isolados e independentes. |

> **Nota sobre Java:** A interface nativa `Cloneable` e o método `Object.clone()` implementam por padrão *Shallow Copy* e violam convenções de construtores, sendo desaconselhados na prática profissional (*Effective Java*, Item 13). A recomendação padrão na indústria é o uso de **Construtores de Cópia** (*Copy Constructors*) ou métodos de clonagem explícitos.

## 📐 Diagrama Conceitual

```
+-------------------------------------------------------+
|                    Prototype<T>                       |
|                     (Interface)                       |
+-------------------------------------------------------+
| + clonar() : T                                        |
+-------------------------------------------------------+
                           ^
                           | implementa
+--------------------------+----------------------------+
|                   ClasseConcreta                      |
+-------------------------------------------------------+
| - atributoPrimitivo : Tipo                            |
| - colecaoReferenciada : List<Tipo>                    |
+-------------------------------------------------------+
| + ClasseConcreta(...)                                 |
| + ClasseConcreta(outro : ClasseConcreta)  [Copy Ctor] |
| + clonar() : ClasseConcreta                           |
+-------------------------------------------------------+
```

## ⚙️ Mecânica do Padrão

* **Construtor de Cópia (*Copy Constructor*):** Um construtor dedicado que recebe uma instância existente da própria classe e realiza a duplicata profunda de cada atributo mutável (`new ArrayList<>(outro.lista)`).
* **Método de Clonagem Polimórfico:** Um método público (ex: `clonar()`) que expõe a capacidade de cópia de forma limpa, invocando internamente o construtor de cópia.
* **Prototype Registry (Opcional):** Um repositório em memória (comumente `Map<String, Prototype>`) que armazena protótipos pré-configurados para serem solicitados sob demanda pelo sistema.

## ⚖️ Critérios de Decisão Técnica

| Critério | Instanciação Tradicional (`new`) | Prototype |
| :--- | :--- | :--- |
| **Custo de Inicialização** | Alto a cada invocação | Baixo após o primeiro objeto |
| **Cenário Ideal** | Criação a partir de dados brutos e variáveis | Criação a partir de configurações pré-existentes |
| **Ponto de Atenção** | Código verboso de montagem | Risco de vazamento de estado se a cópia for *shallow* |