import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing/app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PostComponent } from './post/post.component';
import { PostService } from './app-service/post.service';
import { NotFoundComponent } from './not-found/not-found.component';

import { ChopPipe } from './pipe/chop.pipe';
import { AuthService } from './app-service/auth.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    PostComponent,
    NotFoundComponent,
    ChopPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [PostService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
