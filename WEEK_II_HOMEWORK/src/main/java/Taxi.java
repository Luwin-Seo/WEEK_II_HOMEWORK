public class Taxi extends Transport implements Opreation, taxi_Passenger, Check_status {

    static int count = 0; //인스턴스 갯수
    int serialNo;

    {
        ++count;
        serialNo = count;
    }

    String destination = "";
    int minFeeDist;
    int distToGo;
    int totalFee;
    boolean isOccupied;

    public Taxi(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
        this.minFeeDist = 3000;
        this.maxPsg = 4;
        this.fee = 6500;
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
        totalFee = 0;
        isOccupied = false;
    }

    @Override
    public void getIn(int waiting, int farToGo, String whereToGo) {
        if (waiting <= maxPsg) {
            currentPsg = waiting;
            destination = whereToGo;
            distToGo = farToGo;
            totalFee = (distToGo <= minFeeDist) ? fee :
                    fee + 200 * (int)((distToGo - minFeeDist) / 151);
            startOperation();
        }
        else if (waiting > maxPsg) {
            System.out.println("택시 정원 초과입니다");
        }
    }

    @Override
    public void getOut() {
        if (distToGo == 0) {
            System.out.println("출발하지 못했습니다.");
            endOperation();
        } else {
            System.out.println(destination+"에 도착했습니다. 총 택시 이용요금은 "+totalFee+"원 입니다.");
            currentPsg = 0;
            endOperation();
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
        System.out.println("기본요금: "+fee);
        System.out.println("전체요금: "+totalFee);
        System.out.println("현재승객: "+currentPsg);
        System.out.println("운행상태: "+isOccupied);
        System.out.println("----------------------------------");
    }
}