import { TestBed } from '@angular/core/testing';

import { LivreService } from './livre';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

describe('Livre', () => {
  let service: LivreService;
  let http: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [provideHttpClient(), provideHttpClientTesting()] });
    service = TestBed.inject(LivreService);
    http = TestBed.inject(HttpTestingController);
  });
  afterEach(() => http.verify());

  it('appelle GET /livres', () => {
    service.lister().subscribe(l => expect(l.length).toBe(1));
    const req = http.expectOne(`${environment.apiUrl}/livres`);
    expect(req.request.method).toBe('GET');
    req.flush([{ id: 1, titre: 'Clean Code', auteur: 'Martin', isbn: '9780132350884', annee: 2008 }]);
  });
});
