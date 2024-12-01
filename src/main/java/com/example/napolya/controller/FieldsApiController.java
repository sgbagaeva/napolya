package com.example.napolya.controller;

import jakarta.annotation.Generated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@Controller
public class FieldsApiController implements FieldsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FieldsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
