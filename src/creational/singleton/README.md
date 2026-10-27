# Padrão Criacional: Singleton

## 📌 Propósito
Garantir que uma classe tenha apenas **uma única instância** em toda a aplicação e fornecer um **ponto global de acesso** a ela.

---

## 🎯 Problema que Resolve
Quando um recurso deve ser compartilhado de forma centralizada e controlada, evitando instâncias duplicadas que causariam conflito ou desperdício de memória:
- Pool de conexões com banco de dados.
- Gerenciador de configurações de ambiente (`ConfigManager`).
- Cache em memória da aplicação.
- Logs e rastreamento centralizado.

---

## 🛠️ Implementações no Código

### 1. Bill Pugh Singleton (Holder Estático) — *Recomendada para POO*
- **Arquivo:** `BillPughSingleton.java`
- **Vantagem:** É *Lazy* (só instancia quando chamado) e *Thread-Safe* de forma transparente, utilizando o mecanismo nativo de carregamento de classes da JVM sem precisar de locks (`synchronized`).

### 2. Double-Checked Locking
- **Arquivo:** `DoubleCheckedLockingSingleton.java`
- **Uso:** Utiliza `volatile` e bloco `synchronized`. Garante segurança em ambientes concorrentes (multithread) sem travar a chamada após a instância já ter sido inicializada.

### 3. Enum Singleton
- **Arquivo:** `EnumSingleton.java`
- **Recomendação:** Indicado por Joshua Bloch (*Effective Java*). É a forma mais segura contra ataques de Reflection e problemas de Desserialização em Java puro.

---

## ⚖️ Vantagens vs. Desvantagens

| Vantagens | Desvantagens |
| :--- | :--- |
| Acesso global controlado a uma instância única. | Viola o **SRP** (*Single Responsibility Principle*): faz a regra de negócio e controla seu próprio ciclo de vida. |
| Economia de recursos caros (Lazy Loading). | Dificulta testes unitários (acoplamento estático / difícil de mockar). |
| Evita conflitos de concorrência em recursos compartilhados. | Pode mascarar dependências no código se chamado diretamente no meio de métodos. |

---

## 💡 Singleton Clássico (GoF) vs. Spring Boot

No desenvolvimento corporativo com **Spring Boot**, raramente implementamos o Singleton clássico (com construtor privado e `getInstance()`).

- **Singleton GoF:** Instância única por `ClassLoader` da JVM (gerenciada via código manual).
- **Singleton no Spring:** Escopo padrão de um Bean (`@Component`, `@Service`, `@Repository`). O Spring gerencia a instância única dentro do contêiner IoC (*ApplicationContext*) e a injeta via construtor, mantendo o código desacoplado e fácil de testar.