package sample.transport.decorator;

public class CarriageBaggageDecorator implements CarriageBaggage {
    CarriageBaggage wrap;

    public CarriageBaggageDecorator(CarriageBaggage carriageBaggage) {
        this.wrap = carriageBaggage;
    }

    @Override
    public void carriage() {
        wrap.carriage();
    }
}
