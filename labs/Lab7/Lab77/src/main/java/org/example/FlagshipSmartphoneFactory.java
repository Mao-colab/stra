package org.example;

// Фабрика для флагманского смартфона
class FlagshipSmartphoneFactory extends SmartphoneFactory {
    @Override
    public Smartphone createSmartphone() {
        return new FlagshipSmartphone();
    }
}