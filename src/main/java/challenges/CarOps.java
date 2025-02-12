package challenges;

import domain.Car;
import org.checkerframework.checker.units.qual.C;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarOps {
    //1. **Filter by Make:**
    public static List<Car> filterByMake(List<Car> cars, String make) {
        return cars
                .stream()
                .filter(x -> x.getMake().equalsIgnoreCase(make))
                .toList();
    }

    //2. **Filter by Year:**
    public static List<Car> filterByYear(List<Car> cars, int year) {
        return cars
                .stream()
                .filter(x -> x.getYear().equals(year))
                .toList();
    }

    //3. **Filter by Price:**
    public static List<Car> filterByPrice(List<Car> cars, double price) {
        return cars
                .stream()
                .filter(x -> x.getPrice() >= price - 1000.0 && x.getPrice() <= price + 1000.0)
                .toList();
    }

    //4. **Map to Model Names:**
    public static List<String> mapToModelNames(List<Car> cars) {
        return cars
                .stream()
                .map(Car::getModel)
                .toList();
    }

    //5. **Map to Upper Case Makes:**
    public static Set<String> mapToUpperCaseMakes(List<Car> cars) {
        return cars
                .stream()
                .map(x -> x.getMake().toUpperCase())
                .collect(Collectors.toSet());
    }

    //6. **Sort by Year:**
    public static List<Car> sortByYear(List<Car> cars) {
        return cars
                .stream().sorted(Comparator.comparing(Car::getYear))
                .toList();
    }
    //7. **Sort by Price (descending):**
    public static List<Car> sortByPrice(List<Car> cars) {
        return cars
                .stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .toList().reversed();
    }

    //8. **Get the Highest Priced Car:**
    public static Car getTheHighestPricedCar(List<Car> cars) {
        return cars
                .stream()
                .max(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }
    //9. **Get the Lowest Priced Car:**
    public static Car getLowestPricedCar(List<Car> cars) {
        return cars
                .stream()
                .min(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }

    //10. **Group by Make:**
    public static Map<String, List<Car>> groupByMake(List<Car> cars) {
        return cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
    }

    //11. **Count Cars by Make:**
    public static void countCarsByMake(List<Car> cars) {
        cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake))
                .forEach((x, y) -> System.out.println(x + " " + y.stream().count()));
    }

    //12. **Average Price:**
    public static double averagePrice(List<Car> cars) {
        return cars
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    //13. **Sum of Prices:**
    public static double sumOfPrices(List<Car> cars) {
        return cars
                .stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    //14. **Any Car with Blue Color:**
    public static List<Car> anyCarWithColor(List<Car> cars, String color) {
        return cars
                .stream()
                .filter(x -> x.getColor().equalsIgnoreCase(color))
                .toList();
    }

    //15. **All Cars are Expensive:**
    public static List<Car> allCarsAreExpensive(List<Car> cars) {
        return cars
                .stream()
                .filter(x -> x.getPrice() > 50000)
                .toList();
    }

    //16. **None Match the Condition:**
    public static List<Car> matchTheCondition(List<Car> cars, String make, String model, double price) {
        return cars
                .stream()
                .filter(x -> x.getMake().equalsIgnoreCase(make)
                        && x.getModel().equalsIgnoreCase(model)
                        && x.getPrice().equals(price))
                .toList();
    }

    //17. **Skip First N Cars:**
    public static List<Car> skipNCars(List<Car> cars, int n) {
        return cars
                .stream()
                .skip(n)
                .toList();
    }

    //18. **Limit to N Cars:**
    public static List<Car> limitNCars(List<Car> cars, int n) {
        return cars
                .stream()
                .limit(n)
                .toList();
    }

    //19. **Distinct Colors:**
    public static List<String> distinctColors(List<Car> cars) {
        return cars
                .stream()
                .map(x -> x.getColor())
                .distinct()
                .toList();
    }

    //20. **Concatenate Make and Model:**
    public static List<String> concatenateMakeAndModel(List<Car> cars) {
        return cars
                .stream()
                .map(x -> x.getMake() + " " + x.getModel())
                .toList();
    }

    //21. **Find First Car:**
    public static Car findFirstCar(List<Car> cars) {
        return cars
                .stream()
                .findFirst()
                .orElse(null);
    }

    //22. **Find Any Car:**
    public static Car findAnyCar(List<Car> cars) {
        Random random = new Random();
        return cars.get(random.nextInt(cars.size()));
    }

    //23. **Remove Duplicates:**
    public static List<Car> removeDuplicates(List<Car> cars) {
        return cars
                .stream()
                .distinct()
                .toList();
    }

    //24. **Partition Cars by Price:**
    public static void partitionCarsByPrice(List<Car> cars) {
            cars
                .stream()
                .collect(Collectors.groupingBy(x -> x.getPrice() > 50000))
                .forEach((x, y) -> {
                    System.out.println(x);
                    y.forEach(System.out::println);
                });
    }

    //25. **Calculate Total Price by Make:**
    public static void calculateTotalPriceByMake(List<Car> cars) {
        cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake))
                .forEach((x,y) -> {
                    System.out.println(x);
                    System.out.println(y.stream().mapToDouble(Car::getPrice).sum());
                });
    }

    //26. **Join Car Names into a String:**
    public static String joinCarNamesIntoAString(List<Car> cars) {
        StringBuilder names = new StringBuilder();
        cars
                .forEach(x -> {
                    names.append(x.getMake()).append(" ").append(x.getModel()).append(" ");
                });
        return names.toString();
    }

    //27. **Peek and Print:**
    public static void peekAndPrint(List<Car> cars) {
        cars
                .stream()
                .peek(System.out::println)
                .toList();
    }

    //28. **Average Price by Make:**
    public static void averagePriceByMake(List<Car> cars) {
        cars
                .stream()
                .collect(Collectors.groupingBy(Car::getMake))
                .forEach((x,y) -> {
                    System.out.println(x);
                    System.out.println(y.stream().mapToDouble(Car::getPrice).average().orElse(0.0));
                });
    }

    //29. **Concatenate All Car Details:**
    public static List<String> concatenateAllCarDetails(List<Car> cars) {
        return cars
                .stream()
                .map(x -> {
                    StringBuilder carString = new StringBuilder();
                    carString.append("Car Id: ")
                            .append(x.getId())
                            .append(", Make: ")
                            .append(x.getMake())
                            .append(", Model: ")
                            .append(x.getModel())
                            .append(", Year: ")
                            .append(x.getYear())
                            .append(", Color: ")
                            .append(x.getColor())
                            .append(", Price: $")
                            .append(x.getPrice());
                    return carString.toString();
                }).toList();
    }

    //30. **Find the Newest Car:**
    public static Car findNewestCar(List<Car> cars) {
        return cars
                .stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }
}
