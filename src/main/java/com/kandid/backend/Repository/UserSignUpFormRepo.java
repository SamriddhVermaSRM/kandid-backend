package com.kandid.backend.Repository;

import com.kandid.backend.Model.UserSignUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSignUpFormRepo extends JpaRepository<UserSignUpForm, Integer> {
}
