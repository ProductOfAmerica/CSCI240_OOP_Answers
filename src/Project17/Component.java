package Project17;

import java.util.Map;
import java.util.SortedSet;

public interface Component {
   public String getName();
   public int getPartCount();     // Return total count of Parts
   public double getMaxWeight();  // Return weight of heaviest individual Part
}
