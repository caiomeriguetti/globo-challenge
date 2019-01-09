import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  http:HttpClient

  constructor(private http: HttpClient) {
    this.http = http;
  }

  getUsers() {

    var headers_object = new HttpHeaders();
    headers_object.append("Authorization", "Basic " + btoa("caio:1234"));

    const httpOptions = {
      headers: headers_object
    };

    return this.http.get("https://localhost:9443/api/user/caio", httpOptions);
  }
}
