package org.example;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.model.Car;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Чтение csv-файла в формате Java-класс.
 */
public class ReadAsJavaClass {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("csv_dir/cars.csv");
        CsvToBean<Car> csv = new CsvToBeanBuilder<Car>(reader)
                .withMappingStrategy(getStrategy())
                .build();

        List<Car> parse = csv.parse();

        parse.forEach(System.out::println);
    }

    private static ColumnPositionMappingStrategy<Car> getStrategy() {
        ColumnPositionMappingStrategy<Car> strategy =
                new ColumnPositionMappingStrategy<>();
        strategy.setType(Car.class);
        strategy.setColumnMapping("yearOfIssue", "name", "model", "description", "price");
        return strategy;
    }
}
