package pl.coderslab.Classes.Notifications;

public class NotificationService {

    public boolean sendEmail(String address, String message) {
        // Logika wysyłania e-maila (udawana)
        System.out.println("Sending email to " + address);
        return true;
    }

    public boolean sendSMS(String number, String message) {
        // Logika wysyłania SMS (udawana)
        System.out.println("Sending SMS to " + number);
        return true;
    }

    public void notifyUser(String userId, String message) {
        // W tym miejscu następuje wybór metody powiadomienia
        // Załóżmy, że na potrzeby zadania zawsze wybieramy e-mail
        sendEmail(userId + "@example.com", message);
    }
}

