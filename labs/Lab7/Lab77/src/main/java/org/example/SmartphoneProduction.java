package org.example;

// Тестирование фабрики смартфонов
public class SmartphoneProduction {
    public static void main(String[] args) {
        // Создаём фабрику для бюджетных смартфонов
        SmartphoneFactory budgetFactory = new BudgetSmartphoneFactory();
        Smartphone budgetPhone = budgetFactory.createSmartphone();
        System.out.println(budgetPhone.getSpecifications());

        // Создаём фабрику для смартфонов среднего уровня
        SmartphoneFactory midRangeFactory = new MidRangeSmartphoneFactory();
        Smartphone midRangePhone = midRangeFactory.createSmartphone();
        System.out.println(midRangePhone.getSpecifications());

        // Создаём фабрику для флагманских смартфонов
        SmartphoneFactory flagshipFactory = new FlagshipSmartphoneFactory();
        Smartphone flagshipPhone = flagshipFactory.createSmartphone();
        System.out.println(flagshipPhone.getSpecifications());
    }
}