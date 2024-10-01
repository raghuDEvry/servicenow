package com.example.servicecenter.controller;

import com.example.servicecenter.entity.CallMe;
import com.example.servicecenter.entity.Contact;
import com.example.servicecenter.repository.CallMeRepository;
import com.example.servicecenter.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CallMeController {

    @Autowired
    private CallMeRepository callMeRepository;

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/call-me")
    public Response callMe(@RequestBody CallRequest callRequest) {
        CallMe callMe = new CallMe();
        callMe.setName(callRequest.getName());
        callMe.setPhone(callRequest.getPhone());
        callMeRepository.save(callMe);

        return new Response("We will call you shortly, " + callRequest.getName() + "!");
    }

    @PostMapping("/contact")
    public Response contactUs(@RequestBody ContactRequest contactRequest) {
        Contact contact = new Contact();
        contact.setEmail(contactRequest.getEmail());
        contact.setMessage(contactRequest.getMessage());
        contactRepository.save(contact);

        return new Response("Thank you for reaching out! We will get back to you soon.");
    }

    static class CallRequest {
        private String name;
        private String phone;
        // Getters and setters
    }

    static class ContactRequest {
        private String email;
        private String message;
        // Getters and setters
    }

    static class Response {
        private String message;
        public Response(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }
}
