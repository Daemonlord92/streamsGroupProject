package challenges;

import domain.Car;

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
}
