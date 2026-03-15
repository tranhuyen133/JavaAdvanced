package Bai2;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool ticketPool;

    public BookingCounter(String name, TicketPool pool) {
        this.counterName = name;
        this.ticketPool = pool;
    }

    @Override
    public void run() {

        while (true) {

            ticketPool.sellTicket(counterName);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}