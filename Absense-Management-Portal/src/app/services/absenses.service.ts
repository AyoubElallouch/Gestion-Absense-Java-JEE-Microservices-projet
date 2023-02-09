import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AbsensesService {

  constructor(private http: HttpClient) { }

  public getAbsenses():Observable<any>{
    return this.http.get(environment.backendHost + "ABSENSE-SERVICE/absenses");
  }
  public getAbsenseById(id:number){
    return this.http.get(environment.backendHost + "ABSENSE-SERVICE/absenses/"+id);
  }
  public deleteAbsense(id: number){
    return this.http.delete(environment.backendHost + "ABSNESE-SERVICE/absenses/"+id);
  }
  public updateAbsense(id:number, absense:any){
    return this.http.put(environment.backendHost + "ABSNESE-SERVICE/absenses/"+id, absense);
  }
  public saveAbsense(absense: any){
    return this.http.post(environment.backendHost + "ABSNESE-SERVICE/absenses/", absense);
  }
}
