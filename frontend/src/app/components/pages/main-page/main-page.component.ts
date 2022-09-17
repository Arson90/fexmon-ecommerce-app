import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {Product} from "../../../types/product";
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  products: Product[];
  productById: Product;
  productName: string;
  price: number;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
    //this.getProductById(2);
  }

  public getProducts(): void {
   this.productService.getProducts().subscribe((response: Product[] ) => {
     this.products = response;
   });
  }

  public getProductById(productId: number): void {
    this.productService.getProductById(productId).subscribe((response: Product ) => {
      this.productById = response;
    });
  }

  public addProduct(addForm: NgForm): void {
    const productData: Product = {
      productName: addForm.value.productName,
      price: addForm.value.price
    };
    this.productService.addProduct(productData).subscribe((response: Product) => {
      this.productById = response;
    });
  }
}
