package Bai3;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB);

        TicketSupplier supplier = new TicketSupplier(
                roomA,
                roomB,
                3,      // số vé thêm
                3000,   // 3 giây
                3       // số lần cung cấp
        );

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();
    }
}
