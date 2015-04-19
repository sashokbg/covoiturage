package bg.alexander.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object roleObject){
		Role anotherRole = (Role) roleObject;
		
		if(anotherRole.getId().equals(this.getId())){
			return true;
		}
		return false;
	}
}
