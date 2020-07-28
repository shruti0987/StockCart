import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {YRoutingModule} from './app-routing/y-routing.module';

import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { SectorlistComponent } from './sectorlist/sectorlist.component';
import { LoginComponent } from './login/login.component';
import { DashbpardComponent } from './dashboard/dashbpard.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SectorlistComponent,
    LoginComponent,
    DashbpardComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,FormsModule,YRoutingModule,NgModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
