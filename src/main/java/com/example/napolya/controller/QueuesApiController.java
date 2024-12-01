package com.example.napolya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@Controller
public class QueuesApiController implements QueuesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public QueuesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
