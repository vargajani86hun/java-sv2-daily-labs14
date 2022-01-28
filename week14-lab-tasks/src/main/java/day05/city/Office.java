package day05.city;


public class Office extends Building {
    public static final int MINIMUM_AREA_FOR_TABLE = 2;
    public static final int MAXIMUM_AREA_FOR_TABLE = 5;

    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        if (numberOfTablesPerLevel*MINIMUM_AREA_FOR_TABLE > area) {
            throw new IllegalArgumentException("Too many tables per level!");
        }
        if (numberOfTablesPerLevel*MAXIMUM_AREA_FOR_TABLE < area) {
            throw new IllegalArgumentException("Too few tables per level!");
        }
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
    }

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        this(area, 1, address, company, numberOfTablesPerLevel);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
