import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Product} from "../../../types/product";
import {ProductService} from "../../../services/product/product.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit{
  products: Product[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  public getProducts(): void {
    this.productService.getProducts().subscribe((response: Product[] ) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      });
  }
//note: how to use subscribe with next and error
  public deleteProduct(productId: number): void {
    if(confirm('Do you want to delete this Product ?')) {
      this.productService.deleteProduct(productId).subscribe(() => {
        this.getProducts();
      },
        (error: HttpErrorResponse) => {
          alert(error.message);
        });
    }
  }
}
