package com.cenfotec.examen2.controller;

import com.cenfotec.examen2.domain.Atleta;
import com.cenfotec.examen2.domain.Historial;
import com.cenfotec.examen2.service.AtletaService;
import com.cenfotec.examen2.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Controller
public class AtletaController {
    @Autowired
    AtletaService atletaService;

    @Autowired
    HistorialService historialService;


    @RequestMapping("/")
    public String home(Model model){
        return "index";
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.GET)
    public String insertarAtleta(Model model){
        model.addAttribute(new Atleta());

        return "insertar";
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST)
    public String insertarAtleta(Atleta atleta, BindingResult result, Model model){
        atletaService.save(atleta);
        insertarHistorial(atleta);
        return "index";
    }


    @RequestMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("atletas", atletaService.getAll());
        return "listar";
    }

    @RequestMapping("/verDetalle/{id}")
    public String verDetalle(Model model, @PathVariable long id){
        Optional<Atleta> atleta = atletaService.get(id);
        if (atleta.isPresent()){
            model.addAttribute("atleta", atleta.get());
            return "verDetalle";
        }
        return "notFound";
    }

    @RequestMapping("/verHistorico/{id}")
    public String verHistorico(Model model, @PathVariable long id){
        Optional<Atleta> atleta = atletaService.get(id);
        if (atleta.isPresent()){
            model.addAttribute("atleta", atleta.get());
            model.addAttribute("historial", historialService.getAllByAtleta(atleta.get()));
            return "verHistorico";
        }
        return "notFound";
    }

    @RequestMapping("/buscarAtleta")
    public String buscarAtleta(@RequestParam(value = "buscar", required = false) String buscar, Model model){
        if(buscar == null) {
            buscar = "1";
        }
        System.out.println(buscar);
        List<Atleta> atletas = atletaService.find(buscar, buscar, buscar);
        System.out.println(atletas.toString());
        model.addAttribute("atletas", atletas);

        return "buscarAtleta";

    }
    @RequestMapping("/actualizarInfo/{id}")
    public String actualizarInfo(Model model, @PathVariable long id){
        Optional<Atleta> atleta = atletaService.get(id);
        if (atleta.isPresent()){
            model.addAttribute("atleta", atleta.get());
            return "actualizarInfo";
        }
        return "notFound";
    }

    @RequestMapping(value = "/actualizarInfo/{id}", method = RequestMethod.POST)
    public String actualizarInfo(Atleta atleta, @PathVariable long id, BindingResult result, Model model){
        Optional<Atleta> atletaViejoOpc = atletaService.get(id);
        if (atletaViejoOpc.isPresent()){
            Atleta atletaNuevo = atletaViejoOpc.get();
            double pesoViejo = atletaNuevo.getPeso();
            atletaNuevo.setDireccion(atleta.getDireccion());
            atletaNuevo.setDistrito(atleta.getDistrito());
            atletaNuevo.setCanton(atleta.getCanton());
            atletaNuevo.setProvincia(atleta.getProvincia());
            atletaNuevo.setEmail(atleta.getEmail());
            atletaNuevo.setTelefono(atleta.getTelefono());
            atletaNuevo.setPeso(atleta.getPeso());
            if (pesoViejo != atleta.getPeso()){
                insertarHistorial(atletaNuevo);
            }
            atletaService.save(atletaNuevo);
            return "index";
        }
        return "notFound";
    }

    public void insertarHistorial(Atleta atleta){
        Historial historial = new Historial();
        historial.setAtleta(atleta);
        double estatura = atleta.getEstatura();
        double imc = Math.round(atleta.getPeso() / (estatura * estatura / 10000) * 100.0)/100.0 ;
        historial.setImc(imc);
        historial.setFecha(new Date(LocalDateTime.now().atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli()));
        historialService.save(historial);
    }






}
