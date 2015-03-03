package bg.alexander.model.project;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import bg.alexander.model.user.User;
import bg.alexander.model.validation.ValidProject;

@Entity
@ValidProject
public class Project {
	//TODO change to long
	@Id @GeneratedValue
	private Integer id;
	@Min(2)
	private String name;
	
	private String code;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date start;
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
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
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "TASK",
			inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private Set<Task> tasks;
	
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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
