package com.kandid.backend.Controller;

import com.kandid.backend.Model.UserSignUpForm;
import com.kandid.backend.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/forms/user-signup")
public class UserSignUpFormController {

    @Autowired
    private FormService _formService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllForms() {
        List<UserSignUpForm> forms = _formService.getUserSignUpForms();
        if (forms.isEmpty()) {
            return new ResponseEntity<>("no users have signed up", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormById(@PathVariable int id) {
        UserSignUpForm form = _formService.getUserSignUpForm(id);
        if (form == null) {
            return new ResponseEntity<>("no such user", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<?> numberOfForms() {
        return new ResponseEntity<>(_formService.getUserSignUpForms().size(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveForm(@RequestBody UserSignUpForm user) {
        return new ResponseEntity<>(_formService.saveUserSignUpForm(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteForm(@RequestBody UserSignUpForm form) {
        _formService.deleteUserSignUpForm(form);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}

