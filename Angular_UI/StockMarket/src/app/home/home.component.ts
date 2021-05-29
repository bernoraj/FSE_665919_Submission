import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {SelectionModel} from '@angular/cdk/collections';
import {FacadeService} from '../facade.service';
import {FormGroup, FormControl} from '@angular/forms';
import { DatePipe } from '@angular/common';
import {MatDialog} from '@angular/material/dialog';
import {AddcompanyComponent} from '../addcompany/addcompany.component';
import{SnackbarComponent}from '../snackbar/snackbar.component';
import {MatSnackBar} from '@angular/material/snack-bar';
import * as _ from 'lodash'

export interface Company {
  companyCEO: string;
  companyCode: number;
  companyTurnover: number;
  companyName: string;
  companyWebsite:string;
  stockEx:string;
}

export interface Stock{
  companyCode:number;
  currentDate:string,
  stockPrice:number
}



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  displayedColumns: string[] = ['companyCode','companyCEO', 'companyTurnover', 'companyName','companyWebsite','stockEx'];
  displayedColumnsStock:string[]=['companyCode','currentDate','stockPrice'];
  dataSource!: MatTableDataSource<Company>;
  dataSourceStock!:MatTableDataSource<Stock>;
  selection = new SelectionModel<Company>(false, []);
  dateRange=false;
  Minimum=0;
  Maximum=0;
  Average=0;
  listBtnLabel="Show all companies";
  range = new FormGroup({
    start: new FormControl(),
    end: new FormControl()
  });


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }



  constructor(private facadeService:FacadeService,private datePipe: DatePipe,private dialog: MatDialog,private _snackBar: MatSnackBar) { 


    
    this.facadeService.getStats().subscribe((data: Company[] | undefined)=>{
      this.dataSource=new MatTableDataSource(data);
    
    });

    this.selection.changed.subscribe((a) =>
    {
        if (a.added[0] && this.range.value.start!=null && this.range.value.end!=null)   // will be undefined if no selection
        {
            //alert('You selected ' + a.added[0].companyName);
            this.dateRange=false;
           var startDate= this.datePipe.transform(this.range.value.start,"yyyy-MM-dd")|| '{}';
           var endDate=this.datePipe.transform(this.range.value.end,"yyyy-MM-dd")|| '{}';
           this.facadeService.getStock(a.added[0].companyCode.toString(),startDate,endDate).subscribe((data:Stock[]|undefined)=>{
             
            this.dataSourceStock=new MatTableDataSource(data);
            var stockPriceList=(_.map(data, 'stockPrice'));
            if(stockPriceList!=[]){
              this.Minimum=_.min(stockPriceList)||0;
              this.Maximum=_.max(stockPriceList)||0;
              this.Average=_.mean(stockPriceList)||0;
            }
            else{
              this.Minimum=0;
              this.Maximum=0;
              this.Average=0;
            }
           });
        }else{
          this.dateRange=true;
        }
    });

  }

  openDialog() {
    const dialogRef = this.dialog.open(AddcompanyComponent);

    dialogRef.afterClosed().subscribe(result => {
      this.facadeService.getStats().subscribe((data: Company[] | undefined)=>{
        this.dataSource=new MatTableDataSource(data);
        
      });
    });
  }


  goToLink(url: string){
    window.open(url);
}

  ngOnInit(): void {
    
    


  }
  

}
