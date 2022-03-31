package com.example.motorvognregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController {
    @Autowired
    private Repository rep;
    public final List<Bil> Biler=new ArrayList<>();

    public MotorvognController(){
        Bil Bil1=new Bil("Volvo", "A8");
        Biler.add(Bil1);
        Bil Bil2 =new Bil("Volvo", "A9");
        Biler.add(Bil2);
        Bil Bil3=new Bil("Volvo", "E1");
        Biler.add(Bil3);
        Bil Bil4=new Bil("Audi","A3");
        Biler.add(Bil4);
        Bil Bil5=new Bil("Audi","E4");
        Biler.add(Bil5);
    }
    @GetMapping("/hentBiler")
    public List<Bil> hentBiler(){
        return Biler;
    }

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn bil){
       rep.lagreMotorVogn(bil);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle(){
        return rep.hentMotorVogn();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlleMotorVogn();
    }
}
