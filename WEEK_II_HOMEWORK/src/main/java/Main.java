public class Main {
    public static void main(String[] args){

       Taxi taxi1 = new Taxi(100,40);
       taxi1.getIn(5,8000,"내 마음속");
       taxi1.checkStatus();
       Bus bus1 = new Bus(48,1300,20,30,40);
       bus1.checkStatus();
    }
}
