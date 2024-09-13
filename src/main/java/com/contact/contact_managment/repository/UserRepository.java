package com.contact.contact_managment.repository;

import com.contact.contact_managment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
