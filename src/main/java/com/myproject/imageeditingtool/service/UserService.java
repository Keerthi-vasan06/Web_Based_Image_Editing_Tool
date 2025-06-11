package com.myproject.imageeditingtool.service;

import com.myproject.imageeditingtool.entity.SmtpEntity;
import com.myproject.imageeditingtool.entity.User;
import com.myproject.imageeditingtool.repository.SmtpRepository;
import com.myproject.imageeditingtool.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private SmtpRepository smtpRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String resetPassword(Long userid, String password) {
        Optional<User> user = userRepository.findById(userid);
        if(!user.isPresent()) {
            return "Invalid User";
        }
        User newUsr = user.get();
        newUsr.setPasswordHash(password);
        userRepository.save(newUsr);
        return "password changed";
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getPaginatedEmployee(int page, int size, String name)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(name).ascending());
        return userRepository.findAll(pageable).getContent();
    }



    public List<User> getUsersByNameStartsWith(String prefix) {
        return userRepository.findByUsernameStartingWith(prefix);
    }

    public List<User> getUsersByNameEndsWith(String suffix) {
        return userRepository.findByUsernameEndingWith(suffix);
    }





    @Transactional
    public String generateEmail(String receiver, String subject, String content) {
        try {
            // Create email message
            MimeMessage msg = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content);

            // Send email
            sender.send(msg);

            // Save email to database
            SmtpEntity smtp = new SmtpEntity();
            smtp.setReceiver(receiver);
            smtp.setSubject(subject);
            smtp.setContent(content);


            smtpRepository.save(smtp);

            return "Email Sent Successfully";
        } catch (MessagingException e) {
            return "Email Not Sent: " + e.getMessage();
        }

    }


    public List<User> getUsersByNameContains(String name)
    {
        return userRepository.findByUsernameContains(name);
    }

    public List<User> getUsersByNameContaining(String name)
    {
        return userRepository.findByUsernameContaining(name);
    }

    public List<User> getUsersByNameNotContaining(String name)
    {
        return userRepository.findByUsernameNotContaining(name);
    }
}

