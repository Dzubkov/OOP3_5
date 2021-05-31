package sample.transport.decorator;

public class WaterCarriage implements CarriageBaggage {

    @Override
    public void carriage() {
        System.out.println("Water transport carries baggage");
    }
}
