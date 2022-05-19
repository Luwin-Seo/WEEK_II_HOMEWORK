public class GasStation {
    int fuelInventory;
    int pricePerLiter;
    int totalSales;

    public GasStation(int fuelInventory, int pricePerLiter) {
        this.fuelInventory = fuelInventory;
        this.pricePerLiter = pricePerLiter;
    }
    public void reFuel(Taxi taxi, int fuelIn) {
        fuelInventory -= fuelIn;
        totalSales += pricePerLiter * fuelIn;
        taxi.fuel += fuelIn;
        taxi.totalRevenue -= pricePerLiter * fuelIn;
        taxi.checkFuel();

    }
}
