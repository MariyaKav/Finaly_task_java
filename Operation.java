import java.util.*;

public class Operation {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("HP", 8, 1000, "Windows11", "black"));
        laptops.add(new Laptop("Asus", 16, 1000, "Windows11", "grey"));
        laptops.add(new Laptop("Lenovo", 12, 2000, "Windows10", "red"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "green"));
        filterLaptops(laptops);       
    }
    public static void filterLaptops(Set<Laptop> Laptops) {
        Map<String, String> criteria = new HashMap<>();
        criteria.put("1", "ОЗУ");
        criteria.put("2", "Объем ЖД");
        criteria.put("3", "Операционная система");
        criteria.put("4", "Цвет");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соотвествующую необходимому критерию");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String userInput = scanner.nextLine();
        if (criteria.containsKey(userInput)) {
            String selectedCriteria = criteria.get(userInput);
            System.out.println("Введите минимальное значение для " + selectedCriteria + ":");
            String minValue = scanner.nextLine();
            Set<Laptop> filterLaptops = new HashSet<>();
            switch (selectedCriteria) {
                case "ОЗУ" :
                    int minRam = Integer.parseInt(minValue);
                    for (Laptop laptop : Laptops) {
                        if (laptop.getRam() >= minRam) {
                            filterLaptops.add(laptop);
                        }
                    }
                    break;
                case "Объем ЖД" :
                    int minHddSize = Integer.parseInt(minValue);
                    for (Laptop laptop : Laptops) {
                        if (laptop.gethddSize() >= minHddSize) {
                            filterLaptops.add(laptop);
                        }
                    }
                    break;
                case "Операционная система" :
                    for (Laptop laptop : Laptops) {
                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
                            filterLaptops.add(laptop);
                        }
                    }
                    break;
                case "Цвет" :
                    for (Laptop laptop : Laptops) {
                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
                            filterLaptops.add(laptop);
                        }
                    }   
                    break;
                default:
                    System.out.println("Некорректный ввод критерия!");
                    return;
            }
            if (filterLaptops.isEmpty()){
                System.out.println("Ноутбуки, удовлетворяющие условиям фильтрации, не найдены.");
            } else {
                for (Laptop laptop : filterLaptops) {
                    System.out.println(laptop);
                }
            }
        } else {
            System.out.println("Некорректный ввод критерия!");
        }
    }

}