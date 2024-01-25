package com.spiritcoders.productservice.service;

import java.util.function.Supplier;

public class Rule<T> {
    private Supplier<Boolean> condition;
    private Supplier<Double> process;

    public Rule(Supplier<Boolean> condition, Supplier<Double> process) {
        this.condition = condition;
        this.process = process;
    }
}
