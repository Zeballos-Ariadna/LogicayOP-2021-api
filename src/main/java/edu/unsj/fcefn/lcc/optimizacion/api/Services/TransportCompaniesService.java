package edu.unsj.fcefn.lcc.optimizacion.api.Services;

import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.TransportCompanyDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Entities.TransportCompanyEntity;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Mappers.TransportCompaniesMapper;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Repositories.TransportCompaniesRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TransportCompaniesService {

    @Autowired
    TransportCompaniesRepository transportCompaniesRepository;

    @Autowired
    TransportCompaniesMapper transportCompaniesMapper;

    public List<TransportCompanyDTO> findAll(){
        return transportCompaniesRepository
                .findAll()
                .stream()
                .map(transportCompanyEntity -> transportCompaniesMapper.entityToDTO(transportCompanyEntity))
                .collect(Collectors.toList());
    }


    public TransportCompanyDTO find(Integer id){
        return transportCompaniesRepository
                .findById(id)
                .map(transportCompanyEntity -> transportCompaniesMapper.entityToDTO(transportCompanyEntity))
                .orElse(null);
    }


    public TransportCompanyDTO add(TransportCompanyDTO transportCompanyDTO){
        TransportCompanyEntity transportCompanyEntity = transportCompaniesMapper.dtoToEntity(transportCompanyDTO);
        transportCompanyEntity = transportCompaniesRepository.save(transportCompanyEntity);
        return transportCompaniesMapper.entityToDTO(transportCompanyEntity);
    }


    public TransportCompanyDTO edit(TransportCompanyDTO transportCompanyDTO){
        TransportCompanyEntity transportCompanyEntity = transportCompaniesMapper.dtoToEntity(transportCompanyDTO);
        transportCompanyEntity = transportCompaniesRepository.save(transportCompanyEntity);
        return transportCompaniesMapper.entityToDTO(transportCompanyEntity);
    }


    public TransportCompanyDTO delete(Integer id) throws Exception{
        Optional<TransportCompanyEntity> transportCompanyEntityOptional= transportCompaniesRepository.findById(id);
        if(transportCompanyEntityOptional.isPresent()) {
            transportCompaniesRepository.deleteById(id);
            return transportCompaniesMapper.entityToDTO(transportCompanyEntityOptional.get());
        }
        else{
            throw new Exception("TransportCompany not found");
        }
    }


}
