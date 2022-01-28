package day05.city;

public abstract class Building {
    private int area;
    private int levels;
    private Address address;

    public Building(int area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(int area, Address address) {
        this(area, 1, address);
    }

    public abstract int calculateNumberOfPeopleCanFit();

    public int getFullArea() {
        return area * levels;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}
