package creational.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Teste Bill Pugh ===");
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Mesma instância? " + (bp1 == bp2)); // true

        System.out.println("\n=== 2. Teste Double-Checked Locking ===");
        DoubleCheckedLockingSingleton dcl1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton dcl2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("Mesma instância? " + (dcl1 == dcl2)); // true

        System.out.println("\n=== 3. Teste Enum Singleton ===");
        EnumSingleton e1 = EnumSingleton.INSTANCE;
        EnumSingleton e2 = EnumSingleton.INSTANCE;
        e1.setConfigurationValue("Ambiente: Produção");
        System.out.println("Mesma instância? " + (e1 == e2)); // true
        System.out.println("Valor lido pela referência 2: " + e2.getConfigurationValue());
    }
}

