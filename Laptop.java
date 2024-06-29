// Ноутбуки для магазина техники.

// Поля:
// Производитель (Manufacturer)
// ОЗУ (RAM)
// Объем ЖД (HDD)
// Операционная система (Operating system)
// Цвет (Color)
// Год выпуска (Year)

// Методы:
// Геттеры: getManufacturer(), getRAM(), getHDD() ...
// Сеттеры: setManufacturer(), setRAM(), setHDD() ...

// package Task4;

import java.util.Objects;


// enum OperatingSystem {
//     WINDOWS_10, WINDOWS_11, WINDOWS_12, LINUX, MACOS
// }

// enum Color {
//     BLACK, WHITE, RED, GRAY
// }

// enum RAMSize {
//     _4GB(4), _8GB(8), _12GB(12), _16GB(16), _32GB(32), _64GB(64);

//     private final int size;

//     RAMSize(int size) {
//         this.size = size;
//     }

//     public int getSize() {
//         return size;
//     }
// }

// enum HDDSize {
//     _256GB(256), _512GB(512), _1024GB(1024);

//     private final int size;

//     HDDSize(int size) {
//         this.size = size;
//     }

//     public int getSize() {
//         return size;
//     }
// }


public class Laptop {

    // Производитель (manufacturer)
    // ОЗУ (RAM)
    // Объем ЖД (HDD)
    // Операционная система (operatingSystem)
    // Цвет (color)
    // Год выпуска (year)

    private String manufacturer;
    private int RAM;
    private int HDD;
    private String operatingSystem;
    private String color;
    private int year;

    public Laptop(String manufacturer, int RAM, int HDD, String operatingSystem, String color, int year) {
        this.manufacturer = manufacturer;
        this.RAM = RAM;
        this.HDD = HDD;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String result = "Производитель: " + manufacturer + System.lineSeparator()
                + "ОЗУ: " + RAM + System.lineSeparator()
                + "Объем жесткого диска: " + HDD + System.lineSeparator()
                + "Операционная система: " + operatingSystem + System.lineSeparator()
                + "Цвет: " + color + System.lineSeparator()
                + "Год выпуска: " + year;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;

        return manufacturer.equals(laptop.manufacturer) && RAM == laptop.RAM && HDD == laptop.HDD && operatingSystem.equals(laptop.operatingSystem) && color.equals(laptop.color) && year == laptop.year;
    }

@Override
        public int hashCode() {
            return Objects.hash(manufacturer, RAM, HDD, operatingSystem, color, year);            
}
}