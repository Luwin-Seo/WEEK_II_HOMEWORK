public class Bus implements Opreation, Passenger, Accelerate {

    static int count =0; //인스턴스 갯수
    int serialNo; {++count; serialNo = count;}
    int maxPsg;
    int fee;
    int currentPsg;
    int fuel;
    int speed;
    boolean inOperation;

    public Bus(int maxPsg, int fee, int currentPsg, int fuel, int speed) {
        this.maxPsg = maxPsg;
        this.fee = fee;
        this.currentPsg = currentPsg;
        this.fuel = fuel;
        this.speed = speed;
        this.inOperation = true;
    }

    @Override
    public void endOperation() {
        if (fuel < 10) {inOperation = false;}
        else {System.out.println("주유량을 확인해주세요");}}

    @Override
    public void getIn() {
        if (currentPsg < maxPsg && inOperation == true ) currentPsg++;}

    @Override
    public void changeSpeed(int acceleration) {
        speed += acceleration;
    }
}
