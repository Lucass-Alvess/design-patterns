# Padrão de Projeto: Builder (Static Inner Class)

Documentação conceitual, objetivos arquiteturais e critérios de decisão para o padrão criacional **Builder** utilizando classe estática interna.

## 🎯 Problema que Resolve

1. **Telescoping Constructor:** Elimina construtores com múltiplos parâmetros onde argumentos opcionais obrigam a passagem de valores nulos (`null`).

2. **Inconsistência de Estado:** Substitui o uso disperso de *setters*, impedindo que a entidade exista em um estado intermediário ou incompleto durante sua instanciação.

3. **Imutabilidade Real:** Permite a definição de atributos restritos como `final` sem abrir mão de flexibilidade na configuração de campos opcionais.

## 📐 Diagrama Conceitual

```
+-------------------------------------------------------+
|                       Entidade                        |
+-------------------------------------------------------+
| - campoObrigatorio : Tipo   (final)                   |
| - campoOpcional : Tipo      (final)                   |
+-------------------------------------------------------+
| - Entidade(builder : Builder)                         |
| + getters...                                          |
+-------------------------------------------------------+
                           ^
                           | instancia via construtor privado
+--------------------------+----------------------------+
|                   Entidade.Builder                    |
+-------------------------------------------------------+
| - campoObrigatorio : Tipo                             |
| - campoOpcional : Tipo                                |
+-------------------------------------------------------+
| + Builder(campoObrigatorio: Tipo)                     |
| + comOpcional(valor: Tipo) : Builder   [return this]  |
| + build() : Entidade                                  |
+-------------------------------------------------------+

```

## ⚙️ Mecânica do Padrão

* **Construtor Privado na Classe Principal:** Impede a instanciação externa sem a mediação do Builder.

* **Interface Fluente (*Fluent API*):** Métodos de atribuição no Builder retornam a própria referência (`return this`), permitindo encadeamento limpo de chamadas.

* **Ponto Único de Validação:** Regras de consistência e invariantes são validadas de forma centralizada dentro da chamada `build()` antes da criação efetiva do objeto.

* **Isolamento de Bytecode:** Por ser uma *static inner class*, o compilador gera uma classe aninhada (`Entidade$Builder.class`) sem poluir a árvore de arquivos de código-fonte.

## ⚖️ Critérios de Decisão Técnica

| Critério | Construtor Tradicional | Getters / Setters (JavaBeans) | Builder (Static Inner Class) | 
| ----- | ----- | ----- | ----- | 
| **Imutabilidade** | Sim (com campos `final`) | Não (mutabilidade aberta) | **Sim (totalmente imutável)** | 
| **Legibilidade** | Baixa em objetos complexos | Média | **Alta e autoexplicativa** | 
| **Validação de Invariantes** | No construtor | Difícil de garantir | **Centralizada no método `.build()`** | 
| **Tolerância a Opcionais** | Baixa (múltiplos construtores) | Alta | **Alta (sem sobrecarga de construtores)** | 
