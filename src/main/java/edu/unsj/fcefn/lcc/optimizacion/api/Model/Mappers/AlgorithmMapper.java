package edu.unsj.fcefn.lcc.optimizacion.api.Model.Mappers;

import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.FramesDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.StopsDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Services.FramesService;
import org.moeaframework.core.variable.Permutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlgorithmMapper {

    @Autowired
    FramesService framesService;

    public List<FramesDTO> permutationToDTO (Permutation permutation,List<StopsDTO> stops){
        List<FramesDTO> route = new ArrayList<>();
        for(int i=0;i < permutation.size() - 1;i++){
            Integer departureStopId = stops.get(i).getId();
            Integer arrivalStopId = stops.get(i + 1).getId();
            FramesDTO frame = framesService
                    .findByIdDepartureStopAndIdArrivalStop(departureStopId,arrivalStopId)
                    .stream()
                    .findFirst()
                    .get();

            route.add(frame);
        }
        return route;
    }
}
