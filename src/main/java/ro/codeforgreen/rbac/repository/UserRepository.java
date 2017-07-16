package ro.codeforgreen.rbac.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ro.codeforgreen.rbac.domain.User;

@RepositoryRestResource(collectionResourceRel="users", path="users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	List<User> findByName(@Param("name") String name);
}
