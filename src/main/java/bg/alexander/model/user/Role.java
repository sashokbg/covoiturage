package bg.alexander.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ROLES")
public class Role {
	@Id @GeneratedValue
	private Long id;
	@NotNull @Size(min=3,max=15)
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
	public boolean equals(Object anotherRoleObj){
		if(anotherRoleObj==null)
			return false;
		Role anotherRole = (Role) anotherRoleObj;
		if(this.getId() != null && anotherRole.getId() !=null){
			if(anotherRole.getId().equals(this.getId())){
				return true;
			}
		}
		
		return false;
	}
}
