public class Bus implements Opreation, Passenger, Accelerate {

    static int count = 0; //인스턴스 갯수
    int serialNo;
    {
        ++count;
        serialNo = count;
    }
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
        if (fuel < 10) {
            inOperation = false;
        } else {
            System.out.println("주유량을 확인해주세요");
            System.out.println("운행을 멈추고 차고지로 돌아갑니다");
        }
    }

    @Override
    public void getIn(int waiting) {
        if (currentPsg < maxPsg && inOperation == true && maxPsg - currentPsg >= waiting) {
        currentPsg += waiting;
        System.out.println(waiting+"명이 탑승하여 현재 승객은 총 " + currentPsg + "명 입니다.");
        } else if (currentPsg == maxPsg) {
            System.out.println("버스가 가득차 더 이상 탈 수 없습니다.");
        } else if (inOperation == false) {
            System.out.println("버스가 운행중이 아닙니다.");
        } else if (currentPsg != maxPsg && maxPsg - currentPsg < waiting) {
            System.out.println(waiting+"명 중 "+(maxPsg - currentPsg)+"명을 태우고 버스가 가득찼습니다. 다음 버스를 이용해 주시기 바랍니다");
            currentPsg = maxPsg;
        }
    }

    @Override
    public void changeSpeed(int acceleration) {
        speed += acceleration;
        if (acceleration > 0) {
            System.out.println("가속합니다. 현재 속도는 " + speed + "입니다.");
        } else if (acceleration < 0) {
            System.out.println("감속합니다. 현재 속도는 " + speed + "입니다.");
        }
    }
}
