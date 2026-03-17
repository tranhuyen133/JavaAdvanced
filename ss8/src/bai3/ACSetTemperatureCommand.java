package bai3;

public class ACSetTemperatureCommand implements Command {

    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        prevTemp = ac.getTemperature(); // lưu nhiệt độ cũ
        ac.setTemperature(newTemp);
    }

    @Override
    public void undo() {
        ac.setTemperature(prevTemp);
        System.out.println("Undo: Điều hòa quay về " + prevTemp);
    }
}