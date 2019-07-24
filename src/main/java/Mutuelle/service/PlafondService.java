package Mutuelle.service;

import Mutuelle.model.Plafond;
import Mutuelle.payload.PlafondRequest;
import Mutuelle.payload.PlafondResponse;
import Mutuelle.repository.PlafondRepository;
import Mutuelle.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlafondService {
    @Autowired
    private PlafondRepository plafondRepository;


    private static final Logger logger = LoggerFactory.getLogger(PlafondService.class);


    public List<PlafondResponse> getAll()
    {

        return plafondRepository.findAll().stream().map(plafond ->  ModelMapper.mapPlafondToPlafondResponse(plafond)).collect(Collectors.toList());
    }

    public PlafondResponse addPlafond(PlafondRequest plafondRequest)
    {
        Plafond plafond=new Plafond(plafondRequest) ;
        plafond = plafondRepository.save(plafond);
        return new PlafondResponse(plafond.getCode_pl(),plafond.getMontant()) ;
    }
    public PlafondResponse updatePlafond(Plafond plafond)
    {

        plafond = plafondRepository.save(plafond);
        return new PlafondResponse(plafond.getCode_pl(),plafond.getMontant()) ;
    }

    public PlafondResponse getById (int id)
    {

        Plafond plafond = plafondRepository.findById(id).get() ;
        System.out.println(plafond);
        return PlafondResponse.mapPlafond(plafond) ;

    }
}
