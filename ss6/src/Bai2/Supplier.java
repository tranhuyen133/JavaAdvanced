package Bai2;

public class Supplier implements Runnable {

    private TicketPool ticketPool;

    public Supplier(TicketPool pool) {
        this.ticketPool = pool;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(5000);

            ticketPool.addTickets(3);

        } catch (Exception e) {
        }
    }
}
