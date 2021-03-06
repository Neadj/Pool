package resources;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	public ResourcePool<Cubicle> createResourcePool(int nbResource) {
		return new CubiclePool(nbResource);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
