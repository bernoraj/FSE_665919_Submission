import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {FacadeService} from '../facade.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-addcompany',
  templateUrl: './addcompany.component.html',
  styleUrls: ['./addcompany.component.scss']
})
export class AddcompanyComponent implements OnInit {
  addCompanyForm!: FormGroup;
  
  constructor(private facadeService:FacadeService) { }

  ngOnInit(): void {
    this.addCompanyForm = new FormGroup({
      'name': new FormControl(null, [Validators.required,Validators.pattern("[a-zA-Z ]*")]),
      'code': new FormControl(null,[Validators.minLength(5),Validators.required,Validators.pattern("[0-9]*")]),
      'CEOname': new FormControl(null, [Validators.required,Validators.pattern("[a-zA-Z ]*")]),
      'website': new FormControl(null, [Validators.required,Validators.pattern("[a-z.]*")]),
      'turnover': new FormControl(null, [Validators.minLength(11),Validators.required,Validators.pattern("[0-9]*")]),
      'stockex': new FormControl(null, Validators.required)
      
    });
  }

  onSubmit(){
    
    const obj={
      'companyCode':this.addCompanyForm.value.code,
      'companyName':this.addCompanyForm.value.name,
      'companyCEO':this.addCompanyForm.value.CEOname,
      'companyWebsite':this.addCompanyForm.value.website,
      'companyTurnover':this.addCompanyForm.value.turnover,
      'stockEx':this.addCompanyForm.value.stockex
    }

    this.facadeService.addCompany(obj).subscribe((data:any)=>{
      
       if(data){
          alert("Data added Successfully");
       }
    });

  }

}
