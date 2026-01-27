package week2.thermometer;

public class ThermometerDriver {
    public static void main(String... args) {

        Thermometer t1 = new Thermometer();
        t1.setCelsius(10.0);
        System.out.println(t1.getCelsius());
        System.out.println(t1.getFahrenheit()); // 50.0 expected

        Thermometer t2 = new Thermometer();
        t2.setFahrenheit(32.0);
        System.out.println(Thermometer.diffCelsius(t1, t2)); // 10.0 - 0 = 10.0

    }
}
