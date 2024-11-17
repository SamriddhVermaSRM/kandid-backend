package com.kandid.backend.Service;

import com.kandid.backend.Model.ContactUsForm;
import com.kandid.backend.Model.UserSignUpForm;
import com.kandid.backend.Repository.ContactUsFromRepo;
import com.kandid.backend.Repository.UserSignUpFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private UserSignUpFormRepo _userSignUpFormRepo;

    @Autowired
    private ContactUsFromRepo _contactUsFromRepo;

    @Override
    public ContactUsForm getContactUsForm(int id) {
        return _contactUsFromRepo.findById(id).isPresent() ?
             _contactUsFromRepo.findById(id).get() : null;
    }

    @Override
    public List<ContactUsForm> getContactUsForms() {
        return _contactUsFromRepo.findAll();
    }

    @Override
    public ContactUsForm saveContactUsForm(ContactUsForm contactUsForm) {
        return _contactUsFromRepo.save(contactUsForm);
    }

    @Override
    public void deleteContactUsForm(ContactUsForm form) {
        _contactUsFromRepo.delete(form);
    }

    @Override
    public List<UserSignUpForm> getUserSignUpForms() {
        return _userSignUpFormRepo.findAll();
    }

    @Override
    public UserSignUpForm getUserSignUpForm(int id) {
        return _userSignUpFormRepo.findById(id).isPresent() ?
                _userSignUpFormRepo.findById(id).get() : null;
    }

    @Override
    public UserSignUpForm saveUserSignUpForm(UserSignUpForm form) {
        return _userSignUpFormRepo.save(form);
    }

    @Override
    public void deleteUserSignUpForm(UserSignUpForm user) {
        _userSignUpFormRepo.delete(user);
    }
}
