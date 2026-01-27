package week2.thermometer;

public class ThermometerGemini3Pro {
    // A thermometer keeps track of only one temperature.
    // We will store it internally as Celsius.
    private double currentTempCelsius;

    // Default constructor that sets the thermometer’s temperature to 0 Celsius
    public ThermometerGemini3Pro() {
        this.currentTempCelsius = 0.0;
    }

    // Modification method to set temperature in Celsius
    public void setCelsius(double celsius) {
        this.currentTempCelsius = celsius;
    }

    // Modification method to set temperature in Fahrenheit
    // Converts the Fahrenheit input to Celsius for internal storage
    // Formula: (TempF - 32) * 5/9
    public void setFahrenheit(double fahrenheit) {
        this.currentTempCelsius = (fahrenheit - 32) * 5.0 / 9.0;
    }

    // Accessor method to get current temperature in Celsius
    public double getCelsius() {
        return this.currentTempCelsius;
    }

    // Accessor method to get current temperature in Fahrenheit
    // Formula: TempC * 1.8 + 32
    public double getFahrenheit() {
        return (this.currentTempCelsius * 1.8) + 32;
    }

    // Static method to get difference in Celsius (1st object - 2nd object)
    public static double diffCelsius(ThermometerGemini3Pro t1, ThermometerGemini3Pro t2) {
        return t1.getCelsius() - t2.getCelsius();
    }

    // Static method to get difference in Fahrenheit (1st object - 2nd object)
    public static double diffFahrenheit(ThermometerGemini3Pro t1, ThermometerGemini3Pro t2) {
        return t1.getFahrenheit() - t2.getFahrenheit();
    }
}

// Driver Class to test the week2.thermometer.Thermometer
class ThermometerDriverGemini3Pro {
    public static void main(String[] args) {

        // 1. Create a thermometer object
        ThermometerGemini3Pro t1 = new ThermometerGemini3Pro();

        // 2. Add 10 degrees Celsius to it
        // Since it starts at 0, setting it to 10 acts as adding 10.
        t1.setCelsius(10);

        // 3. Print the Fahrenheit temperature
        System.out.println("week2.thermometer.Thermometer 1 (Fahrenheit): " + t1.getFahrenheit());

        // 4. Create another thermometer object
        ThermometerGemini3Pro t2 = new ThermometerGemini3Pro();

        // 5. Set its temperature to 32 degrees Fahrenheit
        t2.setFahrenheit(32);

        // 6. Print out the temperature difference (in Celsius) between the two
        double difference = ThermometerGemini3Pro.diffCelsius(t1, t2);
        System.out.println("Difference in Celsius (T1 - T2): " + difference);
    }
}