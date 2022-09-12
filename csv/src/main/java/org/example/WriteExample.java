package org.example;

import com.opencsv.CSVWriter;
import org.example.model.Car;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Запись csv-файла  помощью CSVWriter.
 */
public class WriteExample {
    public static void main(String[] args) throws IOException {

        Car car = new Car(1996, "Lada", "Granta", "nice car", 20000);
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("csv_dir/cars.csv", true))) {
                csvWriter.writeNext(car.toString().split(","));
        }
    }
}