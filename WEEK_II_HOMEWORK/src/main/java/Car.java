abstract class Car {
    int fuel;
    int speed;
    int maxPsg;
    int currentPsg;
    int fee;

    public void changeSpeed(int acceleration) {
        speed += acceleration;
        if (acceleration > 0) {
            System.out.println("가속합니다. 현재 속도는 " + speed + "입니다.");
        } else if (acceleration < 0) {
            System.out.println("감속합니다. 현재 속도는 " + speed + "입니다.");
        }
    }

}

