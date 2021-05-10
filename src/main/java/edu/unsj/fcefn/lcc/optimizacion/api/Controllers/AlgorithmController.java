package edu.unsj.fcefn.lcc.optimizacion.api.Controllers;

import edu.unsj.fcefn.lcc.optimizacion.api.Model.Domain.FramesDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.Services.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Autowired
    AlgorithmService algorithmService;

    @GetMapping(value = "run")
    public List<FramesDTO> execute(){
       return algorithmService.execute();
    }
}
