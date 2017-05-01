package com.mister.lib.helpers;

import com.mister.lib.model.generic.Model;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class GameModel {

    @Nullable
    public static <T> T loadOne(String fileName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            T object = (T) objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException exception) {
            return null;
        }
    }

    public static <T> List<T> loadMany(String fileName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            List<T> list = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            return list;

        } catch (IOException | ClassNotFoundException exception) {
            return new ArrayList<>();
        }
    }

    public static boolean save(List<Model> modelList) {
        return save(modelList, modelList.get(0).getSaveFileName());
    }

    public static boolean save(Model model) {
        return save(model, model.getSaveFileName());
    }

    private static boolean save(Object object, String fileName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException exception) {
            return false;
        }
    }
}
