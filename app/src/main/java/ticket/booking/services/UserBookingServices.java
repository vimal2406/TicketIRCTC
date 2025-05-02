package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class UserBookingServices
{
    private User user;

    private static final String USER_PATH = "app/src/main/java/ticket/booking/localdb/user.json";

    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingServices() throws IOException
    {
        loadUser();
    }

    public UserBookingServices(User user) throws IOException
    {
        this.user= user;
        loadUser();
    }

    public void loadUser() throws IOException
    {
        File users = new File(USER_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    public  Boolean loginUser()
    {
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getUserName().equals(user.getUserName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }


    public Boolean signUp(User user1)
    {
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException
    {
        File usersFile = new File(USER_PATH);
        objectMapper.writeValue(usersFile,userList);
    }

    public void fetchBooking()
    {
        Optional<User> userFetched = userList.stream().filter(user1 -> user1.getUserName().equals(user.getUserName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashedPassword())).findFirst();
        if(userFetched.isPresent())
        {
            userFetched.get().printTickets();
        }
    }

    public List<Train> getTrains(String sourceStation, String destinationStation)
    {
        try
        {
            List<Train> trains = new ArrayList<>();
            TrainServices trainServices = new TrainServices();
            return trainServices.getTrains(sourceStation,destinationStation);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public List<List<Integer>> fetchSeats(Train train)
    {
        return train.getSeats();
    }
}