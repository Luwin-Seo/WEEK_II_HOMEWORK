import java.util.UUID;
public class Taxi extends Transport implements Opreation, taxi_Passenger, Check_status {

    UUID serialNo = UUID.randomUUID();
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
        this.inOperation = true;
        this.totalRevenue = 0;
        this.hornSound = "삡- 삡-";
    }
    @Override
    public void horn(){
        System.out.println("택시번호: "+serialNo+"이가 경적을 울립니다. "+hornSound);
    }

    @Override
    public void startService() {
        if (fuel >= distToGo/10000 && inOperation) {
            isOccupied = true;
            System.out.println("운행을 시작합니다. 목적지까지의 거리: "+distToGo+"m");
        } else {
            distToGo = 0;
            currentPsg = 0;
            destination = "";
            System.out.println("목적지까지 가기에 연료가 부족합니다. 연료를 확인해 주세요.");
        }
    }

    @Override
    public void endService() {
        System.out.println("이용해 주셔서 감사합니다.");
        fuel -= (distToGo > 10000) ? distToGo/10000 : 1 ;
        destination = "";
        distToGo = 0;
        totalRevenue += totalFee;
        totalFee = 0;
        isOccupied = false;
        checkFuel();
        System.out.println("현재 총 수입은 "+totalRevenue+"원 입니다.");
    }

    @Override
    public void checkFuel() {
        if (fuel < 1) {stop();}
        else if (fuel < 10) {
            inOperation = false;
            System.out.println("주유가 필요합니다.");
        } else {inOperation = true;
            System.out.println("이 택시의 현재 주유량은 "+fuel+"리터 입니다.");
        }
    }

    @Override
    public void getIn(int waiting, int farToGo, String whereToGo) {
        if (waiting <= maxPsg) {
            currentPsg = waiting;
            destination = whereToGo;
            distToGo = farToGo;
            totalFee = (distToGo <= minFeeDist) ? fee :
                    fee + 200 * (int)((distToGo - minFeeDist) / 151);
            startService();
        }
        else if (waiting > maxPsg) {
            System.out.println("택시 정원 초과입니다");
        }
    }

    @Override
    public void getOut() {
        if (distToGo == 0) {
            System.out.println("출발하지 못했습니다.");
            endService();
        } else {
            System.out.println(destination+"에 도착했습니다. 총 택시 이용요금은 "+totalFee+"원 입니다.");
            currentPsg = 0;
            endService();
        }
    }

    @Override
    public void checkStatus() {
        System.out.println("----------------[택시번호: "+serialNo+"]----------------");
        System.out.println("주유량: "+fuel);
        System.out.println("현재속도: "+speed);
        System.out.println("목적지: "+destination);
        System.out.println("기본요금거리: "+minFeeDist);
        System.out.println("목적지까지의 거리: "+distToGo);
        System.out.println("기본요금: "+fee);
        System.out.println("전체요금: "+totalFee);
        System.out.println("현재승객: "+currentPsg);
        System.out.println("승객탑승: "+isOccupied);
        System.out.println("운행가능: "+inOperation);
        System.out.println("당일총수입: "+totalRevenue);
        System.out.println("------------------------------------------------------------------------------");
    }
}