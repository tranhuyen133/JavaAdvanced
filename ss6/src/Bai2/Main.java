package Bai2;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 3);

        Thread counter1 = new Thread(
                new BookingCounter("Quầy 1", roomA)
        );

        Thread counter2 = new Thread(
                new BookingCounter("Quầy 2", roomA)
        );

        Thread supplier = new Thread(
                new Supplier(roomA)
        );

        counter1.start();
        counter2.start();
        supplier.start();
    }
}