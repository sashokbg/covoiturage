package bg.alexander.model.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User {
	@Id @GeneratedValue
    private Long id;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date birthDay;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	//TODO change to lazy ? OpenSessionInView ?
	@OneToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="USER_ROLES",
            joinColumns = @JoinColumn( name="USER_ID"),
            inverseJoinColumns = @JoinColumn( name="ROLE_ID")
    )
	private Set<Role> roles;
	
	@Override
	public String toString(){
		return getFirstName()+" - "+getLastName();
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birtDay) {
		this.birthDay = birtDay;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public boolean equals(Object userObject){
		User anotherUser = (User) userObject;
		
		if(anotherUser.getId().equals(this.getId())){
			return true;
		}
		return false;
	}
}
