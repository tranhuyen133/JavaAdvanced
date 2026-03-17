package bai3;

public class Main {

    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        AirConditioner ac = new AirConditioner();

        // Gán nút
        remote.setCommand(1, new LightOnCommand(light));
        remote.setCommand(2, new LightOffCommand(light));
        remote.setCommand(3, new ACSetTemperatureCommand(ac, 26));

        // Nhấn nút 1
        remote.pressButton(1);

        // Nhấn nút 2
        remote.pressButton(2);

        // Undo
        remote.undo();

        // Nhấn nút 3
        remote.pressButton(3);

        // Undo
        remote.undo();
    }
}
