package parking.resources;

import org.springframework.stereotype.Component;

import parking.model.Arrival;

@Component
public class ArrivalResourceAssembler extends ResourceAssembler<Arrival,ArrivalResource> {

	@Override
	public ArrivalResource toResource(Arrival arrival) {
		return new ArrivalResource(arrival);
	}

}
