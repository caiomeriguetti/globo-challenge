import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getUsers(name) {

    return this.http.get("/api/user/" + name, {
      "headers": {"Authorization": "Basic Y2FpbzoxMjM0"}
    });
  }
}
