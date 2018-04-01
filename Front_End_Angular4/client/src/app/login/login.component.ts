import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

import { AuthService } from '../app-service/auth.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    this.authService.auth(form.value.user_name, form.value.password).subscribe(
      data => {
        console.log(data);
        // sessionStorage.setItem("sessionID", data.sessionID);
      },
      error => {
        console.log(error);
      }
    );
  }

}
