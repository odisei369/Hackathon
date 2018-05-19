package parking.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="Arrivals")
public class Arrival {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer arrival_id;
	
	private Timestamp arrival_time;
	
	private Boolean loading;
	private Boolean unloading;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="gate_no")
	private Gate gate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id_veh")
	private Vehicle vehicle;

	public Integer getArrival_id() {
		return arrival_id;
	}

	public Timestamp getArrival_time() {
		return arrival_time;
	}

	public Boolean getLoading() {
		return loading;
	}

	public Boolean getUnloading() {
		return unloading;
	}

	public Gate getGate() {
		return gate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	

}
