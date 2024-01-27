package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Getter
@Setter
@Builder
public class Rule<T> {
    private Supplier<Boolean> condition;
    private Supplier<Double> process;

    public Rule(){}

    public Rule(Supplier<Boolean> condition, Supplier<Double> process) {
        this.condition = condition;
        this.process = process;
    }
}
