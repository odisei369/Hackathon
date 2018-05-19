package parking.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Gates")
public class Gate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer gate_no;
	
	private Boolean status;
	
	@OneToMany(mappedBy="gate")
	private List<Arrival> arrivals;
	
	public Gate() {
		
	}

	public Integer getGate_no() {
		return gate_no;
	}

	public Boolean getStatus() {
		return status;
	}
	
	
	
}
