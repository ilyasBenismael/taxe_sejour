package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LocalDao extends JpaRepository<Local,Long> {
    public  Local findByRef(String reference);
    public List<Local> findByRueCode(String code);
    public List<Local> findByCategorieLocalCode(String code);

    public List<Local> findByAnneeLessThanAndTrimestreLessThan(int annee, int trimestre);

    public List<Local> findByRueQuartierCode(String code);
    public List<Local> findByRueQuartierSecteurCode(String code);
    public List<Local> findByDerTripayee(int dernierTrimPaye);

    int deleteByRef(String ref);

}