package org.example;

// Фабрика для бюджетного смартфона
class BudgetSmartphoneFactory extends SmartphoneFactory {
    @Override
    public Smartphone createSmartphone() {
        return new BudgetSmartphone();
    }
}