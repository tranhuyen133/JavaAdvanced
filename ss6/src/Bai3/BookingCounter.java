package Bai3;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool roomA;
    private TicketPool roomB;

    private int soldCount = 0;

    public BookingCounter(String name, TicketPool roomA, TicketPool roomB) {
        this.name = name;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        while (true) {

            Ticket ticketA = roomA.sellTicket();

            if (ticketA != null) {
                System.out.println(name + " đã bán vé " + ticketA.getTicketId());
                soldCount++;
            }

            Ticket ticketB = roomB.sellTicket();

            if (ticketB != null) {
                System.out.println(name + " đã bán vé " + ticketB.getTicketId());
                soldCount++;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }

            if (roomA.getRemainingTickets() == 0 && roomB.getRemainingTickets() == 0) {
                break;
            }
        }

        System.out.println(name + " bán được: " + soldCount + " vé");
    }
}
