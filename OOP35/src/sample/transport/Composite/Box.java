package sample.transport.Composite;

public class Box implements Order{
    Order[] thing;

    public Box(Order[] thing){
        this.thing = thing;
    }

    @Override
    public int getCount() {
        int res = 0;
        for (int i = 0; i < thing.length; i++) {
            res += thing[i].getCount();
        }
        return res;
    }
}
