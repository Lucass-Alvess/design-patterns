package creational.singleton;

public class DoubleCheckedLockingSingleton {

    // 1. O modificador 'volatile' garante que mudanças feitas por uma thread
    // fiquem imediatamente visíveis para as outras e impede reordenação de instruções pela JVM.
    private static volatile DoubleCheckedLockingSingleton instance;

    // 2. Construtor privado
    private DoubleCheckedLockingSingleton() {
        System.out.println("Inicializando DoubleCheckedLockingSingleton...");
    }

    // 3. Ponto de acesso com dupla checagem
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // 1ª verificação: sem lock (rápida para quando já existe a instância)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // 2ª verificação: com lock (garante que apenas uma thread crie)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void executeOperation(String message) {
        System.out.println("DoubleCheckedLocking executando: " + message);
    }
}

