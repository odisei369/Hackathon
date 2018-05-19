package parking.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Transactional
@Repository
public class VehicleDAOImpl implements IVehicleDAO {

	@PersistenceContext
	EntityManager entityManager;
}
