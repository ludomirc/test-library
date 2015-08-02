/*
 * Created on 02-Feb-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package resources;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

public class ResourceExtent {

    private static Map<String, Resource> resources = new Hashtable<String, Resource>();
    private static int idCounter = 0;
    public static ResourceExtent INSTANCE = new ResourceExtent();


    private ResourceExtent() {
        // Initialise and register loans.library resources
        createResource(ResourceFactory.getResourceInstance("Book", "Lord of the Rings", "J.R.Tolkien"));
        createResource(ResourceFactory.getResourceInstance("Book", "2001 Space Odessey", "Arthur C Clarke"));
        createResource(ResourceFactory.getResourceInstance("Book", "How to win at bingo", "Two fat ladies"));
        createResource(ResourceFactory.getResourceInstance("Book", "The Cold. Don't let it kill you.", "J.R.Hartley"));
        createResource(ResourceFactory.getResourceInstance("Game", "Halo", "X-Box"));
        createResource(ResourceFactory.getResourceInstance("Game", "Midtown madness", "PS2"));
    }

    public void createResource(Resource resource) {
        resource.setId(getNextId());
        resources.put(resource.getId(), resource);
    }

    public Resource findByPrimaryKey(String id) {
        return resources.get(id);
    }

    public Collection<Resource> getResources() {
        return resources.values();
    }

    public String getNextId() {
        return "R" + (idCounter++);
    }
}
