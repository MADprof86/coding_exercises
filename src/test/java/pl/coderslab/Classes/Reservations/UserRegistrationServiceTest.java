package pl.coderslab.Classes.Reservations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    @Mock
    EmailService emailService;
    @Test
    void registerUser_ifValid_confirmationMailHasBeenSent() {
        String userEmail = "aaa@bb.pl";
        UserRegistrationService userRegistrationService = new UserRegistrationService(emailService);
        userRegistrationService.RegisterUser(userEmail);
        verify(emailService).sendConfirmationEmail(userEmail);
        verify(emailService, atLeastOnce()).sendConfirmationEmail(userEmail);
    }
}