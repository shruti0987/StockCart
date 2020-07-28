import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashbpardComponent } from './dashbpard.component';

describe('DashbpardComponent', () => {
  let component: DashbpardComponent;
  let fixture: ComponentFixture<DashbpardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashbpardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashbpardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
