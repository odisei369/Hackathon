package parking.dao;

import javax.transaction.Transactional;
import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class GateDAOImpl implements IGateDAO {
	
	@PersistenceContext
	EntityManager entityManager;

}
