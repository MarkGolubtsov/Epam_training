package by.training.oop.factory;

import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;

import java.util.List;

public interface Factory {
    Wagon getObject(List<String> params) throws NotCorrectData;
}
