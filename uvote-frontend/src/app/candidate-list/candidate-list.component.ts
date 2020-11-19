import { Component, OnInit } from '@angular/core';
	import { Candidate } from '../candidate';
	import { CandidateService } from '../candidate-service.service';
	 
	@Component({
	  selector: 'app-candidate-list',
	  templateUrl: './candidate-list.component.html',
	  styleUrls: ['./candidate-list.component.css']
	})
	export class CandidateListComponent implements OnInit {
	 
	  candidate: Candidate[];
	 
	  constructor(private candidateService: CandidateService) {
	  }
	 
	  ngOnInit() {
	    this.candidateService.findAll().subscribe(data => {
	      this.candidate = data;
	    });
	  }
	}