import { Routes } from '@angular/router';
import { LivreList } from './pages/livre-list/livre-list';

export const routes: Routes = [
  { path: '', redirectTo: 'livres', pathMatch: 'full' },
  { path: 'livres', component: LivreList },
];