import { Component, OnInit } from '@angular/core';
//import { List1 } from '../list';
import { Listfrommock } from '../mocklist';
import { Listfromlist } from '../list';
//import { ApiService } from '../api.service';

@Component({
  selector: 'app-sectorlist',
  templateUrl: './sectorlist.component.html',
  styleUrls: ['./sectorlist.component.css']
})
export class SectorlistComponent implements OnInit {

  
  //constructor(private apiService: ApiService) { }
constructor() {}
  lists = Listfrommock;
  selectedHero: Listfromlist;
//   selected:any;
// filtered :any;
  //   stat = [
  //       { value:"Automobiles",id:"123" },
  //       { value: "Banking", id:"12" },
  //       { value: "Financial Services" ,id:"45"},
  //       { value: "Information Technology",id:"56" },
  //       { value: "Energy - Oil & Gas",id:"57" }];

  //   status = ['Select Status', 'Automobiles', 'Banking', 'Financial Services', 'Information Technology', 'Energy - Oil & Gas'];



  // constructor() { }

  // ngOnInit(): void {
  // }
  // onOptionsSelected() {
  //   console.log(this.selected); 
  //   this.filtered = this.stat.filter(t=>t.value ==this.selected);

  // }


  ngOnInit() {
  }

  onSelect(listselected: Listfromlist): void {
    this.selectedHero = listselected;
  }
}





// @Component({
//   selector: 'app-heroes',
//   templateUrl: './heroes.component.html',
//   styleUrls: ['./heroes.component.css']
// })

// export class HeroesComponent implements OnInit {

//   heroes = HEROES;
//   selectedHero: Hero;

//   constructor() { }

//   ngOnInit() {
//   }

//   onSelect(hero: Hero): void {
//     this.selectedHero = hero;
//   }
// }