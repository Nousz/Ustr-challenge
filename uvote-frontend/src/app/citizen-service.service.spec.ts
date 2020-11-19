import { TestBed } from '@angular/core/testing';

import { CitizenServiceService } from './citizen-service.service';

describe('CitizenServiceService', () => {
  let service: CitizenServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CitizenServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
