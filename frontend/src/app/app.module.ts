import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartPageComponent } from './components/pages/cart-page/cart-page.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { CheckoutPageComponent } from './components/pages/checkout-page/checkout-page.component';
import { ConfirmationPageComponent } from './components/pages/confirmation-page/confirmation-page.component';
import { RegistrationPageComponent } from './components/pages/registration-page/registration-page.component';
import { MainPageComponent } from './components/pages/main-page/main-page.component';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CartPageComponent,
    LoginPageComponent,
    CheckoutPageComponent,
    ConfirmationPageComponent,
    RegistrationPageComponent,
    MainPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
