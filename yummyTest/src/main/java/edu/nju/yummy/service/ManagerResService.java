package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;

public interface ManagerResService {
    Message examineResChangeAddress(String address);
    Message examineResChangeType(String type);
    Message examineResChangeName(String name);
    int getResChangeAddress();
    int getResChangeType();
    int getResChangeName();

}