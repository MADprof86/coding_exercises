package pl.coderslab.Classes.Notifications;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {
    @Spy
    NotificationService notificationService;
    @Test
    void notifyUser() {
        String userId = "123";
        String message = "Lorem ipsum";
        notificationService.notifyUser(userId,message);

        verify(notificationService).sendEmail("123@example.com",message);

    }

    @Test
    void sendSMS() {
        String number = "123456789";
        String message = "Lorem ipsum";
        boolean result = notificationService.sendSMS(number, message);

        assertTrue(result);
    }

    @Test
    void sendEmail() {
        String number = "123456789";
        String message = "Lorem ipsum";
        boolean result = notificationService.sendEmail(number, message);

        assertTrue(result);
    }
}