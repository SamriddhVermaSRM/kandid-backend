package com.kandid.backend.Service;

import com.kandid.backend.Model.Email;
import com.kandid.backend.Model.UserSignUpForm;

public interface MailService {

    Email sendMail( Email email);

}
