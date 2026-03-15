package btth;

public class BoxOffice implements Runnable {

    private TrainStation station;
    private String boothName;

    public BoxOffice(TrainStation station, String boothName) {
        this.station = station;
        this.boothName = boothName;
    }

    @Override
    public void run() {

        while (true) {

            boolean success = station.sellTicket(boothName);

            if (!success) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
