package com.kandid.backend.Repository;

import com.kandid.backend.Model.ContactUsForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsFromRepo extends JpaRepository<ContactUsForm, Integer> {
}
