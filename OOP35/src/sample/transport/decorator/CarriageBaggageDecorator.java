package sample.transport.decorator;

public class CarriageBaggageDecorator implements CarriageBaggage {
    CarriageBaggage wrap;

    public CarriageBaggageDecorator(CarriageBaggage сarriageBaggage) {
        this.wrap = сarriageBaggage;
    }

    @Override
    public void carriage() {
        wrap.carriage();
    }
}
