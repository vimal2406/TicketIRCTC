package ticket.booking.entities;

import org.checkerframework.checker.units.qual.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class    Train {

    private String trainId;

    private String trainNo;

    private List<List<Integer>> seats;

    private Map<String, String> stationsTimes;

    private List<String> stations;

    public Train(){};

    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String, String> stationsTimes)
    {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.seats = seats;
        this.stationsTimes = stationsTimes;
        this.stations = new ArrayList<String>();
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public Map<String, String> getStationsTimes() {
        return stationsTimes;
    }

    public void setStationsTimes(Map<String, String> stationsTimes) {
        this.stationsTimes = stationsTimes;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String  getTrainInfo()
    {
        return String.format("Train Id : %s  TrainNo : %s ", trainId, trainNo);
    }
}
