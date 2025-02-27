package restjava16.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import restjava16.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
