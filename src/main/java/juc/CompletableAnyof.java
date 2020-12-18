package juc;

import java.util.concurrent.CompletableFuture;

public class CompletableAnyof {

    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        System.out.println("主线程继续干别的事情.....");
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        //Thread.sleep(200);
        Thread.currentThread().join();
    }

    static String queryCode(String name, String url) {
        System.out.println(Thread.currentThread().getName()+"::query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        if(url.contains("163")){
            return "60163";
        }else {
            return "88888";
        }
    }

    static Double fetchPrice(String code, String url) {
        System.out.println(Thread.currentThread().getName()+"::code:"+code+",query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        if(url.contains("163")){
            return 8.6d;
        }else {
            return 9.9d;
        }
    }

}
