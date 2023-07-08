package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Timed(value = "my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {
    private final AtomicInteger stock = new AtomicInteger(100);

    private static void sleep(int l) {
        try {
            Thread.sleep(l + new Random().nextInt(200)); // 0.5 ~ 0.7 초
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet(); // 값 증가
        sleep(200);
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
