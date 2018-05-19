package parking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import parking.service.IParkingService;

@RestController
public class ParkingApi {

	@Autowired
	IParkingService parkingService;
}
