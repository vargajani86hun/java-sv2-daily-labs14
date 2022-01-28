package day05.daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetView {
    private Map<String, List<Integer>> soldBuildings = new HashMap<>();

    public Map<String, List<Integer>> getSoldBuildings() {
        return soldBuildings;
    }


    public void readSoldOrderFromFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");

                if (!soldBuildings.containsKey(values[0])) {
                    addNewStreet(values[0]);
                }

                addNewHouseNumber(values[0], Integer.parseInt(values[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file: " + fileName, ioe);
        }
    }

    private void addNewStreet(String street) {
        soldBuildings.put(street, new ArrayList<>());
    }

    private void addNewHouseNumber(String street, int sign) {
        int lastNumber = soldBuildings.get(street).stream().mapToInt(i->i)
                .filter(i -> i % 2 == sign).max().orElse(-sign);

        soldBuildings.get(street).add(lastNumber + 2) ;
    }
}
