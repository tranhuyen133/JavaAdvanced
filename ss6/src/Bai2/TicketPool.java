package Bai2;

public class TicketPool {

    private String roomName;
    private int tickets;
    private int ticketNumber = 1;

    public TicketPool(String roomName, int tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }

    public synchronized void sellTicket(String counterName) {

        try {

            while (tickets == 0) {
                System.out.println(counterName + ": Hết vé phòng "
                        + roomName + ", đang chờ...");
                wait(); // chờ vé mới
            }

            String ticket = roomName + "-" + ticketNumber++;

            tickets--;

            System.out.println(counterName + " bán vé " + ticket);

            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void addTickets(int amount) {

        tickets += amount;

        System.out.println("Nhà cung cấp: Đã thêm "
                + amount + " vé vào phòng " + roomName);

        notifyAll(); // đánh thức các quầy đang chờ
    }
}
