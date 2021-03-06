package resources;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public abstract class ResourcePoolTest<T extends Resource> {
	abstract public ResourcePool<T> createResourcePool(int nbResource);
	abstract public T createResource();
	protected ResourcePool<T> resourcePool;
	
	final int nbResource = 10;
	
	@Before
	public void init(){
		this.resourcePool = createResourcePool(nbResource);
	}
	
	@Test
	public void provideAndFreeResourceTest(){
		T resource = resourcePool.provideResource();
		resourcePool.freeResource(resource);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void NotEnoughResource(){
		List<T> resources = new ArrayList<T>();
		for(int i = 0; i < nbResource; i++)
			resources.add(resourcePool.provideResource());
		resourcePool.provideResource();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void freeTypeError() throws InstantiationException, IllegalAccessException{
		resourcePool.provideResource();
		resourcePool.freeResource(createResource());
	}
}
