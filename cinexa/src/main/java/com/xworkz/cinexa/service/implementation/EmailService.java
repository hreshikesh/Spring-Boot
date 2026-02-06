package com.xworkz.cinexa.service.implementation;


import com.xworkz.cinexa.dto.BookingDto;
import com.xworkz.cinexa.entity.MovieEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.File;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public  void sendAdminOtpMail(String email,String otp) throws MessagingException {
        Context context=new Context();
        context.setVariable("otp",otp);
        String html= templateEngine.process("AdminOtpTemplate",context);
        MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");
            helper.setTo(email);
            helper.setSubject("Your OTP for Admin Login");
            helper.setText(html, true);
            javaMailSender.send(message);
    }


    @Async
    public void sendSaveMovieEmail(MovieEntity movieEntity) throws MessagingException {
        Context context=new Context();
        context.setVariable("movieName",movieEntity.getMovieName());
        context.setVariable("movieLanguage",movieEntity.getMovieLanguage().toString());
        context.setVariable("moviePrice",movieEntity.getMoviePrice());

        String html=templateEngine.process("MovieSaveTemplate",context);

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED);

        helper.setTo("ailhreshikesh@gmail.com");
        helper.setSubject("Movie Details Saved Successfully");
        helper.setText(html,true);

        FileSystemResource resource=new FileSystemResource(new File("D:\\cinexa\\"+movieEntity.getMovieImageEntity().getImageName()));

        helper.addInline("movieImage",resource);


        javaMailSender.send(message);

    }

    @Async
    public void sendBookingEmail(BookingDto bookingDto,MovieEntity movieEntity) throws MessagingException {
        Context context=new Context();
        context.setVariable("movieName",movieEntity.getMovieName());
        context.setVariable("date",bookingDto.getBookingDate());
        context.setVariable("selectedSeat",bookingDto.getSelectedSeats());
        context.setVariable("totalPrice",bookingDto.getPrice());

        String html=templateEngine.process("BookingTemplate",context);

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED);

        helper.setTo(bookingDto.getUserEmail());
        helper.setSubject("Booking SuccessfullyDone");
        helper.setText(html,true);


        helper.addInline("movieImage",new FileSystemResource(new File("D:\\cinexa\\"+movieEntity.getMovieImageEntity().getImageName())));

        javaMailSender.send(message);

    }

}
