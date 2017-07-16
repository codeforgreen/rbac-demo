package ro.codeforgreen.rbac.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    
    private String description;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="role_permission",
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="permission_id", referencedColumnName="id")}
    )
    private Collection<Permission> permissions;
    
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
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public String getDescription() {
		return description;
	}
    
    public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
    
    public Collection<Permission> getPermissions() {
		return permissions;
	}
}
