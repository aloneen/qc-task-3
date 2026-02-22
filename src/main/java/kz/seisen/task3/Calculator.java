package kz.seisen.task3;


public class Calculator {

    @CacheResult
    public String sum(String a, String b) {
        System.out.println("Method executed...");
        return a + " + " + b + " = " + (Integer.parseInt(a) + Integer.parseInt(b));
    }

    public String multiply(String a, String b) {
        System.out.println("Multiply executed...");
        return a + " * " + b + " = " + (Integer.parseInt(a) * Integer.parseInt(b));
    }
}