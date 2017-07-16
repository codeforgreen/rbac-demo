package ro.codeforgreen.rbac.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ro.codeforgreen.rbac.domain.Permission;

@RepositoryRestResource(collectionResourceRel="permissions", path="permissions")
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
	List<Permission> findByName(@Param("name") String name);
}
