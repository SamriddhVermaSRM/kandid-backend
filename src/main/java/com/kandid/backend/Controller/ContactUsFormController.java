package com.kandid.backend.Controller;

import com.kandid.backend.Model.ContactUsForm;
import com.kandid.backend.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/forms/contact-us")
public class ContactUsFormController {

    @Autowired
    private FormService _formService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllForms() {
        List<ContactUsForm> forms = _formService.getContactUsForms();
        if (forms.isEmpty()) {
            return new ResponseEntity<>("no one contacted us :(", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormById(@PathVariable int id) {
        ContactUsForm form = _formService.getContactUsForm(id);
        if (form == null) {
            return new ResponseEntity<>("no one contacted us :(", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(form, HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<?> numberOfForms() {
        return new ResponseEntity<>(_formService.getContactUsForms().size(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveForm(@RequestBody ContactUsForm form) {
        return new ResponseEntity<>(_formService.saveContactUsForm(form), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteForm(@RequestBody ContactUsForm form) {
        _formService.deleteContactUsForm(form);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
