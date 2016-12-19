package com.ageofaquarius.proximacentauri.mechanism;

/**
 * Created by Mars on 2016-12-20.
 */

public class Condition implements TrueFalse {
    private String subject;
    private OperandType subjectType;

    private Operator operator;

    private String target;
    private OperandType targetType;

    @Override
    public boolean getResult() {
        throw new UnsupportedOperationException("Unknown operator.");
    }
}
