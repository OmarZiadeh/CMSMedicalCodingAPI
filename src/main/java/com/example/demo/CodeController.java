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

    @GetMapping(value="/{endPoint}")
    public ResponseEntity<Object> getMethodName(@PathVariable String endPoint) throws Exception{
        JSONObject json = new JSONObject();

        //this is cached in service file
        APIService.iterateEntireFile(json);

        JSONObject singleJson = new JSONObject();
        singleJson.put(endPoint, json.get(endPoint));

        return new ResponseEntity<>(singleJson, HttpStatus.OK);
    }
    

    @GetMapping("/ClinicalLabCodes")
    public ResponseEntity<Object> ClinicalLabCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "CLINICAL LABORATORY SERVICES";
        String endTitle = "PHYSICAL THERAPY, OCCUPATIONAL THERAPY, AND OUTPATIENT SPEECH-LANGUAGE PATHOLOGY SERVICES";

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/TherapyCodes")
    public ResponseEntity<Object> TherapyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "PHYSICAL THERAPY, OCCUPATIONAL THERAPY, AND OUTPATIENT SPEECH-LANGUAGE PATHOLOGY SERVICES";
        String endTitle = "RADIOLOGY AND CERTAIN OTHER IMAGING SERVICES";

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiologyCodes")
    public ResponseEntity<Object> RadiologyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "RADIOLOGY AND CERTAIN OTHER IMAGING SERVICES";
        String endTitle = "RADIATION THERAPY SERVICES AND SUPPLIES";;

        APIService.iterateFileTitles(title, endTitle, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiationCodes")
    public ResponseEntity<Object> RadiationCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "RADIATION THERAPY SERVICES AND SUPPLIES";
        String endTitle = "PREVENTIVE SCREENING TESTS AND VACCINES";

        APIService.iterateFileTitles(title, endTitle, json);
        
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/PreventativeCodes")
    public ResponseEntity<Object> PreventativeCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "PREVENTIVE SCREENING TESTS AND VACCINES";
        
        APIService.iterateLastSection(title, json);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
