package Mutuelle.service;

import Mutuelle.model.LieuTrav;
import Mutuelle.payload.LieuTravRequest;
import Mutuelle.payload.LieuTravResponse;
import Mutuelle.repository.LieuTravRepository;
import Mutuelle.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LieuTravService {


    @Autowired
    private LieuTravRepository lieuTravRepository;


    private static final Logger logger = LoggerFactory.getLogger(LieuTravService.class);


    public List<LieuTravResponse> getAll()
    {

        return lieuTravRepository.findAll().stream().map(lieuTrav ->  ModelMapper.mapLieuTravToLieuTravResponse(lieuTrav)).collect(Collectors.toList());
    }

    public LieuTravResponse addLieuTrav(LieuTravRequest lieuTravRequest)
    {
        LieuTrav lieuTrav=new LieuTrav(lieuTravRequest) ;
        lieuTrav = lieuTravRepository.save(lieuTrav);
        return new LieuTravResponse(lieuTrav.getCode_li(),lieuTrav.getLib_lieu()) ;
    }
    public LieuTravResponse updateLieuTrav(LieuTrav lieuTrav)
    {

        lieuTrav = lieuTravRepository.save(lieuTrav);
        return new LieuTravResponse(lieuTrav.getCode_li(),lieuTrav.getLib_lieu()) ;
    }

    public LieuTravResponse getById (int id)
    {

        LieuTrav lieuTrav = lieuTravRepository.findById(id).get() ;
        System.out.println(lieuTrav);
        return LieuTravResponse.mapLieuTrav (lieuTrav) ;

    }

}
