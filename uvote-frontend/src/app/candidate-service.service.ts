import { Injectable } from '@angular/core';
	import { HttpClient, HttpHeaders } from '@angular/common/http';
	import { Candidate } from './candidate';
	import { Observable } from 'rxjs';
	 
	@Injectable()
	export class CandidateService {
	 
	  private candidatesUrl: string;
	 
	  constructor(private http: HttpClient) {
		this.candidatesUrl = 'http://localhost:8080/candidates/';
	  }
	 
	  public findAll(): Observable<Candidate[]> {
	    return this.http.get<Candidate[]>(this.candidatesUrl);
	  }

	  public findAllByCategory(): Observable<Candidate[]> {
	    return this.http.get<Candidate[]>(this.candidatesUrl);
	  }
	 
	  public save(user: Candidate) {
	    return this.http.post<Candidate>(this.candidatesUrl, user);
	  }

	  public put(user: Candidate) {
	    return this.http.put<Candidate>(this.candidatesUrl, user);
	  }
	}