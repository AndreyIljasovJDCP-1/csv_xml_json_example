package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.model.Car;

import java.io.FileReader;
import java.io.IOException;

/**
 * Чтение csv-файла помощью CSVReader (при кастомном сепараторе).
 */
public class ReadWithCustomSeparator {

    private static final char SEPARATOR = '|';

    public static void main(String[] args) throws IOException {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(SEPARATOR)
                .build();

        CSVReader reader = new CSVReaderBuilder(new FileReader("csv_dir/cars_custom_separator.csv"))
                .withCSVParser(parser)
                .build();

        reader.readAll()
                .stream()
                .map(Car::buildCar)
                .forEach(System.out::println);
    }
}
