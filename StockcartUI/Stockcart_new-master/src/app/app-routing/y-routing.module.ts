import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SectorlistComponent } from '../sectorlist/sectorlist.component';
import { LoginComponent } from '../login/login.component';
import { DashbpardComponent } from '../dashboard/dashbpard.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';


const routes: Routes = [{ path: '', component:DashbpardComponent , pathMatch: 'full'},
  {path:'login', component: LoginComponent },
  {path:'sectorlist', component:SectorlistComponent},
  { path: 'log_out', component:DashbpardComponent },
  {path:'**',component: PageNotFoundComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class YRoutingModule { }
