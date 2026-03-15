package bai5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool[] pools;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool[] pools) {
        this.counterName = counterName;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            int roomIndex = random.nextInt(pools.length);

            boolean isVIP = random.nextBoolean();

            TicketPool pool = pools[roomIndex];

            Ticket ticket = pool.holdTicket(isVIP, counterName);

            if (ticket != null) {

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {}

                pool.sellHeldTicket(ticket, counterName);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}