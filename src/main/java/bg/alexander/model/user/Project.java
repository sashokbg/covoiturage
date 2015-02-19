package bg.alexander.model.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
	//TODO move to different package
	
	//TODO change to long
	@Id @GeneratedValue
	private Integer id;
	private String name;
	private Date start;
	private Date end;
	@OneToOne
	private User creator;
	@OneToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="PROJECT_USERS",
            joinColumns = @JoinColumn( name="PROJECT_ID"),
            inverseJoinColumns = @JoinColumn( name="USER_ID")
    )
	private Set<User> assignedUsers;
	
	public Project() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<User> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(Set<User> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}
}
