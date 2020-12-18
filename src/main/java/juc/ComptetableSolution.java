package juc;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ComptetableSolution {
    public static void main(String[] args) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                return null;
            }
        });

    }
}
