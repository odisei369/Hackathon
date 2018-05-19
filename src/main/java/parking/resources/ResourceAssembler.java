package parking.resources;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ResourceAssembler <ModelType, ResourceType>{
	
	public abstract ResourceType toResource(ModelType model);
	
	public Collection<ResourceType> toResourceCollection(Collection<ModelType> modelCollection) {
		return modelCollection.stream().map( mod -> toResource(mod)).collect(Collectors.toList());
	}

}
