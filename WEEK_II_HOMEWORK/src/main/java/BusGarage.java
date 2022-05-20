public class BusGarage {
    int fuelInventory;
    int busInGarage;

    public BusGarage(int fuelInventory, int busInGarage) {
        this.fuelInventory = fuelInventory;
        this.busInGarage = busInGarage;
    }
    public void busArrival(Bus bus) {
        if (bus.inOperation == false) {
            System.out.println("버스번호 "+bus.serialNo+"가 차고로 진입합니다.");
            fuelInventory -= 200-bus.fuel;
            bus.fuel = 200;
            System.out.println("버스번호 "+bus.serialNo+"를 재급유 및 정비했습니다.");
            busInGarage++;
        }
        else {
            System.out.println("버스번호 "+bus.serialNo+"는 아직 운행중입니다.");
        }
    }

    public void busDeparture(Bus bus) {
        if (bus.fuel >= 10) {
        busInGarage--;
        System.out.println("버스번호 "+bus.serialNo+"가 차고지를 떠납니다.");
        bus.startService();}

    }

    public void busDeparture(){
        busInGarage--;
    }
}
