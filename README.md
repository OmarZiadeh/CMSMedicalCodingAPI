# MedicalCodingAPI
Backend Spring application that lists out CMS HCPCS Medical Code terminology in a REST API in JSON format

# Description
This project creates a REST API in JSON format listing out the CMS HCPCS codes listed at these links:

https://www.cms.gov/medicare/regulations-guidance/physician-self-referral/list-cpt/hcpcs-codes

https://www.cms.gov/apps/ama/license.asp?file=/files/zip/list-codes-effective-january-1-2024-published-november-29-2023.zip

It specifically works with the Excel file provided by the above links.
The program is NOT hardcoded to the Excel file, and is meant to dynamically grab any extra codes created listed under sections using a mixture of Regex and detecting title names(the title name section is hardcoded however).
Everything is listed out in a JSON format for ease of parsing, and each code acts as a key with the description as a value.

Codes have been separated depending on section, all codes, or a specific code, more information can be found in the API Link list

# Getting Started
# Dependencies
This was created in VSCode with the Spring Boot framework(version 3.1.8) provided by VMWare
Maven project
All dependencies are listed in the pom.xml, for your convenience they're listed below:
- Apache POI
- Apache POI OOXML
- Spring Boot framework
- JSON Simple

# Installation
- You WILL need to change the String PATH variable listed in the "Constants.java" file to the location of the Excel file listed at cms.gov

# API Link list
Full list of API links depending on localhost:
- http://localhost:8080/api/AllCodes
- http://localhost:8080/api/ClinicalLabCodes
- http://localhost:8080/api/TherapyCodes
- http://localhost:8080/api/RadiologyCodes
- http://localhost:8080/api/RadiationCodes
- http://localhost:8080/api/PreventativeCodes
- http://localhost:8080/api/{specificCode}
  
# Executing program
- Execute the "MedicalCoding.java" file within the project
- Use Postman or a web browser to GET the JSON data listed in API Link list
  
