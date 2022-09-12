package org.example;

import com.opencsv.CSVReader;
import org.example.model.Car;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Чтение csv-файла  помощью CSVReader.
 */
public class ReadExample {

    public static void main(String[] args) throws IOException {
        String path = "csv_dir/cars.csv";
        List<Car> carsReadSingleLine = singleLine(path);
        List<Car> carsReadAllLine = allLine(path);

        System.out.println(carsReadSingleLine);
        System.out.println(carsReadAllLine);
    }

    private static List<Car> singleLine(String path) throws IOException {
        List<Car> cars = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                cars.add(Car.buildCar(line));
            }
        }

        return cars;
    }

    private static List<Car> allLine(String path) throws IOException {
        List<Car> cars;
        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            cars = csvReader.readAll()
                    .stream()
                    .map(Car::buildCar)
                    .collect(Collectors.toList());
        }

        return cars;
    }
}
