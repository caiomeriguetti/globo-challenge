import { Component, ViewChild, ElementRef} from '@angular/core';
import { UserService } from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'globochallenge';

  @ViewChild('searchInput') searchInput: ElementRef;

  constructor(private userService: UserService) {
  }

  onKeydown(event) {
    var x;
    this.userService.getUsers()
     .subscribe((data) => x = data);

    console.log(x);
  }
}
