package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String userName;

    private String password;

    private String hashedPassword;

    private List<Ticket> ticketBooked;

    private String userId;

    public User(String name, String password, String hashedPassword, List<Ticket> ticketBooked, String userId)
    {
        this.userName = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketBooked = ticketBooked;
        this.userId = userId;
    }

    public User(){};

    public void printTickets()
    {
        for(int i=0; i<ticketBooked.size(); i++)
        {
            System.out.println(ticketBooked.get(i).getTicketInfo());
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Ticket> getTicketBooked() {
        return ticketBooked;
    }

    public void setTicketBooked(List<Ticket> ticketBooked) {
        this.ticketBooked = ticketBooked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
