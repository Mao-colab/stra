package org.example;

// Фабрика для смартфона среднего уровня
class MidRangeSmartphoneFactory extends SmartphoneFactory {
    @Override
    public Smartphone createSmartphone() {
        return new MidRangeSmartphone();
    }
}