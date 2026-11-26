import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Livre } from '../models/livre';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class LivreService {
  private http = inject(HttpClient);
  lister(): Observable<Livre[]> {
    return this.http.get<Livre[]>(`${environment.apiUrl}/livres`);
  }
}
