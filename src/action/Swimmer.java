package action;

import resources.Basket;
import resources.BasketPool;
import resources.Cubicle;
import resources.CubiclePool;
import resources.ResourcefulUser;

/**
 * This action simulates all the actions a Swimmer does while being in the Pool.
 */

public class Swimmer extends SequentialScheduler{
    
    protected String name;
    protected ResourcefulUser<Basket> basketUser = new ResourcefulUser<>();
    protected ResourcefulUser<Cubicle> cubicleUser = new ResourcefulUser<>();

    public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int undressDuration, int swimmingDuration, int dressDuration) {
        this.name = name;
        basketUser = new ResourcefulUser<Basket>();
		cubicleUser = new ResourcefulUser<Cubicle>();
		// Swimmer takes a basket as long as one is available
        actions.add(new TakeResourceAction<Basket>(baskets, basketUser));
        // Swimmer enters in a cubicle as long as one is free
        actions.add(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        // Swimmer is undressing during a set amount of time
        actions.add(new ForseeableAction(undressDuration));
        // Swimmer gets out of the cubicle
        actions.add(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        // Swimmer is swimming during a set amount of time
        actions.add(new ForseeableAction(swimmingDuration));
        // Swimmer enters in a cubicle as long as one is free
        actions.add(new TakeResourceAction<Cubicle>(cubicles, cubicleUser));
        // Swimmer is dressing during a set amount of time
        actions.add(new ForseeableAction(dressDuration));
        // Swimmer gets out of the cubicle
        actions.add(new FreeResourceAction<Cubicle>(cubicles, cubicleUser));
        // Swimmer gives the basket back
        actions.add(new FreeResourceAction<Basket>(baskets, basketUser));
    }
    @Override
    public void reallyDoStep() throws ActionFinishedException, ActionNotInitializedException {
        System.out.println(name + "'s turn");
        System.out.print(name + " ");
        super.reallyDoStep();
    }
}
