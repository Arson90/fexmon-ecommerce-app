import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {Cart} from "../../types/cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private apiUrl = environment.apiBaseUrl;
  constructor(public http: HttpClient) {
  }

  public addProductToCart(productId: number): Observable<Cart> {
    console.log("Test" + productId);
    return this.http.put<Cart>(`${this.apiUrl}/cart/product/${productId}`, null);
  }

  public getCartById(cartId: number): Observable<Cart> {
    return this.http.get<Cart>(`${this.apiUrl}/cart/${cartId}`)
  }
  public getAllCart(): Observable<Cart[]> {
    return this.http.get<Cart[]>(`${this.apiUrl}/cart`);
  }
}
