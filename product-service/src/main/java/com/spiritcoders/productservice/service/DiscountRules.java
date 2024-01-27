package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class DiscountRules {
    public Rule<Double> createRule (Supplier<Boolean> condition, Supplier<Double> process){
        return new Rule<>(condition, process);
    }

    public Rule<Double> computeRuleForFifteenPercentDiscount(List<Product> productList){
        return createRule(() -> { return productList.size() <= 1; },
                () -> {
                    System.out.println(" Discount for 15 " + productList.size() * 100);
                    return (double) productList.size() * 100;
                });
    }

    public Rule<Double> computeRuleForTwentyPercentDiscount(List<Product> productList){
        return createRule(
                ()-> productList.size() <= 2,
                () -> {
                    System.out.println(" Discount for 20 " + productList.size() * 200);
                    return (double) productList.size() * 200;
                } );
    }

    public Rule<Double> computeRuleForTwentyFivePercentDiscount(List<Product> productList){
        return createRule(
                ()-> productList.size() <= 3,
                () -> {
                    System.out.println(" Discount for 25 " + productList.size() * 300);
                    return(double) productList.size() * 300;
                }  );
    }

    public Map<Discount, Rule> getRulesMap(List<Product> productList){

        Map<Discount, Rule> ruleMap = new HashMap<>();
        ruleMap.put(Discount.FIFTEEN, computeRuleForFifteenPercentDiscount(productList));
        ruleMap.put(Discount.TWENTY, computeRuleForTwentyPercentDiscount(productList));
        ruleMap.put(Discount.TWENTY_FIVE, computeRuleForTwentyFivePercentDiscount(productList));

        return ruleMap;
    }

    public Double getDiscount(List<Product> productList){
        Map<Discount, Rule> ruleMap = getRulesMap(productList);
        return Stream.of(Discount.values())
                .filter(discount -> (boolean) ruleMap.get(discount).getCondition().get())
                .map(discount -> (double) ruleMap.get(discount).getProcess().get())
                .findFirst()
                .orElse(null);
    }
}
