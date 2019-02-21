package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.service.ManagerResService;
import org.springframework.stereotype.Service;

@Service
public class ManagerResServiceBean implements ManagerResService {
    @Override
    public Message examineResChangeAddress(String address) {
        return null;
    }

    @Override
    public Message examineResChangeType(String type) {
        return null;
    }

    @Override
    public Message examineResChangeName(String name) {
        return null;
    }

    @Override
    public int getResChangeAddress() {
        return 0;
    }

    @Override
    public int getResChangeType() {
        return 0;
    }

    @Override
    public int getResChangeName() {
        return 0;
    }
}
