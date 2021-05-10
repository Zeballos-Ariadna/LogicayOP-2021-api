package edu.unsj.fcefn.lcc.optimizacion.api.Services;

import edu.unsj.fcefn.lcc.optimizacion.api.Algorithm.RoutingProblem;
import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.FramesDTO;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgorithmService {

    public List<FramesDTO> execute(){
        NondominatedPopulation population = new Executor()
                .withAlgorithm("NSGAII")
                .withProblemClass(RoutingProblem.class)
                .withMaxEvaluations(10000)
                .run();
    }
}
