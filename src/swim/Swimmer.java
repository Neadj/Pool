package swim;

import resources.BasketPool;

public class Swimmer {
	protected String name;
	protected BasketPool baskets;

	public Swimmer(String name) {
		baskets = new BasketPool(0);
		this.name = name;
	}

}
