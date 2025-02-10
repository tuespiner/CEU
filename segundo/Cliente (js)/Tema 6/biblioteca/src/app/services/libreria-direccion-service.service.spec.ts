import { TestBed } from '@angular/core/testing';

import { LibreriaDireccionServiceService } from './libreria-direccion-service.service';

describe('LibreriaDireccionServiceService', () => {
  let service: LibreriaDireccionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibreriaDireccionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
