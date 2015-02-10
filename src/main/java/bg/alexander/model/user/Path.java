package bg.alexander.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATH")
public class Path {
	@Id @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "start_point")
	private String startPoint;
	
	@Column(name = "end_point")
	private String endPoint;

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endtPoint) {
		this.endPoint = endtPoint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
}
