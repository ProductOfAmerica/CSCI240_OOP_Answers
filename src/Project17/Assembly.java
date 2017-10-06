package Project17;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

public class Assembly implements Component {
    private String name;
    private List<Component> pieces;

    public Assembly(String name, List<Component> pieces) {
        this.name = name;
        this.pieces = pieces;
    }

    @Override
    public String getName() {return name;}


    /// / Write getMaxWeight
    @Override
    public double getMaxWeight() {
        double temp = 0;
        for (Component d : pieces)
            if(d.getMaxWeight() > temp)
                temp = d.getMaxWeight();
        return temp;
    }

    // Write getPartCount
    @Override
    public int getPartCount() {
        return pieces.size();
    }
}