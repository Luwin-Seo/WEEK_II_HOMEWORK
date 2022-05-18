public class Main {
    public static void main(String[] args){

       Taxi taxi1 = new Taxi(100,40);
       taxi1.getIn(1,8000,"내 마음속");
       taxi1.checkStatus();
       taxi1.getOut();
       taxi1.checkStatus();
       Bus bus1 = new Bus(48,1300,20,30,40);
       bus1.checkStatus();
       Bus bus2 = new Bus(25,1000,10,30,20);
       bus2.checkStatus();
       Taxi taxi2 = new Taxi(20,60);
       taxi2.getIn(3,2500, "니 마음속");
       taxi2.checkStatus();

    }
}
