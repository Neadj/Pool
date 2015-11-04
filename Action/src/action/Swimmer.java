package action;

import resources.BasketPool;
import resources.CubiclePool;

public class Swimmer extends Action {

    protected String name;
    protected BasketPool baskets;

    public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int undressDuration, int swimmingDuration, int dressDuration) {
        baskets = new BasketPool(0);
        this.name = name;
    }

    @Override
    public boolean isReady() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFinished() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void reallyDoStep() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
