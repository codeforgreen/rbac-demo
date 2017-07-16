package ro.codeforgreen.rbac.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    
    private String email;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="user_role",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private Collection<Role> roles;
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public Long getId() {
		return id;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getName() {
		return name;
	}
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getEmail() {
		return email;
	}
    
    public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    
    public Collection<Role> getRoles() {
		return roles;
	}
}
