package org.example;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Запись Java-класса в формате .csv.
 */
public class WriteOnJavaClass {
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Car> cars = List.of(
                new Car(1996, "Ford", "Focus", "nice car", 20000),
                new Car(2001, "BMW", "m5", "MUST SELL", 40000)
        );
        try (FileWriter writer = new FileWriter("csv_dir/cars.csv", true)) {
            StatefulBeanToCsv<Car> sbc =
                    new StatefulBeanToCsvBuilder<Car>(writer)
                            .withMappingStrategy(getStrategy())
                            .build();
            sbc.write(cars);
        }
    }

    private static ColumnPositionMappingStrategy<Car> getStrategy() {
        ColumnPositionMappingStrategy<Car> strategy =
                new ColumnPositionMappingStrategy<>();
        strategy.setType(Car.class);
        strategy.setColumnMapping("yearOfIssue", "name", "model", "description", "price");
        return strategy;
    }
}
