package day05.city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (fullArea >= (building.getArea() + getSumBuildingsArea())) {
            buildings.add(building);
        }
        else {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }

    /*
        This is the shortest version of the searching. Because on the list of buildings,
        it has to be once a full iteration, but in that solution, don't need more.
    */
    public Building findHighestBuilding() {
        if (buildings.isEmpty()) {
            throw new IllegalStateException("There's no building in the city!");
        }
        List<Building> highestBuildings = new ArrayList<>();
        int maxLevel = 0;
        for (Building actual : buildings) {
            if (actual.getLevels() > maxLevel) {
                maxLevel = actual.getLevels();
                highestBuildings.clear();
            }
            if (actual.getLevels() == maxLevel) {
                highestBuildings.add(actual);
            }
        }
        return highestBuildings.get(0);
    }

    public Building findHighestBuildingWithStream() {
        return buildings.stream()
                .max(Comparator.comparingInt(Building::getLevels))
                .orElseThrow(() -> new IllegalStateException("There's no building in the city!"));
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> results = new ArrayList<>();
        for (Building actual : buildings) {
            if (actual.getAddress().getStreet().equals(street)) {
                results.add(actual);
            }
        }
        return results;
    }

    public List<Building> findBuildingsByStreetWithStream(String street) {
        return buildings.stream()
                .filter(b -> b.getAddress().getStreet().equals(street))
                .toList();
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() >= numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereBuildingWithMorePeopleThanWithStream(int numberOfPeople) {
        return buildings.stream()
                .anyMatch(b -> b.calculateNumberOfPeopleCanFit() >= numberOfPeople);
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return new ArrayList<>(buildings);
    }

    private long getSumBuildingsArea() {
        long sum = 0;
        for (Building actual : buildings) {
            sum += actual.getArea();
        }
        return sum;
    }
}
