package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainServices
{
    List<Train> trainsList;
    private ObjectMapper mapper = new ObjectMapper();
    private static final String TRAIN_DB_PATH = "../localdb/train.json";

    public TrainServices() throws IOException
    {
        File trains = new File(TRAIN_DB_PATH);
        trainsList = mapper.readValue(trains, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> getTrains(String sourceStation, String destinationStation)
    {
       return trainsList.stream().filter(train -> validTrain(train,sourceStation,sourceStation)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String sourceStation, String sourceStation1)
    {
        List<String> sataionOrder  = train.getStations();
        int sourecIndex = sataionOrder.indexOf(sourceStation);
        int destinationIndex = sataionOrder.indexOf(sourceStation1);

        return sourecIndex != -1 && destinationIndex != -1 && sourecIndex < destinationIndex;

    }

    public void saveTrainListToFile() throws IOException
    {
        mapper.writeValue(new File(TRAIN_DB_PATH),trainsList);
    }
}
