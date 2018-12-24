package com.baizhi.serviceimpl;

import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
//查询所有的上师信息
    public List<Guru> findAll() {
        List<Guru> gurus = guruDAO.queryAll();
        return gurus;
    }

    @Override
    public void removeGuru(String guruId) {
        guruDAO.delete(guruId);
    }

    @Override
    public Guru findOne(String guruId) {
        Guru guru = guruDAO.queryById(guruId);
        return guru;
    }

    //添加上师的信息
    @Override
    public void addGuru(Guru guru) {
        guru.setGuruId(UUID.randomUUID().toString());
        guruDAO.insert(guru);
    }
//修改上师的信息
    @Override
    public void modifyGuru(Guru guru) {
        guruDAO.update(guru);
    }
}
