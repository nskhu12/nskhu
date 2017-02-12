package org.nskhu.profile;


import org.nskhu.model.MessageForm;
import org.nskhu.model.User;
import org.nskhu.model.UserForm;
import org.nskhu.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserForm getUser() {
        User u = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        return UserForm.withUser(u);
    }

    @RequestMapping(value = "/user/change/to/{newName}")
    public MessageForm changeName(@PathVariable("newName") String newName) {
        MessageForm message = new MessageForm();
        if (newName == "") {
            message.setMessage("Fill all inputs");
            return message;
        }
        if (repo.findByName(newName) == null) {
            User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
            session.setAttribute("LOGGED_USERNAME", newName);
            user.setName(newName);
            repo.save(user);
            message.setMessage("Success");
        } else {
            message.setMessage("User name already taken.");
        }
        return message;
    }

    @RequestMapping(value = "/password/change/to/{password}")
    public MessageForm changePassword(@PathVariable("password") String password) {
        MessageForm message = new MessageForm();
        if (password == "") {
            message.setMessage("Fill all inputs");
            return message;
        }
        User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        user.setPassword(password);
        repo.save(user);
        message.setMessage("Success");
        return message;
    }

    @RequestMapping(value = "/liabilities/change/to/{liabilities}")
    public MessageForm changeLiabilities(@PathVariable("liabilities") BigDecimal liabilities) {
        MessageForm message = new MessageForm();
        if (liabilities == null) {
            message.setMessage("Fill all inputs");
            return message;
        }
        User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        user.setLiabilities(liabilities);
        repo.save(user);
        message.setMessage("Success");
        return message;
    }

    @RequestMapping(value = "/monthlySalary/change/to/{monthlySalary}")
    public MessageForm changeMonthlySalary(@PathVariable("monthlySalary") BigDecimal monthlySalary) {
        MessageForm message = new MessageForm();
        if (monthlySalary == null) {
            message.setMessage("Fill all inputs");
            return message;
        }
        User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        user.setMonthlySalary(monthlySalary);
        repo.save(user);
        message.setMessage("Success");
        return message;
    }

    @RequestMapping(value = "/phoneNumber/change/to/{phoneNumber}")
    public MessageForm changePhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        MessageForm message = new MessageForm();
        if (phoneNumber == "") {
            message.setMessage("Fill all inputs");
            return message;
        }
        User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        user.setPhoneNumber(phoneNumber);
        repo.save(user);
        message.setMessage("Success");
        return message;
    }

    @RequestMapping(value = "/birthdate", method = RequestMethod.POST)
    public MessageForm changeBirthDate(@RequestBody UserForm form) {
        MessageForm message = new MessageForm();
        User user = repo.findByName(form.getName());
        if (form.getBirthDay() == null || form.getBirthMonth() == null || form.getBirthYear() == null) {
            message.setMessage("Fill all inputs");
            return message;
        }
        if (form.getBirthDay() < 0 || form.getBirthDay() > 31 || form.getBirthMonth() < 0
                || form.getBirthMonth() > 12 || form.getBirthYear() < 0) {
            message.setMessage("Birthdate incorrect");
            return message;
        }
        if (!user.isBirthdayChanged()) {
            user.setBirthDay(form.getBirthDay());
            user.setBirthMonth(form.getBirthMonth());
            user.setBirthYear(form.getBirthYear());
            user.setBirthdayChanged(true);
            repo.save(user);
            message.setMessage("Success");
        } else {
            message.setMessage("Date already changed once.");
        }
        return message;
    }

    @RequestMapping(value = "/creditlimit")
    public MessageForm getCreditLimit() {
        MessageForm message = new MessageForm();

        User user = repo.findByName((String) session.getAttribute("LOGGED_USERNAME"));
        int ageInYears = Calendar.getInstance().get(Calendar.YEAR) - (user.getBirthYear());
        if (ageInYears < 21 || ageInYears > 75) {
            message.setMessage("0.00");
        } else {
            BigDecimal b = (BigDecimal.valueOf(87).multiply(BigDecimal.valueOf(ageInYears)))
                    .add(user.getMonthlySalary().multiply(BigDecimal.valueOf(2)))
                    .subtract(BigDecimal.valueOf(3).multiply(user.getLiabilities()));

            message.setMessage(b.toString());
        }

        return message;
    }


    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository repo;

}
