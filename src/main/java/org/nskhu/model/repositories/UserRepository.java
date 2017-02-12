package org.nskhu.model.repositories;

import org.nskhu.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);

}
