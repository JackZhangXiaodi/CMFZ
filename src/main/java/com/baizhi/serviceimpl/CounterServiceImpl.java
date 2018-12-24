package com.baizhi.serviceimpl;

import com.baizhi.dao.CounterDAO;
import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CounterServiceImpl implements CounterService {
    @Autowired
    private CounterDAO counterDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询用户的计数器
    public List<Counter> findAll() {
        List<Counter> counters = counterDAO.queryAll();
        return counters;
    }
}
