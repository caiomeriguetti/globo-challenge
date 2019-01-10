import { Component, ViewChild, ElementRef} from '@angular/core';
import { UserService } from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  currentSubscription = null;
  userFound = null;
  userData = null;

  @ViewChild('searchInput') searchInput: ElementRef;

  constructor(private userService: UserService) {
  }

  renderData(data) {
    this.userData = data;
    this.userFound = true;
  }

  renderError(error) {
    switch(error.status) {
      case 404:
        this.userFound = false;
      break;
    }
  }

  onKeydown(event) {

    var self = this;

    if (event.key === "Enter") {

      if (this.currentSubscription) {
        this.currentSubscription.unsubscribe();
      }

      this.currentSubscription = this.userService.getUsers(event.target.value)
      .subscribe(
        data => self.renderData(data),
        error => self.renderError(error)
      );

    }

  }
}
