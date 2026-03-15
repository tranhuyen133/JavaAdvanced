package btth;

public class TrainStation {

    private int tickets;

    public TrainStation(int tickets) {
        this.tickets = tickets;
    }

    public synchronized boolean sellTicket(String boothName) {

        if (tickets > 0) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tickets--;

            System.out.println(
                    boothName + " đã bán 1 vé. Số vé còn lại: " + tickets
            );

            return true;

        } else {

            System.out.println(
                    boothName + " thông báo: Đã hết vé!"
            );

            return false;
        }
    }
}
