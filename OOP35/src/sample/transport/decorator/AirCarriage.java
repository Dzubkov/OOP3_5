package sample.transport.decorator;

public class AirCarriage implements CarriageBaggage {

    @Override
    public void carriage() {
        System.out.println("Air transport carries baggage");
    }
}
