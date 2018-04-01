import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable()
export class AuthService {

  private url: string = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  auth(user_name:string, password:string) {
    return this.httpClient.post(this.url+"/auth/login", {user_name: user_name, password:password});
  }

}
