package by.powerline.repzone.repository;

import by.powerline.repzone.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 21.02.2018 1:17
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
