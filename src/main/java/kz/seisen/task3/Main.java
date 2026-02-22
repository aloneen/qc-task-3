package kz.seisen.task3;

public class Main {

    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        CacheInvoker invoker = new CacheInvoker();

        // sum с аннотацией
        System.out.println(invoker.invoke(calculator, "sum", "2", "3"));
        System.out.println(invoker.invoke(calculator, "sum", "2", "3"));

        System.out.println("---");

        // multiply без аннотации
        System.out.println(invoker.invoke(calculator, "multiply", "2", "3"));
        System.out.println(invoker.invoke(calculator, "multiply", "2", "3"));
    }
}
