package bai2;

public class SmartHomeFacade {

    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(Light light, Fan fan,
                           AirConditioner ac,
                           TemperatureSensor sensor) {

        this.light = light;
        this.fan = fan;
        this.ac = ac;
        this.sensor = sensor;
    }

    // Rời nhà
    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    // Chế độ ngủ
    public void sleepMode() {
        light.off();
        ac.setTemperature(28);
        fan.lowSpeed();
    }

    // Xem nhiệt độ
    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.println("Nhiệt độ hiện tại: " + temp + "°C");
    }
}
