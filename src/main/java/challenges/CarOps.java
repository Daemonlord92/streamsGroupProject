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
}
