package data;

import challenges.CarOps;
import domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static challenges.CarOps.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarOpsTest {

    private static List<Car> cars;
    private static Optional<Car> allCars;

    @BeforeAll
    static void setUp() throws IOException {
        // Fetch data before all tests
        cars = FetchData.getCarList();
    }


    //Question-31
    @Test
    public void filterByMake_ShouldBeSuccessful_ReturnsResults() {
        List<Car> result = filterByMake(cars, "Ford");
        Assertions.assertEquals(38, result.size());
    }

    //Question-32
}
