# Ustr-challenge uvote

## Technologies
* Java 11
* Spring Boot, Spring WEB, H2, JPA
* Angular


## Resources
  
* PUT /vote/citizenId/candidateId
* GET /citizens 
* GET /citizens/id
* POST /citizens body {"tituloEleitoral": 0, "hasVoted": false }
* DELETE /citizens/id
* PUT /citizens/id body {"tituloEleitoral": 0, "hasVoted": false }
* GET /candidates
* GET /candidates/id
* GET /candidates/category/(Presidente || Senadores || DeputadosFederais || Governadores || DeputadosEstaduais)
* POST /candidates body { "category": "Presidente", "name": "", "votes": 0, "candidateNumber": 0 }
* DELETE /candidates/id
* PUT /candidates/id body { "category": "Presidente", "name": "", "votes": 0, "candidateNumber": 0 }
