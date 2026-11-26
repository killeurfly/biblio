import { Component, inject, OnInit, signal } from '@angular/core';
import { LivreService } from '../../services/livre';
import { Livre } from '../../models/livre';

@Component({ selector: 'app-livre-list', templateUrl: './livre-list.html' })
export class LivreList implements OnInit {
  private service = inject(LivreService);
  livres = signal<Livre[]>([]);
  erreur = signal('');

  ngOnInit() {
    this.service.lister().subscribe({
      next: l => this.livres.set(l),
      error: () => this.erreur.set('Impossible de charger les livres.'),
    });
  }
}
