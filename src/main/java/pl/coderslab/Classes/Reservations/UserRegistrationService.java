package pl.coderslab.Classes.Reservations;

public class UserRegistrationService {
    private EmailService emailService;
    public UserRegistrationService(EmailService emailService){
        this.emailService = emailService;
    }
    public void RegisterUser(String userEmail){
        emailService.sendConfirmationEmail(userEmail);
    }
}
