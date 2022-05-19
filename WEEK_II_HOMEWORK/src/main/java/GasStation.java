public class GasStation {
    int fuelInventory;
    int pricePerLiter;
    int totalSales;

    public GasStation(int fuelInventory, int pricePerLiter) {
        this.fuelInventory = fuelInventory;
        this.pricePerLiter = pricePerLiter;
    }
    public void reFuel(Taxi taxi, int fuelIn) {
        if (taxi.fuel + fuelIn > 70) {
            fuelInventory -= 70-taxi.fuel;  taxi.totalRevenue -= pricePerLiter*(70- taxi.fuel);
            System.out.println("택시의 연료탱크 용량 70리터까지 만땅으로 채웁니다.");
            System.out.println("총 주유비는 "+pricePerLiter*(70- taxi.fuel)+"원 입니다.");
            taxi.fuel = 70;
            System.out.println("이 택시의 현재 연료량은 "+taxi.fuel+"입니다.");

        }
        else {
        fuelInventory -= fuelIn;
        totalSales += pricePerLiter * fuelIn;
        taxi.fuel += fuelIn;
        taxi.totalRevenue -= pricePerLiter * fuelIn;
        System.out.println(taxi.serialNo+"에 연료를 "+fuelIn+"리터 주유했습니다. 총 주유비는 "+pricePerLiter * fuelIn+"원 입니다.");
        taxi.checkFuel();}
    }
}
