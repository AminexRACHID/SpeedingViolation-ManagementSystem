package org.miaad.immatriculationservice.web.graphQL;


import org.miaad.immatriculationservice.dto.ProprietaireRequestDTO;
import org.miaad.immatriculationservice.entities.Proprietaire;
import org.miaad.immatriculationservice.repository.ProprietaireRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class ProprietaireGraphQLController {
    private ProprietaireRepository proprietaireRepository;

    public ProprietaireGraphQLController(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @QueryMapping
    public List<Proprietaire> getProprietaires(){
        return proprietaireRepository.findAll();
    }

    @QueryMapping
    public Proprietaire getProprietaireById(@Argument Long id){
        return proprietaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Proprietaire %s not found ! ", id)));
    }

    @MutationMapping
    public Proprietaire addProprietaire(@Argument ProprietaireRequestDTO proprietaire){
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
        Proprietaire o = new Proprietaire();
        o.setNom(proprietaire.getNom());
        o.setEmail(proprietaire.getEmail());
        o.setDateNaissance(proprietaire.getDateNaissance());
        return proprietaireRepository.save(o);
    }

    @MutationMapping
    public Boolean deleteProprietaire(@Argument Long id){
        proprietaireRepository.deleteById(id);
        return true;
    }
}
