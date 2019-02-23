package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;

public interface ResOrderService {
    Message startDeliver(int oid);
    Message delivered(int oid);
}
