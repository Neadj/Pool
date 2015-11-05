package resources;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Override
	public ResourcePool<Basket> createResourcePool(int nbResource) {
		return new BasketPool(nbResource);
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}

}
