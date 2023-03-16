package com.demo.studentmanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Hashtable;

public class SerialAccount implements Serializable {
    private String data;
    private Hashtable hashtable;

    public SerialAccount() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("com/demo/studentmanagement/Account.txt"))) {
            data = (String) ois.readObject();
            unSerialize();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void unSerialize() {
        hashtable = new Hashtable<String, String>();
        String[] user_pass = data.split("\n");
        for (int i = 0; i < user_pass.length; i++) {
            String[] user_pass_ = user_pass[i].split(" ");
            if (!hashtable.containsKey(user_pass_[0])) {
                hashtable.put(user_pass_[0], user_pass_[1]);
            }
        }
    }

    public boolean checkAccount(String username, String password) {
        if (hashtable.containsKey(username)) {
            if (hashtable.get(username) == password) {
                return true;
            }
        }
        return false;
    }
}
