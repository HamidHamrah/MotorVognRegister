package com.example.motorvognregister;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
    private JdbcTemplate db;

    public void lagreMotorVogn(Motorvogn MotorVogn){
        String sql="INSERT INTO MotorVogn(personnr,navn, adresse, kjennetegn, merke, type) " +
                "VALUES(?,?,?,?,?,?)";
        db.update(sql, MotorVogn.getPersonnr(),MotorVogn.getNavn(),MotorVogn.getAdresse(),
                MotorVogn.getKjennetegn(),MotorVogn.getMerke(),MotorVogn.getType());
    }
    public List<Motorvogn> hentMotorVogn(){
        String sql="SELECT* FROM MotorVogn";
        List<Motorvogn> alleMotorVogn=db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
        return alleMotorVogn;
    }
    public void slettAlleMotorVogn(){
        String sql="DELETE FORM MotorVogn";
        db.update(sql);
    }
}
