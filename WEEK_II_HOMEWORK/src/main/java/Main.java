public class Main {
    public static void main(String[] args){

       Taxi taxi1 = new Taxi(60,40);
       taxi1.getIn(3,4000,"내 마음속");
       taxi1.getOut();
       taxi1.checkStatus();
       taxi1.getIn(4,100000,"가평");
       taxi1.getOut();
       taxi1.checkStatus();
       taxi1.getIn(4,80000, "태백");
       taxi1.getOut();
       taxi1.checkStatus();
       taxi1.getIn(3,10000,"강릉");
       taxi1.getOut();
       taxi1.checkStatus();
       GasStation gasStation = new GasStation(1000000, 2000);
       gasStation.reFuel(taxi1, 70);

    }
}
