package Bai1;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 2);

        Thread counter1 = new Thread(
                new BookingCounter("Quầy 1", roomA, roomB)
        );

        Thread counter2 = new Thread(
                new BookingCounter("Quầy 2", roomB, roomA) // đảo thứ tự
        );

        counter1.start();
        counter2.start();
    }
}
