package bai4;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;

    Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        while (true) {

            if (roomA.getRemainingTickets() == 0 &&
                    roomB.getRemainingTickets() == 0) {
                break;
            }

            int choice = random.nextInt(2);

            Ticket ticket = null;

            if (choice == 0) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }

            if (ticket != null) {

                System.out.println(counterName +
                        " đã bán vé " + ticket.getTicketId());

                soldCount++;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }

        }

        System.out.println(counterName + " bán được: " + soldCount + " vé");
    }
}
