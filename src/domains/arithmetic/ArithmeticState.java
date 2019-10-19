package domains.arithmetic;

/**
 * CS 2511
 * @author David Gagliardi
 */
import framework.problem.State;
import java.util.stream.Stream;

public class ArithmeticState implements State {
  
        public ArithmeticState(int num) {
            this.num = num;
        }
/**
 * 
 * @param other
 * @return Boolean state equality
 */
        @Override
        public boolean equals(Object other) {
            ArithmeticState otherArithmetic = (ArithmeticState) other;
            return this.num == otherArithmetic.num;
        }
/**
 * 
 * @return State string sb
 */
        @Override
        public String toString() {
            String phrase = "The value is: ";
            StringBuilder sb = new StringBuilder(phrase);
            
            sb.append(num);
          
            return sb.toString();
        }

        public final int num;
    }