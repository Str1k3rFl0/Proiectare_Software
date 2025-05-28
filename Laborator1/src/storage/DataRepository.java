package storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Persists sensor data.
 * Singleton pattern implementation.
 */
public class DataRepository
{
    private static DataRepository instance;

    private List<SensorData> dataList;

    private DataRepository()
    {
        dataList = new ArrayList<>();
    }

    public static synchronized DataRepository getInstance()
    {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    public void addData(SensorData dataRecord)
    {
        dataList.add(dataRecord);
    }

    public List<SensorData> getRecords()
    {
        return new ArrayList<>(dataList);
    }
}
