import { Injectable } from '@angular/core';
	import { HttpClient, HttpHeaders } from '@angular/common/http';
	import { Citizen } from './citizen';
	import { Observable } from 'rxjs';
	 
	@Injectable()
	export class CitizenService {
	 
	  private usersUrl: string;
	 
	  constructor(private http: HttpClient) {
	    this.usersUrl = 'http://localhost:8080/citizens';
	  }
	 
	  public findAll(): Observable<Citizen[]> {
	    return this.http.get<Citizen[]>(this.usersUrl);
	  }
	 
	  public save(user: Citizen) {
	    return this.http.post<Citizen>(this.usersUrl, user);
	  }

	  public put(user: Citizen) {
	    return this.http.put<Citizen>(this.usersUrl, user);
	  }
	}