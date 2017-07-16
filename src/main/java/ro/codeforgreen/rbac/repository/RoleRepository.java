package ro.codeforgreen.rbac.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ro.codeforgreen.rbac.domain.Role;

@RepositoryRestResource(collectionResourceRel="roles", path="roles")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	List<Role> findByName(@Param("name") String name);
}
