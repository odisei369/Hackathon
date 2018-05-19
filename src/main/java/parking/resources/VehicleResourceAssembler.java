package parking.resources;

import org.springframework.stereotype.Component;

import parking.model.Vehicle;

@Component
public class VehicleResourceAssembler extends ResourceAssembler <Vehicle, VehicleResource> {

	@Override
	public VehicleResource toResource(Vehicle model) {
		
		return new VehicleResource(model);
	}

}
