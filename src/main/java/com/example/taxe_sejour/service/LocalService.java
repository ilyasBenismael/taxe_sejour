package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.dao.LocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalService {


    @Autowired
    private LocalDao localDao;


    @Query("SELECT l FROM  Local  l WHERE l.dernierAnneePayee*4 + l.dernierTrimestrePayee < :dernierTrimestrePayee + :dernierAnneePayee*4")
    public List<Local> findByDernierAnneePayeeAndDernierTrimestrePayee(int dernierAnneePayee, int dernierTrimestrePayee) {
        return localDao.findByDernierAnneePayeeAndDernierTrimestrePayee(dernierAnneePayee, dernierTrimestrePayee);
    }

    public List<Local> findByRueCodeAndCategorieLocalCode(String code, String localCode) {
        return localDao.findByRueCodeAndCategorieLocalCode(code, localCode);
    }

    public List<Local> findByRueQuartierCodeAndCategorieLocalCode(String code, String localCode) {
        return localDao.findByRueQuartierCodeAndCategorieLocalCode(code, localCode);
    }

    public List<Local> findByRueQuartierSecteurCodeAndCategorieLocalCode(String code, String localCode) {
        return localDao.findByRueQuartierSecteurCodeAndCategorieLocalCode(code, localCode);
    }

    public Local findByRef(String ref) {
        return localDao.findByRef(ref);
    }

    public List<Local> findByRueCode(String code) {
        return localDao.findByRueCode(code);
    }

    public List<Local> findByCategorieLocalCode(String code) {
        return localDao.findByCategorieLocalCode(code);
    }

    public List<Local> findByRueQuartierCode(String code) {
        return localDao.findByRueQuartierCode(code);
    }


    public List<Local> findByRueQuartierSecteurCode(String code) {
        return localDao.findByRueQuartierSecteurCode(code);
    }



    @Transactional
    public int deleteByRef(String ref) {
        return localDao.deleteByRef(ref);
    }


    public int save(Local local) {
        if(findByRef(local.getRef())!=null){
            return -1;
        }else{
            localDao.save(local);
            return 1;
        }

    }


}
