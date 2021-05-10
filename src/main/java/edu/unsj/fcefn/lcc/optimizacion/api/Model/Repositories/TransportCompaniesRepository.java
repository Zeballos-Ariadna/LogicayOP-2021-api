package edu.unsj.fcefn.lcc.optimizacion.api.Model.Repositories;

import edu.unsj.fcefn.lcc.optimizacion.api.Model.Entities.TransportCompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportCompaniesRepository extends CrudRepository <TransportCompanyEntity, Integer> {

    List<TransportCompanyEntity> findAll();
}
