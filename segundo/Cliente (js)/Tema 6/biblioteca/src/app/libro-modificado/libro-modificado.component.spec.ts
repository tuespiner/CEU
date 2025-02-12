import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroModificadoComponent } from './libro-modificado.component';

describe('LibroModificadoComponent', () => {
  let component: LibroModificadoComponent;
  let fixture: ComponentFixture<LibroModificadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroModificadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibroModificadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
