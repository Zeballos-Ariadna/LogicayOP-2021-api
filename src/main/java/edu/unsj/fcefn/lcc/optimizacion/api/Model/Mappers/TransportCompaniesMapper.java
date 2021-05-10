package edu.unsj.fcefn.lcc.optimizacion.api.Model.Mappers;

import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.TransportCompanyDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Entities.TransportCompanyEntity;
import org.springframework.stereotype.Component;

@Component
public class TransportCompaniesMapper {

    public TransportCompanyDTO entityToDTO(TransportCompanyEntity transportCompanyEntity){
        TransportCompanyDTO transportCompanyDTO= new TransportCompanyDTO();
        transportCompanyDTO.setId(transportCompanyEntity.getId());
        transportCompanyDTO.setLogo(transportCompanyEntity.getLogo());
        transportCompanyDTO.setName(transportCompanyEntity.getName());
        return transportCompanyDTO;
    }

    public TransportCompanyEntity dtoToEntity(TransportCompanyDTO transportCompanyDTO){
        TransportCompanyEntity transportCompanyEntity= new TransportCompanyEntity();
        transportCompanyEntity.setId(transportCompanyDTO.getId());
        transportCompanyEntity.setLogo(transportCompanyDTO.getLogo());
        transportCompanyEntity.setName(transportCompanyDTO.getName());
        return transportCompanyEntity;
    }
}
