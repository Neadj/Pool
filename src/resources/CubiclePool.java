package resources;

public class CubiclePool extends ResourcePool<Cubicle> {

	public Cubicle createResource() {
		return new Cubicle();
	}

	public CubiclePool(int nbResource) {
		super(nbResource);
	}

}
