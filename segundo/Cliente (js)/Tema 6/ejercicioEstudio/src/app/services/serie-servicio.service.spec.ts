import { TestBed } from '@angular/core/testing';

import { SerieServicioService } from './serie-servicio.service';

describe('SerieServicioService', () => {
  let service: SerieServicioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SerieServicioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
