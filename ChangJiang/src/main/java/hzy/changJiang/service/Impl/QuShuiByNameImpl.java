package hzy.changJiang.service.Impl;

import hzy.changJiang.aop.HzyTransactional;
import hzy.changJiang.dao.OutFallMapper;
import hzy.changJiang.dao.RiverMapper;
import hzy.changJiang.pojo.OutFall;
import hzy.changJiang.pojo.River;
import hzy.changJiang.service.QuShuiByName;
import hzy.changJiang.utils.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class QuShuiByNameImpl implements QuShuiByName {
    @Autowired
    private RiverMapper riverMapper;

    @Autowired
    private OutFallMapper outFallMapper;

    @Autowired
    private TransactionUtils transactionUtils;

    @Override
    public List<OutFall> QuShuiName(String name) {
        Example example = new Example(River.class);
        example.createCriteria().andEqualTo("name",name);
        River river = riverMapper.selectOneByExample(example);
        int id = river.getId();

        Example example1 = new Example(OutFall.class);
        example1.createCriteria().andEqualTo("isIntake",1).andEqualTo("riverId",id);
        List<OutFall> outFalls = outFallMapper.selectByExample(example1);
        return outFalls;
    }

    @Override
//    @Transactional
    @HzyTransactional
    public boolean insertRiver(River river) {
        TransactionStatus begin = null;
        try{
            begin = transactionUtils.begin();
            int i = riverMapper.insertSelective(river);
            transactionUtils.commit(begin);
            return true;
        }catch (Exception e) {
            if (begin != null) {
                transactionUtils.rollback(begin);
            }
            return false;
        }
    }
}
