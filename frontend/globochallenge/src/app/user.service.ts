import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers() {

    return this.http.get("/api/user/caio", {
      "headers": {"Authorization": "Basic Y2FpbzoxMjM0"}
    });
  }
}
