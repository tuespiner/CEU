import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoArticuloComponent } from './listado-articulo.component';

describe('ListadoArticuloComponent', () => {
  let component: ListadoArticuloComponent;
  let fixture: ComponentFixture<ListadoArticuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListadoArticuloComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoArticuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
