package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean check(String given) {

        StringBuilder stringBuilder = new StringBuilder(given);

        String reversed = stringBuilder.reverse().toString();
        return given.equalsIgnoreCase(reversed);
    }
}




