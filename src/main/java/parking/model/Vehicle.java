package parking.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_veh;
	
	private Integer capacity;
	
	private Integer status;
	
	@OneToMany(mappedBy="vehicle")
	private List<Arrival> arrivals;
	
	public Vehicle() {
		
	}

	public Integer getId_veh() {
		return id_veh;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getStatus() {
		return status;
	}
	
	
	

}
