package bai5;

public class Ticket {

    private String ticketId;
    private String roomName;

    private boolean isSold = false;
    private boolean isHeld = false;
    private boolean isVIP;

    private long holdExpiryTime;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isSold() {
        return isSold;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }
}
