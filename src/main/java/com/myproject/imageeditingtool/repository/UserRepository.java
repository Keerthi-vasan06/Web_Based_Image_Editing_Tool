package com.myproject.imageeditingtool.repository;




import com.myproject.imageeditingtool.entity.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//  User Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // Starts with (e.g., "Jo" -> John, Joseph)
    List<User> findByUsernameStartingWith(String prefix);

    // Ends with (e.g., "son" -> Jackson, Anderson)
    List<User> findByUsernameEndingWith(String suffix);


    List<User> findByUsernameContains(String username);

    List<User> findByUsernameContaining(String username);

    List<User> findByUsernameNotContaining(String username);
}