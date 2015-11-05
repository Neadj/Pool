package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;;

public abstract class ResourcePool<T extends Resource> {
	protected List<T> availableResources = new ArrayList<T>();
	protected List<T> givenResources = new ArrayList<T>();

	/**
	 * Return if an object has been given before.
	 * @param resource
	 * @return : Boolean. If an object has been given before, return true, else, return false.
	 */
	public boolean ressourceIsUnavailable(T resource) {
		return givenResources.contains(resource);
	}
	
	/**
	 * Return if an object is available.
	 * @param resource
	 * @return : Boolean. If a resource is available, return true, else, return false.
	 */
	public boolean ressourceIsAvailable(T resource) {
		return availableResources.contains(resource);
	}

	/**
	 * This function should be implements in sub-class.
	 * @return : Return an object inherit from Resource.
	 */
	public abstract T createResource();

	public ResourcePool(int nbResource) {
		for (int i = 0; i < nbResource; i++)
			this.availableResources.add(createResource());
	}

	/**
	 * Provide an object inherit from Resource. 
	 * @return : Return an object inherit from Resource.
	 * @throws NoSuchElementException : If we have no more resource, raise an exception.
	 */
	public T provideResource() throws NoSuchElementException {
		if (availableResources.isEmpty())
			throw new NoSuchElementException("We don't have this resource.");
		T resource = availableResources.remove(0);
		givenResources.add(resource);
		return resource;
	}

	/**
	 * Return a object that provided before.
	 * @param resource : The object that will be return.
	 * @throws IllegalArgumentException : If the object that user returns isn't the object provided before, this exception will be raised.
	 */
	public void freeResource(T resource) throws IllegalArgumentException {
		if (!givenResources.contains(resource))
			throw new IllegalArgumentException("You didn't lend this resource.");
		givenResources.remove(resource);
		availableResources.add(resource);
	}
}