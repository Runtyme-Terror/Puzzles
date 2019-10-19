package domains.arithmetic;
/*
* CS 2511
* @author David Gagliardi
*
*/

import domains.arithmetic.ArithmeticState;
import framework.problem.Mover;
import framework.problem.State;

public class ArithmeticMover extends Mover {

        public static final String ADD = "Add 3";
        public static final String SUBTRACT = "Subtract 5";
        public static final String DIVIDE = "Divide by 2";
        public static final String MULTIPLY = "Multiply by 2";
    
        public ArithmeticMover() {
            super.addMove(ADD, s -> tryAdd(s));
            super.addMove(SUBTRACT, s -> trySubtract(s));
            super.addMove(DIVIDE, s -> tryDivide(s));
            super.addMove(MULTIPLY, s -> tryMultiply(s));
        }
/**
 * 
 * @param state
 * @return new ArithmeticState(oldState + 3)
 */
        private State tryAdd(State state) {
            ArithmeticState oldState = (ArithmeticState) state;
            int addNum = oldState.num + 3;
            return new ArithmeticState(addNum);
        }
/**
 * 
 * @param state
 * @return new ArithmeticState(oldState - 5)
 */
        private State trySubtract(State state) {
            ArithmeticState oldState = (ArithmeticState) state;
            int subNum = oldState.num - 5;
            return new ArithmeticState(subNum);
        }
/**
 * 
 * @param state
 * @return new ArithmeticState(oldState / 2)
 */
        private State tryDivide(State state) {
            ArithmeticState oldState = (ArithmeticState) state;
            int divNum = oldState.num / 2;
            return new ArithmeticState(divNum);
        }
/**
 * 
 * @param state
 * @return new ArithmeticState(oldState * 2)
 */
        private State tryMultiply(State state) {
            ArithmeticState oldState = (ArithmeticState) state;
            int multiNum = oldState.num * 2;
            return new ArithmeticState(multiNum);
        }

    }