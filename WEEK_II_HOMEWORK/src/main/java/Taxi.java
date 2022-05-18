public class Taxi implements Opreation, texi_Passenger, Accelerate, Check_status {

    static int count = 0; //인스턴스 갯수
    int serialNo;

    {
        ++count;
        serialNo = count;
    }

    int fuel;
    int speed;
    String destination = "";
    int minFeeDist;
    int currentPsg;
    int distToGo;
    int minimumFee;
    int totalFee;
    boolean isOccupied;

    public Taxi(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
        this.minFeeDist = 3000;
        this.minimumFee = 6500;
        this.isOccupied = false;
    }

    @Override
    public void startOperation() {
        if (fuel >= 10) {
            isOccupied = true;
            System.out.println("운행을 시작합니다. 목적지까지의 거리: "+distToGo+"m");
        } else {
            distToGo = 0;
            currentPsg = 0;
            destination = "";
            System.out.println("연료를 확인해 주세요.");
        }
    }

    @Override
    public void endOperation() {
        System.out.println("이용해 주셔서 감사합니다.");
        destination = "";
        distToGo = 0;
        isOccupied = false;
    }

    @Override
    public void getIn(int waiting, int farToGo, String whereToGo) {
        if (waiting <= 4) {
            currentPsg = waiting;
            destination = whereToGo;
            distToGo = farToGo;
            startOperation();

        }
        else if (waiting > 4) {
            System.out.println("택시 정원 초과입니다");
        }
    }

    @Override
    public void getOut() {
        if (distToGo == 0) {
            System.out.println("출발하지 못했습니다.");
            endOperation();
        } else {
            totalFee = minimumFee + 200 * (int)((distToGo - minFeeDist) / 151);
            System.out.println(destination+"에 도착했습니다. 총 택시 이용요금은 "+totalFee+"원 입니다.");
            currentPsg = 0;
            endOperation();
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

    @Override
    public void checkStatus() {
        System.out.println("-----------[택시번호: "+serialNo+"]-----------");
        System.out.println("주유량: "+fuel);
        System.out.println("현재속도: "+speed);
        System.out.println("목적지: "+destination);
        System.out.println("기본요금거리: "+minFeeDist);
        System.out.println("목적지까지의 거리: "+distToGo);
        System.out.println("기본요금: "+minimumFee);
        System.out.println("현재승객: "+currentPsg);
        System.out.println("운행상태: "+isOccupied);
    }
}