package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CodeController {

    

    @GetMapping("/AllCodes")
    public ResponseEntity<Object> AllCodes() throws Exception{
        JSONObject json = new JSONObject();
        
        APIService.iterateEntireFile(json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(value="/searchCode/{endPoint}")
    public ResponseEntity<Object> getMethodName(@PathVariable String endPoint) throws Exception{
        JSONObject json = new JSONObject();

        //this is cached in service file
        APIService.iterateEntireFile(json);

        JSONObject singleJson = new JSONObject();

        //some basic error handling
        if(json.get(endPoint) != null){
            singleJson.put(endPoint, json.get(endPoint));
        }
        else{
            JSONObject errorJson = new JSONObject();
            errorJson.put("Invalid Code HTTP 400 Error", "The code " + endPoint + " does not exist");
            return new ResponseEntity<>(errorJson, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(singleJson, HttpStatus.OK);
    }

    @GetMapping("/ClinicalLabCodes")
    public ResponseEntity<Object> ClinicalLabCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = Constants.CLINICALLAB;
        String endTitle = Constants.THERAPYSERVICES;

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/TherapyCodes")
    public ResponseEntity<Object> TherapyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = Constants.THERAPYSERVICES;
        String endTitle = Constants.RADIOLOGYANDIMAGING;

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiologyCodes")
    public ResponseEntity<Object> RadiologyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = Constants.RADIOLOGYANDIMAGING;
        String endTitle = Constants.RADIATION;

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiationCodes")
    public ResponseEntity<Object> RadiationCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = Constants.RADIATION;
        String endTitle = Constants.PREVENTATIVE;

        APIService.iterateFileTitles(title, endTitle, json);
        
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/PreventativeCodes")
    public ResponseEntity<Object> PreventativeCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = Constants.PREVENTATIVE;
        
        APIService.iterateLastSection(title, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
