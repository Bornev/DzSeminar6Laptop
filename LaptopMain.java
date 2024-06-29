// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.

// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// Например:
// Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// package s6.dz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopMain {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("ASUS", 4, 256, "Windows 10", "Черный", 2022);
        Laptop laptop2 = new Laptop("HP", 8, 1024, "Windows 11", "Красный", 2024);
        Laptop laptop3 = new Laptop("MSI", 12, 512, "Linux", "Серый", 2023);
        Laptop laptop4 = new Laptop("Apple", 8, 512, "MacOS", "Белый", 2023);
        Laptop laptop5 = new Laptop("GIGABYTE", 4, 1024, "Windows 11", "Черный", 2024);
        Laptop laptop6 = new Laptop("ASUS", 32, 512, "Windows 11", "Черный", 2023);
        Laptop laptop7 = new Laptop("HP", 16, 1024, "Linux", "Серый", 2024);
        Laptop laptop8 = new Laptop("MSI", 16, 512, "Windows 12", "Серый", 2024);
        Laptop laptop9 = new Laptop("Apple", 16, 512, "MacOS", "Черный", 2024);
        Laptop laptop10 = new Laptop("GIGABYTE", 64, 1024, "Windows 12", "Черный", 2024);

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7,
                laptop8, laptop9, laptop10));

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
            System.out.println();
        }
        filterLaptops(laptops);
    }

    private static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        try {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем жесткого диска");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            int criterion = scanner.nextInt();
            scanner.nextLine();

            switch (criterion) {
                case 1:
                    System.out.println("Выберите минимальный объем ОЗУ:");
                    for (RAMSize ram : RAMSize.values()) {
                        System.out.println(ram.ordinal() + 1 + " - " + ram.getSize() + "GB");
                    }
                    int ramChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (ramChoice > 0 && ramChoice <= RAMSize.values().length) {
                        criteria.put("RAM", RAMSize.values()[ramChoice - 1].getSize());
                    } else {
                        System.out.println("Некорректный ввод.");
                        return;
                    }
                    break;
                case 2:
                    System.out.println("Выберите минимальный объем жесткого диска:");
                    for (HDDSize hdd : HDDSize.values()) {
                        System.out.println(hdd.ordinal() + 1 + " - " + hdd.getSize() + "GB");
                    }
                    int hddChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (hddChoice > 0 && hddChoice <= HDDSize.values().length) {
                        criteria.put("HDD", HDDSize.values()[hddChoice - 1].getSize());
                    } else {
                        System.out.println("Некорректный ввод.");
                        return;
                    }
                    break;
                case 3:
                    System.out.println("Выберите операционную систему:");
                    for (OperatingSystem os : OperatingSystem.values()) {
                        System.out.println(os.ordinal() + 1 + " - " + os);
                    }
                    int osChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (osChoice > 0 && osChoice <= OperatingSystem.values().length) {
                        criteria.put("OS", OperatingSystem.values()[osChoice - 1]);
                    } else {
                        System.out.println("Некорректный ввод.");
                        scanner.close();
                        return;
                    }
                    break;
                case 4:
                    System.out.println("Выберите цвет:");
                    for (Color color : Color.values()) {
                        System.out.println(color.ordinal() + 1 + " - " + color.getName());
                    }
                    int colorChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (colorChoice > 0 && colorChoice <= Color.values().length) {
                        criteria.put("Color", Color.values()[colorChoice - 1]);
                    } else {
                        System.out.println("Некорректный ввод.");
                        scanner.close();
                        return;
                    }
                    break;
                default:
                    System.out.println("Некорректный ввод.");
                    scanner.close();
                    return;

            }

            for (Laptop laptop : laptops) {
                boolean matches = true;

                if (criteria.containsKey("RAM") && laptop.getRAM() < (int) criteria.get("RAM")) {
                    matches = false;
                }

                if (criteria.containsKey("HDD") && laptop.getHDD() < (int) criteria.get("HDD")) {
                    matches = false;
                }

                if (criteria.containsKey("OS")
                        && !laptop.getOperatingSystem().equalsIgnoreCase(criteria.get("OS").toString())) {
                    matches = false;
                }

                if (criteria.containsKey("Color")
                        && !laptop.getColor().equalsIgnoreCase(criteria.get("Color").toString())) {
                    matches = false;
                }

                if (matches) {
                    System.out.println(laptop);
                    System.out.println();
                }

            }
        } finally {
            scanner.close();
        }
    }

    enum OperatingSystem {
        WINDOWS_10("Windows 10"), WINDOWS_11("Windows 11"), WINDOWS_12("Windows 12"), LINUX("Linux"), MACOS("MacOS");

        private final String name;

        OperatingSystem(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    enum Color {
        BLACK("Черный"), WHITE("Белый"), RED("Красный"), GRAY("Серый");

        private final String name;

        Color(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    enum RAMSize {
        _4GB(4), _8GB(8), _12GB(12), _16GB(16), _32GB(32), _64GB(64);

        private final int size;

        RAMSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    enum HDDSize {
        _256GB(256), _512GB(512), _1024GB(1024);

        private final int size;

        HDDSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
}
