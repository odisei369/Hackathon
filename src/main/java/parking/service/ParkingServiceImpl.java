package parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parking.dao.*;

@Service
public class ParkingServiceImpl implements IParkingService {
	
	@Autowired
	ArrivalDAOImpl arrivalDAO;
	
	@Autowired
	GateDAOImpl gateDAO;
	
	@Autowired
	VehicleDAOImpl vehicleDAO;

}
