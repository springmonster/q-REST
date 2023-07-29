package uk.co.aquaq.kdb.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QueryRequest {

    private String query;
    private String type;
    private String response;
}


