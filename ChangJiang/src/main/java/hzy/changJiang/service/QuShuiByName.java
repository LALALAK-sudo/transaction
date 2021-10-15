package hzy.changJiang.service;

import hzy.changJiang.pojo.OutFall;
import hzy.changJiang.pojo.River;

import java.util.List;

public interface QuShuiByName {
    public List<OutFall> QuShuiName(String river);

    public boolean insertRiver(River river);
}
