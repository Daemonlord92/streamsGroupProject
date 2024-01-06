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
}
