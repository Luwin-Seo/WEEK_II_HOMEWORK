abstract class Transport {
    int fuel;
    int speed;
    int maxPsg;
    int currentPsg;
    int fee;
    boolean inOperation;
    String hornSound;
    int totalRevenue;

    public void changeSpeed(int acceleration) {
        speed += acceleration;
        if (acceleration > 0) {
            System.out.println("가속합니다. 현재 속도는 " + speed + "입니다.");
        } else if (acceleration < 0) {
            System.out.println("감속합니다. 현재 속도는 " + speed + "입니다.");
        }
    }

    public void horn() {
        System.out.println(hornSound);
    }

    public void stop() {
        if (fuel <= 0) {
            System.out.println("금일 운행이 중단되었 습니다. 견인조치가 필요합니다.");
        }
    }

}

