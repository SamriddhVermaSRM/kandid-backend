package com.kandid.backend.Service;

import com.kandid.backend.Model.ContactUsForm;
import com.kandid.backend.Model.UserSignUpForm;

import java.util.List;

public interface FormService {

    ContactUsForm getContactUsForm(int id);

    List<ContactUsForm> getContactUsForms();

    ContactUsForm saveContactUsForm(ContactUsForm form);

    void deleteContactUsForm(ContactUsForm form);

    List<UserSignUpForm> getUserSignUpForms();

    UserSignUpForm getUserSignUpForm(int id);

    UserSignUpForm saveUserSignUpForm(UserSignUpForm form);

    void deleteUserSignUpForm(UserSignUpForm user);
}
