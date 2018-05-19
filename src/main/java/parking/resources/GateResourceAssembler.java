package parking.resources;

import org.springframework.stereotype.Component;

import parking.model.Gate;

@Component
public class GateResourceAssembler extends ResourceAssembler<Gate, GateResource> {

	@Override
	public GateResource toResource(Gate model) {
		return new GateResource(model);
	}

}
