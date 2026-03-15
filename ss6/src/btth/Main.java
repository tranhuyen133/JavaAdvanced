package btth;

public class Main {

    public static void main(String[] args) {

        TrainStation station = new TrainStation(10);

        Thread booth1 = new Thread(new BoxOffice(station, "Quầy 1"));
        Thread booth2 = new Thread(new BoxOffice(station, "Quầy 2"));
        Thread booth3 = new Thread(new BoxOffice(station, "Quầy 3"));

        booth1.start();
        booth2.start();
        booth3.start();
    }
}
