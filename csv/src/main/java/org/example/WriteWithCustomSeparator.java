package org.example;

import com.opencsv.CSVWriter;
import org.example.model.Car;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Запись csv-файла помощью CSVWriter (при кастомном сепараторе).
 */
public class WriteWithCustomSeparator {

    private static final char SEPARATOR = '|';

    public static void main(String[] args) throws IOException {
        Car car = new Car(1996, "Ford", "Focus", "nice car", 20000);

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("csv_dir/cars_custom_separator.csv", true), SEPARATOR)) {
            csvWriter.writeNext(car.toString().split(","));
        }
    }
}
