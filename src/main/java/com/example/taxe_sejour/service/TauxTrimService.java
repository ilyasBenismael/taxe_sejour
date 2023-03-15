package com.example.taxe_sejour.service;


import com.example.taxe_sejour.dao.TauxTrimDAO;
import com.example.taxe_sejour.bean.TauxTrim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxTrimService {
    @Autowired
private TauxTrimDAO tauxTrimDAO;

    public int Save(TauxTrim tauxTrim){
        if (findByRef(tauxTrim.getRef()) != null){
            return -1;
        }else {
            tauxTrimDAO.save(tauxTrim);
            return 1;
        }
    }


    public TauxTrim findByRef(String ref) {
        return tauxTrimDAO.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return tauxTrimDAO.deleteByRef(ref);
    }

    public List<TauxTrim> findAll() {
        return tauxTrimDAO.findAll();
    }

    public TauxTrim findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode(int annee, int annee2, String code) {
        return tauxTrimDAO.findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode(annee, annee2, code);
    }
}
