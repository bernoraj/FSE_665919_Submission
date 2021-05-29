import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map,catchError, retry  } from 'rxjs/operators';
import { environment } from '../environments/environment';
const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class FacadeService {

  constructor(private http:HttpClient) { }

  getStats():any{
 
    return this.http.get(API_URL+"/company/getall");
  }

  getStock(companyCode:string,startDate:string,endDate:string):any{
    return this.http.get(API_URL+"/stock/get/"+companyCode+"/"+startDate+"/"+endDate);
  }

  addCompany(obj: any):any{
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(obj);
    console.log(body)
    return this.http.post(API_URL+"/company/register",body,{'headers':headers});
  }
}
