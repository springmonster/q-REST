package uk.co.aquaq.kdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.aquaq.kdb.request.FunctionRequest;
import uk.co.aquaq.kdb.request.QueryRequest;
import uk.co.aquaq.kdb.service.KdbService;


@RestController
public class KdbController {

    @Autowired
    KdbService kdbService;

    @Value("${freeform.query.mode.enabled}")
    boolean freeFormQueryEnabled;

    //    @CrossOrigin
    @RequestMapping(value = "/executeFunction", method = RequestMethod.POST)
    public Object executeFunction(@RequestBody FunctionRequest functionRequest) {
        return kdbService.executeFunction(functionRequest);
    }

    //    @CrossOrigin
    @RequestMapping(value = "/executeQuery", method = RequestMethod.POST)
    public Object executeQuery(@RequestBody QueryRequest queryRequest) {
        if (freeFormQueryEnabled) {
            return kdbService.executeQuery(queryRequest);
        } else {
            throw new InvalidRequestException("Invalid Request Free form queries not enabled.");
        }
    }
}
