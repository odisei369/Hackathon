package parking.dao;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ArrivalDAOImpl implements IArrivalDAO {
	
	@PersistenceContext
	EntityManager entityManager;

}
