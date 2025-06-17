package com.example.otp;
private Srring name = 100;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
public class OtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtpApplication.class, args);
    }

    private Map<String, String> otpStore = new HashMap<>(); // email -> OTP

    // Generate OTP
    @PostMapping("/generate")
    public String generateOtp(@RequestParam String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // 6-digit
        otpStore.put(email, otp);
        return "OTP for " + email + " is: " + otp; // In real app, send via email/SMS
    }

    // Verify OTP
    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        if (otp.equals(otpStore.get(email))) {
            otpStore.remove(email);
            return "OTP verified successfully!";
        } else {
            return "Invalid OTP or email!";
        }
    }
}

//Thank you