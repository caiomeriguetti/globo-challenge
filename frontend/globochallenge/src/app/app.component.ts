import { Component, ViewChild} from '@angular/core';
import { UserService } from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'globochallenge';

  @ViewChild('searchInput') searchInput: ElementRef;

  userService:UserService

  constructor(private userService: UserService) {
    this.userService = userService;
  }

  onKeydown(event) {
    console.log(event.target.value);
    var x;
    this.userService.getUsers()
     .subscribe((data) => x = data);

    console.log(x);
  }
}
