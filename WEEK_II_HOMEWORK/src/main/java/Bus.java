import java.util.UUID;
public class Bus extends Transport implements Opreation, bus_Passenger, Check_status {

    static int count = 0; //인스턴스 갯수
    UUID serialNo = UUID.randomUUID();
    boolean inGarage;

    public Bus(int maxPsg, int fee, int currentPsg, int fuel, int speed) {
        this.maxPsg = maxPsg;
        this.fee = fee;
        this.currentPsg = currentPsg;
        this.fuel = fuel;
        this.speed = speed;
        this.inOperation = true;
        this.hornSound = "뽱뽱!!!";
        this.inGarage = false;
        this.totalRevenue = currentPsg * fee;
    }
    @Override
    public void horn(){
        System.out.println("버스번호: "+serialNo+"이가 경적을 울립니다. "+hornSound);
    }

    @Override
    public void startService() {
        if (fuel >= 10) {
            inOperation = true;}
    }

    @Override
    public void checkFuel() {
        if (fuel < 10) {endService();}
        else {System.out.println("아직 버스"+serialNo+"은는 연료가 "+fuel+"리터 남았습니다");}
    }

    @Override
    public void endService() {
            inOperation = false;
            currentPsg = 0;
            System.out.println("주유량을 확인해주세요");
            System.out.println("버스"+serialNo+"은는 운행을 멈추고 차고지로 돌아갑니다");
    }

    @Override
    public void getIn(int waiting) {
        if (currentPsg < maxPsg && inOperation == true && maxPsg - currentPsg >= waiting) {
        currentPsg += waiting;
        totalRevenue += waiting * fee;
        System.out.println(waiting+"명이 탑승하여 현재 승객은 총 " + currentPsg + "명 입니다.");
        } else if (currentPsg == maxPsg) {
            System.out.println("버스가 가득차 더 이상 탈 수 없습니다.");
        } else if (inOperation == false) {
            System.out.println("버스가 운행중이 아닙니다.");
        } else if (currentPsg != maxPsg && maxPsg - currentPsg < waiting) { totalRevenue = (maxPsg - currentPsg)*fee;
            System.out.println(waiting+"명 중 "+(maxPsg - currentPsg)+"명을 태우고 버스가 가득찼습니다. 다음 버스를 이용해 주시기 바랍니다.");
            currentPsg = maxPsg;
        }
        fuel -= 1;
        checkFuel();
    }

    public void disembark(int gottaOutHeea) {
        if (gottaOutHeea > currentPsg) {currentPsg = 0;
            System.out.println("시공의 폭풍에서 사람들이 흘러나옵니다!");
            System.out.println("버스에서 탄사람보다 많은 사람들이 내립니다.");
            System.out.println("현재 탑승객 수는 "+currentPsg+"명 입니다.");}
        else {currentPsg -= gottaOutHeea;
            System.out.println("총 "+gottaOutHeea+"명이 내려서, 현재 탑승객 수는 "+currentPsg+"명 입니다.");
        }
        fuel -= 1;
        checkFuel();
    }

    @Override
    public void checkStatus() {
        System.out.println("----------------[버스번호: "+serialNo+"]----------------");
        System.out.println("버스요금: "+fee);
        System.out.println("최대 손님수: "+maxPsg);
        System.out.println("현재승객: "+currentPsg);
        System.out.println("주유량: "+fuel);
        System.out.println("현재속도: "+speed);
        System.out.println("운행상태: "+inOperation);
        System.out.println("차고지안: "+inGarage);
        System.out.println("매출합계: "+totalRevenue);
        System.out.println("------------------------------------------------------------------------------");
    }
}
