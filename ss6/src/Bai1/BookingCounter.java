package Bai1;

public class BookingCounter implements Runnable {

    private TicketPool roomA;
    private TicketPool roomB;
    private String counterName;

    public BookingCounter(String name, TicketPool a, TicketPool b) {
        this.counterName = name;
        this.roomA = a;
        this.roomB = b;
    }

    public void sellCombo() {

        synchronized (roomA) {

            System.out.println(counterName + " đã lấy vé phòng " + roomA.getRoomName());

            try {
                Thread.sleep(500);
            } catch (Exception e) {}

            synchronized (roomB) {

                if (roomA.hasTicket() && roomB.hasTicket()) {

                    String ticketA = roomA.getTicket();
                    String ticketB = roomB.getTicket();

                    System.out.println(counterName + " bán combo: "
                            + ticketA + " & " + ticketB);

                } else {
                    System.out.println(counterName + " bán combo thất bại");
                }
            }
        }
    }

    @Override
    public void run() {
        sellCombo();
    }
}
