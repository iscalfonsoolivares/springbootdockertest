package com.aowebdev.springbootdockertest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
// import org.springframework.util.ResourceUtils;
// import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// import java.io.File;
// import java.io.FileInputStream;
import java.io.IOException;
// import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@ControllerAdvice
public class NotFoundHandler {

    private static final Logger log = LoggerFactory.getLogger(NotFoundHandler.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> renderDefaultPage() {
        try {
            ClassPathResource cpr = new ClassPathResource("static/assets/index.html");
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            String body = new String(bdata, StandardCharsets.UTF_8);
            return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(body);
        } catch (IOException e) {
            log.warn("IOException", e);
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error completing the action.");
        }
    }
}