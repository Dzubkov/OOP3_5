package sample.transport.engine;

public class LightEngine implements Engine {
    private static Engine engine;

    private LightEngine() {

    }

    public static Engine getEngine() {
        if (engine != null)
            return engine;
        engine = new LightEngine();
        return engine;
    }

    @Override
    public String getSpeed() {
        return "10";
    }
}
