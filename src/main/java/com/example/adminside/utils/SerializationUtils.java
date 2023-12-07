package com.example.adminside.utils;

import com.example.adminside.model.UserModel;

import java.io.*;
import java.util.Base64;
import java.util.List;

public class SerializationUtils {
    public static String serializeList(List<UserModel> userList) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(userList);
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public static <T> List<T> deserializeList(String serializedData) throws IOException, ClassNotFoundException {
        byte[] data = java.util.Base64.getDecoder().decode(serializedData);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        List<T> deserializedList = (List<T>) ois.readObject();
        ois.close();
        return deserializedList;
    }
}
