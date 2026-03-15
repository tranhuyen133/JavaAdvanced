package bai5;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {

            String id = roomName + "-" + String.format("%03d", i);

            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket holdTicket(boolean isVIP, String counterName) {

        for (Ticket ticket : tickets) {

            if (!ticket.isSold() && !ticket.isHeld()) {

                ticket.setHeld(true);
                ticket.setVIP(isVIP);

                long expiry = System.currentTimeMillis() + 5000;

                ticket.setHoldExpiryTime(expiry);

                System.out.println(counterName +
                        ": Đã giữ vé " + ticket.getTicketId() +
                        (isVIP ? " (VIP)" : "") +
                        ". Thanh toán trong 5s");

                return ticket;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket, String counterName) {

        if (ticket != null && ticket.isHeld()) {

            ticket.setSold(true);
            ticket.setHeld(false);

            System.out.println(counterName +
                    ": Thanh toán thành công vé " +
                    ticket.getTicketId());
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket ticket : tickets) {

            if (ticket.isHeld() && !ticket.isSold()
                    && now > ticket.getHoldExpiryTime()) {

                ticket.setHeld(false);

                System.out.println(
                        "TimeoutManager: Vé "
                                + ticket.getTicketId()
                                + " hết hạn giữ, trả lại kho"
                );
            }
        }
    }
}
