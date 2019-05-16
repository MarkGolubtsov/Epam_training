package test;

import by.training.oop.entity.Train;
import by.training.oop.reader.ReaderFromFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ReaderTest {
    private ReaderFromFile readerFromFile = new ReaderFromFile();

    @Test
    public void  correctReadTwoTrains()
    {
        List<Train> trains =readerFromFile.getTrainsFromFile("D:\\EPAM_JAVA\\TASK\\task01\\src\\by\\training\\oop\\data\\initial.txt");
        int expected = 2;
        int actual = trains.size();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void  notCorrectReadTrain()
    {
        List<Train> trains =readerFromFile.getTrainsFromFile("D:\\EPAM_JAVA\\TASK\\task01\\src\\by\\training\\oop\\data\\NotCorrectData.txt");
        int expected = 0;
        int actual = trains.size();
        Assert.assertEquals(actual,expected);
    }
}
