import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
    providedIn: 'root'
})

export class AuthGuard implements CanActivate {

    constructor(private router: Router) { }

    canActivate(): boolean {
        const isLoggedIn = sessionStorage.getItem('isLoggedIn');

        if (isLoggedIn === 'true') {
            return true; // Allow access to the route
        } else {
            this.router.navigate(['/login']); // Redirect to login page if not logged in
            return false; // Block access to the route
        }
    }

}