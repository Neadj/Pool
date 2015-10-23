package resources;

public class BasketPool extends ResourcePool<Basket> {

	public Basket createResource() {
		return new Basket();
	}

	public BasketPool(int nbResource) {
		super(nbResource);
	}

}
