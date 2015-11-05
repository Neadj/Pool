<<<<<<< HEAD:Action/src/action/Swimmer.java
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
=======
package action;

import resources.Basket;
import resources.BasketPool;
import resources.Cubicle;
import resources.CubiclePool;
import resources.ResourcefulUser;

public class Swimmer extends SequentialScheduler{
    
    protected String name;
    protected ResourcefulUser<Basket> basketUser = new ResourcefulUser<>();
    protected ResourcefulUser<Cubicle> cubicleUser = new ResourcefulUser<>();

    public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int undressDuration, int swimmingDuration, int dressDuration) {
        this.name = name;
        basketUser = new ResourcefulUser<Basket>();
		cubicleUser = new ResourcefulUser<Cubicle>();
        actions.add(new TakeResourceAction<Basket>(baskets, basketUser));
        actions.add(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        actions.add(new ForseeableAction(undressDuration));
        actions.add(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        actions.add(new ForseeableAction(swimmingDuration));
        actions.add(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        actions.add(new ForseeableAction(dressDuration));
        actions.add(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        actions.add(new FreeResourceAction<Basket>(baskets, basketUser));
    }
    @Override
    public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
        System.out.println(name + "'s turn");
        System.out.print(name + " ");
        super.reallyDoStep();
    }
}
>>>>>>> refs/remotes/Neadj/master:src/action/Swimmer.java
