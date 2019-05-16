package by.training.oop.reader;


import by.training.oop.enm.TypeWagon;
import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.exception.NotLocomativeException;
import by.training.oop.factory.*;
import by.training.oop.validator.TextValidator;
import by.training.oop.validator.WagonValidator;

import org.apache.log4j.Logger;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ReaderFromFile {

   private static  final Logger logger = Logger.getLogger(ReaderFromFile.class.getSimpleName());

    private static final String START_TRAIN="beginTrain";
    private static  final String END_TRAIN="endTrain";
    private static final String STAR_WAGON="startWagon";
    private static final String END_WAGON="endWagon";
    private static final String TYPE_WAGON="type";
    private static final String COUNT_PASSAGER="countPassager";
    private static  final String COUNT_BAGGAGE="countBaggage";
    private static final String TYPE_ENGINE ="engine";
    private static final String TYPE_COMFORT="comfort";
    private static final String COUNT_WHEELS="countWheels";
    private static final String PATH="D:\\EPAM_JAVA\\TASK\\task01\\src\\by\\training\\oop\\data\\initial.txt";
    public List<Train> getTrainsFromFile(String path) {
        if(!TextValidator.isRealFile(path))
        {
            path= PATH;
        }

        ArrayList<String> file= justRead(path);
        List<Train> result = new ArrayList<>();
        file = trim(file);
        int i=0;
        Train train;

        Optional<Wagon> head = Optional.empty();
        Optional<Wagon> tail= Optional.empty();

        ArrayList<String> params= new ArrayList<>();
        params.add("");
        params.add("");
        params.add("");
        params.add("");

        ArrayList<Wagon> wagons = new ArrayList<>();
        Optional<Factory> factory=Optional.empty();
        WagonFactory wagonFactory = new WagonFactory();
        TrainFactory trainFactory = new TrainFactory();
        Wagon wagon;
        while (i<file.size())
        {
            boolean correcr = true;
            String command= file.get(i);

            switch (command){
                case START_TRAIN:
                    wagons=new ArrayList<>();
                    break;
                case TYPE_WAGON:
                    i=i+1;
                    String type = file.get(i);

                    if (TextValidator.isTypeWagon(type))
                    {
                        factory=Optional.of(wagonFactory.getFactory(TypeWagon.valueOf(type)));
                    }
                    else {
                        correcr=false;
                    }

                    break;
                case STAR_WAGON:
                    params= new ArrayList<>();
                    params.add("");
                    params.add("");
                    params.add("");
                    params.add("");
                    break;
                case COUNT_PASSAGER:
                    i++;
                    String countPassager=file.get(i);
                        if(TextValidator.isCount(countPassager)) {
                            params.remove(1);
                            params.add(1, countPassager);
                        }
                   else {
                            logger.error("not int COUNT_PASSAGER");
                            correcr = false;
                        }
                    break;

                case COUNT_BAGGAGE:
                    i++;
                    String countBaggage=file.get(i);
                        if(TextValidator.isCount(countBaggage)) {
                            params.remove(2);
                            params.add(2, countBaggage);
                        }
                        else {
                            logger.error("not int COUNTBAGGAGE");
                            correcr = false;
                        }
                    break;

                case COUNT_WHEELS:
                    i++;
                    String value1=file.get(i);
                    if(TextValidator.isCount(value1)){
                            params.remove(0);
                            params.add(0,value1);
                        }
                    else {
                            logger.error("not int wheels");
                             correcr = false;
                        }
                    break;

                case END_WAGON:
                    if (correcr) {
                    try {

                        if (factory.isPresent()) {
                            wagon = factory.get().getObject(params);
                        } else {
                            throw new NotCorrectData();
                        }

                        if (WagonValidator.isLocomative(wagon))
                        {
                            if (head.isEmpty())
                            {
                                head=Optional.of(wagon);
                            } else {
                                if (tail.isEmpty()) {
                                    tail = Optional.of(wagon);
                                }
                            }
                        } else {
                            wagons.add(wagon);
                        }
                    } catch (NotCorrectData ex3) {
                        logger.error("not Correct params");
                    }
                        correcr = true;
                }

                    break;
                case TYPE_ENGINE:
                    i++;
                    String typeEngine=file.get(i);
                    if(TextValidator.isTypeEnginer(typeEngine))
                    {
                        params.remove(1);
                        params.add(1,typeEngine);
                    }
                    else {
                        correcr=false;
                        logger.error("value of Engine bad");
                    }
                    break;
                case TYPE_COMFORT:
                    i++;
                    String typeComfort=file.get(i);
                    if(TextValidator.isTypeComfort(typeComfort)) {
                        params.remove(3);
                        params.add(3, typeComfort);
                    }
                    else {
                        correcr=false;
                        logger.error("value of Comfort bad");
                    }
                    break;
                case END_TRAIN:
                    params= new ArrayList<>();
                    params.add("");
                    params.add("");
                    params.add("");
                    params.add("");
                    if(head.isPresent() && tail.isPresent() && (!wagons.isEmpty())) {
                        try {
                            train = trainFactory.create(head.get(), tail.get(), wagons);
                            result.add(train);
                            logger.info("Train create");
                        } catch (NotLocomativeException e) {
                            logger.error("Need locomotive");
                        }
                    }
                    else {
                        logger.error("Train not add");
                    }

                    break;
                default:
            }
            i++;
            }
        return result;
    }


    private  ArrayList<String> justRead(String path)
    {
        ArrayList<String> allFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                allFile.add(sCurrentLine);
            }

        } catch (IOException e) {
            logger.error("Error while read file");
        }
        return  allFile;
    }




    private ArrayList<String> trim(ArrayList<String> arrayList)
    {
        int i = 0;
        while(i<arrayList.size()) {
            arrayList.set(i,arrayList.get(i).trim());

            if ("".equals(arrayList.get(i)))
            {
                arrayList.remove(i);
            }
            else{
                i++;
            }
        }
        return arrayList;
    }
}
