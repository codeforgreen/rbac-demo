package ro.codeforgreen.rbac;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ro.codeforgreen.rbac.domain.Role;
import ro.codeforgreen.rbac.domain.User;
import ro.codeforgreen.rbac.repository.PermissionRepository;
import ro.codeforgreen.rbac.repository.RoleRepository;
import ro.codeforgreen.rbac.repository.UserRepository;

@SpringBootApplication
public class RbacApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbacApplication.class, args);
    }
    
    @Bean
    public InitializingBean initialize() {
    		return new InitializingBean() {
    			@Autowired
    			private UserRepository userRepository;
    			@Autowired
    			private RoleRepository roleRepository;
    			@Autowired
    			private PermissionRepository permissionRepository;
    			
    			public void afterPropertiesSet() throws Exception {
    				User user1 = addUser("User1", "user1@gmail.com");
    				addUser("User2", "user1@gmail.com");
    				
    				Role adminRole = addRole("admin");
    				addRole("guest");
    			}
    			
    			private User addUser(String name, String email) {
    				User user = new User();
    				user.setName(name);
    				user.setEmail(email);
    				return userRepository.save(user);
    			}
    			
    			private Role addRole(String name) {
    				Role role = new Role();
    				role.setName(name);
    				return roleRepository.save(role);
    			}
		};
    }
    
}
