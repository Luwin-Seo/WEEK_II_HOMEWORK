public class BusGarage {

        int fuelInventory;
        int busInGarage;

    public BusGarage(int fuelInventory) {
        this.fuelInventory = fuelInventory;
        this.busInGarage = 0;
    }

    public void busArrival(Bus bus) {
            if (bus.inOperation = false) {
                System.out.println("버스번호 "+ bus.serialNo+"가 차고지로 들어옵니다.");
                bus.inGarage = true;
                busInGarage++;
                fuelInventory -= 200;
                bus.fuel = 200;
            }
        }
}
