package week2.thermometer;

/**
 * Class to represent a simple thermometer with Celsius and Fahrenheit interfaces.
 * @author Mikhail Grazhdanov
 */
public class Thermometer {

    /* Field to store temperature in Celsius */
    private double tempC;

    /**
     * Constructor to initialize week2.thermometer.Thermometer with 0.0 Celsius.
     */
    public Thermometer() {
        this.tempC = 0.0;
    }

    /**
     * Updates temperature by given degrees in Celsius.
     * @param tempC amount in C for which temperature should be adjusted
     */
    public void setCelsius(double tempC) {
        this.tempC = this.tempC + tempC;
    }

    /**
     * Updates temperature by given degrees in Fahrenheit.
     * @param tempF amount in F for which temperature should be adjusted
     */
    public void setFahrenheit(double tempF) {
        this.tempC = this.tempC + toC(tempF);
    }

    /**
     * Retrieves temperature in Celsius.
     * @return temperature in Celsius.
     */
    public double getCelsius() {
        return this.tempC;
    }

    /**
     * Retrieves temperature in Fahrenheit.
     * @return temperature in Fahrenheit.
     */
    public double getFahrenheit() {
        return toF(this.tempC);
    }

    /**
     * Calculate temp difference in Celsius between two Thermometers.
     * @param t1 week2.thermometer.Thermometer 1
     * @param t2 week2.thermometer.Thermometer 2
     * @return difference in C between two Thermometers
     */
    public static double diffCelsius(Thermometer t1, Thermometer t2) {
        return t1.getCelsius() - t2.getCelsius();
    }

    /**
     * Calculate temp difference in Fahrenheit between two Thermometers.
     * @param t1 week2.thermometer.Thermometer 1
     * @param t2 week2.thermometer.Thermometer 2
     * @return difference in F between two Thermometers
     */
    public static double diffFahrenheit(Thermometer t1, Thermometer t2) {
        return t1.getFahrenheit() - t2.getFahrenheit();
    }

    /**
     * Convert Celsius to Fahrenheit.
     * @param celsius Temperature in C to be converted
     * @return Temperature in Fahrenheit.
     */
    private double toF(double celsius) {
        return celsius * 1.8 + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * @param fahrenheit Temperature in F to be converted.
     * @return Temperature in Celsius.
     */
    private double toC(double fahrenheit) {
        return (fahrenheit - 32.0) * 5 / 9;
    }
}
