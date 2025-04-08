package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            // Вызов фабричного метода для создания смартфонов
            produceSmartphone(new BudgetSmartphoneFactory());
            produceSmartphone(new MidRangeSmartphoneFactory());
            produceSmartphone(new FlagshipSmartphoneFactory());
        }

        // Фабричный метод для создания смартфонов
        public static void produceSmartphone(SmartphoneFactory factory) {
            Smartphone smartphone = factory.createSmartphone();
            System.out.println(smartphone.getSpecifications());
        }
    }