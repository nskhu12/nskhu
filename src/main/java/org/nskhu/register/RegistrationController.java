package org.nskhu.register;

import org.nskhu.model.MessageForm;
import org.nskhu.model.UserForm;
import org.nskhu.model.User;
import org.nskhu.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public MessageForm register(@RequestBody UserForm form) {
        MessageForm message = new MessageForm();
        if (form.getName() == null
                || form.getPassword() == null
                || form.getLiabilities() == null
                || form.getMonthlySalary() == null
                || form.getPhoneNumber() == null
                || form.getBirthDay() == null
                || form.getBirthMonth() == null
                || form.getBirthYear() == null) {
            message.setMessage("fill all input");
            return message;
        }
        int ageInYears = Calendar.getInstance().get(Calendar.YEAR) - form.getBirthYear();
        if (ageInYears < 21 || form.getBirthDay() > 31 || form.getBirthMonth() > 12) {
            message.setMessage("Age problem, or incorrect birthdate");
        } else if (ageInYears * 87 + form.getMonthlySalary().intValue() - form.getLiabilities().intValue() * 3 < 100) {
            message.setMessage("Credit limit too small");
        } else if (repo.findByName(form.getName()) != null) {
            message.setMessage("Username already taken");
        } else {
            User user = new User();
            user.setName(form.getName());
            user.setLiabilities(form.getLiabilities());
            user.setMonthlySalary(form.getMonthlySalary());
            user.setPhoneNumber(form.getPhoneNumber());
            user.setBirthDay(form.getBirthDay());
            user.setBirthMonth(form.getBirthMonth());
            user.setBirthYear(form.getBirthYear());
            user.setPassword(form.getPassword());
            user.setBirthdayChanged(false);
            repo.save(user);
            message.setMessage("Success");
        }
        return message;
    }

    @Autowired
    private UserRepository repo;

}

