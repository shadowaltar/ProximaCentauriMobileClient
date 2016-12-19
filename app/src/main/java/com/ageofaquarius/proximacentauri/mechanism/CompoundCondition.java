package com.ageofaquarius.proximacentauri.mechanism;

/**
 * Created by Mars on 2016-12-20.
 */

public class CompoundCondition implements TrueFalse {
    private TrueFalse leftSide;
    private LogicOperator operator;
    private TrueFalse rightSide;

    @Override
    public boolean getResult() {
        switch (operator) {
            case AND:
                return leftSide.getResult() && rightSide.getResult();
            case NOT:
                return !leftSide.getResult();
            case OR:
                return leftSide.getResult() || rightSide.getResult();
            case XOR:
                return leftSide.getResult() ^ rightSide.getResult();
            case XNOR:
                return !(leftSide.getResult() ^ rightSide.getResult());
        }
        throw new UnsupportedOperationException("Unknown logic operator.");
    }
}
