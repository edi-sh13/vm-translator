package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            VMTranslator translator = new VMTranslator(args[0]);
            translator.run();
            System.out.println("Translation completed successfully.");
        } catch (Exception e) {
            System.out.println("Translation failed: " + e.getMessage());
        }
    }
}
