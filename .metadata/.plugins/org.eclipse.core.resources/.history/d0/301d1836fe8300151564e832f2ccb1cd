<<<<<<< HEAD:Action/src/resources/ResourcePool.java
package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;;

public abstract class ResourcePool<T extends Resource> {
	protected List<T> availableResources = new ArrayList<T>();
	protected List<T> givenResources = new ArrayList<T>();

	public abstract T createResource();

	public ResourcePool(int nbResource) {
		for (int i = 0; i < nbResource; i++)
			this.availableResources.add(createResource());
	}

	public T provideResource() throws NoSuchElementException {
		if (availableResources.isEmpty())
			throw new NoSuchElementException("We don't have this resource.");
		T resource = availableResources.remove(0);
		givenResources.add(resource);
		return resource;
	}

	public void freeResource(T resource) throws IllegalArgumentException {
		if (!givenResources.contains(resource))
			throw new IllegalArgumentException("You didn't lend this resource.");
		givenResources.remove(resource);
		availableResources.add(resource);
	}
=======
package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;;

public abstract class ResourcePool<T extends Resource> {
	protected List<T> availableResources = new ArrayList<T>();
	protected List<T> givenResources = new ArrayList<T>();

	public boolean ressourceIsUnavailable(T resource) {
		return givenResources.contains(resource);
	}

	public boolean ressourceIsAvailable(T resource) {
		return availableResources.contains(resource);
	}

	public abstract T createResource();

	public ResourcePool(int nbResource) {
		for (int i = 0; i < nbResource; i++)
			this.availableResources.add(createResource());
	}

	public T provideResource() throws NoSuchElementException {
		if (availableResources.isEmpty())
			throw new NoSuchElementException("We don't have this resource.");
		T resource = availableResources.remove(0);
		givenResources.add(resource);
		return resource;
	}

	public void freeResource(T resource) throws IllegalArgumentException {
		if (!givenResources.contains(resource))
			throw new IllegalArgumentException("You didn't lend this resource.");
		givenResources.remove(resource);
		availableResources.add(resource);
	}
>>>>>>> refs/remotes/Neadj/master:src/resources/ResourcePool.java
}