import { Component, ViewChild, ElementRef} from '@angular/core';
import { UserService } from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'globochallenge';
  currentResult = null;

  @ViewChild('searchInput') searchInput: ElementRef;

  constructor(private userService: UserService) {
  }

  renderData(data) {
    console.log(data);
  }

  renderError(error) {
    console.log("ERROR");
  }

  onKeydown(event) {

    var self = this;

    if (event.key === "Enter") {

      if (this.currentResult) {
        this.currentResult.unsubscribe();
      }

      this.currentResult = this.userService.getUsers(event.target.value);
      this.currentResult.subscribe(
        data => self.renderData(data),
        error => self.renderError(error)
      );

    }

  }
}
