package domains.farmer;

/**
 *
 * @author David Gagliardi
 */
import framework.problem.State;
import java.util.Objects;

public class FarmerState implements State {
    
public FarmerState(String farmer, String wolf, String goat, String cabbage) {
    this.f = farmer;
    this.w = wolf;
    this.g = goat;
    this.c = cabbage;
}
/**
 * 
 * @param other
 * @return Boolean state equality
 */
@Override
public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        FarmerState otherFarmer = (FarmerState)other;
        return ((this.f == null ? otherFarmer.f == null : this.f.equals(otherFarmer.f)) &&
                (this.w == null ? otherFarmer.w == null : this.w.equals(otherFarmer.w)) &&
                (this.g == null ? otherFarmer.g == null : this.g.equals(otherFarmer.g)) &&
                (this.c == null ? otherFarmer.c == null : this.c.equals(otherFarmer.c)));
}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.f);
        hash = 29 * hash + Objects.hashCode(this.g);
        hash = 29 * hash + Objects.hashCode(this.w);
        hash = 29 * hash + Objects.hashCode(this.c);
        return hash;
    }
/**
 * 
 * @return State string sb
 */
@Override
public String toString() {
StringBuilder sb = new StringBuilder();

sb.append("   |  |   \n");

if (f == "West") {
    sb.append(" F |  |   \n");
} else if (f == "East") {
    sb.append("   |  | F \n");
}

if (w == "West") {
    sb.append(" W |  |   \n");
} else if (w == "East") {
    sb.append("   |  | W \n");
}

if (g == "West") {
    sb.append(" G |  |   \n");
} else if (g == "East"){
    sb.append("   |  | G \n");
}

if (c == "West") {
    sb.append(" C |  |   \n");
} else if (c == "East") {
    sb.append("   |  | C \n");
}

sb.append("   |  |   ");
          
return sb.toString();
}

public String f = "", g = "", w = "", c = "";
}
