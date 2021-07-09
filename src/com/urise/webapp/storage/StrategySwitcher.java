package com.urise.webapp.storage;

import java.util.Objects;

public class StrategySwitcher {
    private Strategy strategy;

    public StrategySwitcher(Strategy strategy) {
        Objects.requireNonNull(strategy, "Strategy must not be null");
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }
}
