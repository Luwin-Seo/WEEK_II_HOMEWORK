public class Taxi implements Opreation, texi_Passenger, Accelerate {

    static int count = 0; //인스턴스 갯수
    int serialNo;

    {
        ++count;
        serialNo = count;
    }

    int fuel;
    int speed;
    int minFeeDist;
    int currentPsg;
    int distToGo;
    int minimumFee;
    int totalFee;
    boolean isOccupied;

    public Taxi(int fuel, int speed, int minimumFee) {
        this.fuel = fuel;
        this.speed = speed;
        this.minFeeDist = 3000;
        this.currentPsg = 0;
        this.distToGo = 0;
        this.minimumFee = 6500;
        this.isOccupied = false;
    }

    @Override
    public void startOperation() {
        if (fuel >= 10) {
            isOccupied = true;
        } else {
            System.out.println("연료를 확인해 주세요.");
        }
        currentPsg = 0;
    }

    @Override
    public void endOperation() {
        System.out.println("목적지에 도착하였습니다.");
        distToGo = 0;
        isOccupied = false;
    }

    @Override
    public void getIn(int waiting, int wantToGo) {
        if (waiting < 4) {currentPsg = waiting; distToGo = wantToGo;}
        else if (waiting == 5) {
            System.out.println("택시 정원 초과입니다");
        }
    }

    @Override
    public void getOut() {
        totalFee = minimumFee + 200 * (int) (distToGo - minFeeDist) / 151;
        currentPsg = 0;
        endOperation();
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