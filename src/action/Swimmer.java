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
        actions.add(new TakeResourceAction(baskets, basketUser));
        actions.add(new TakeResourceAction(cubicles, cubicleUser));
        actions.add(new ForseeableAction(undressDuration));
        actions.add(new FreeResourceAction(cubicles, cubicleUser));
        actions.add(new ForseeableAction(swimmingDuration));
        actions.add(new TakeResourceAction(cubicles, cubicleUser));
        actions.add(new ForseeableAction(dressDuration));
        actions.add(new FreeResourceAction(cubicles, cubicleUser));
        actions.add(new FreeResourceAction(baskets, basketUser));
    }
    @Override
    public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
        System.out.println(name + "'s turn");
        System.out.print(name + " ");
        super.reallyDoStep();
    }
}
