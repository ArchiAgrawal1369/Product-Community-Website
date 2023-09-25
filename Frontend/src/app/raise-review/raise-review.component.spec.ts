import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RaiseReviewComponent } from './raise-review.component';

describe('RaiseReviewComponent', () => {
  let component: RaiseReviewComponent;
  let fixture: ComponentFixture<RaiseReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RaiseReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RaiseReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
