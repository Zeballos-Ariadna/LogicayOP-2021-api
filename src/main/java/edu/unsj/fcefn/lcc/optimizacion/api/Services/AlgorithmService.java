package edu.unsj.fcefn.lcc.optimizacion.api.Services;

import edu.unsj.fcefn.lcc.optimizacion.api.Algorithm.RoutingProblem;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.FramesDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.StopsDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Mappers.AlgorithmMapper;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.variable.Permutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AlgorithmService {

    @Autowired
    AlgorithmMapper algorithmMapper;

    @Autowired
    StopsService stopsService;

    List<StopsDTO> stops;

    @PostConstruct
    private void init(){
        stops = stopsService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(StopsDTO::getRanking).reversed())
                .collect(Collectors.toList())
                .subList(0, 20);
    }

    public List<StopsDTO> getStops(){
        return stops;
    }

    public List<FramesDTO> execute(){
        NondominatedPopulation population = new Executor()
                .withAlgorithm("NSGAII")
                .withProblemClass(RoutingProblem.class)
                .withMaxEvaluations(10000)
                .run();

        return StreamSupport
                .stream(population.spliterator(), false)
                .map(solution -> (Permutation)solution.getVariable(0))
                .map(permutation -> algorithmMapper.permutationToDTO(permutation, stops))
                .findFirst()
                .orElse(new ArrayList<>());
    }
}
