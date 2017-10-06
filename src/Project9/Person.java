package Project9;

public class Person {
    private String name;
    private int loLimit;
    private int hiLimit;

    public Person(String name, int loLimit, int hiLimit) {
        this.name = name;
        this.loLimit = loLimit;
        this.hiLimit = hiLimit;
    }

    public void register(Thermometer thm) {
        thm.addPerson(this);
    }

    public void update(int newTemp) {
        String temp = name + ": " + newTemp + " is too ";
        if(newTemp > hiLimit)
            System.out.println(temp + "hot. Turn it down to " + hiLimit + ".");
        else if(newTemp < loLimit)
            System.out.println(temp + "cold. Turn it up to " + loLimit + ".");
    }
}