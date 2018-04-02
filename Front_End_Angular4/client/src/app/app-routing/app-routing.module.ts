import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { HomeComponent } from '../home/home.component';
import { PostComponent } from '../post/post.component';
import { NotFoundComponent } from '../not-found/not-found.component';

const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent},
    { path: 'posts', component: PostComponent },
    { path: 'post/:post_id', component: PostComponent },
    { path: 'oops', component: NotFoundComponent },
    {path: '**', redirectTo: '/oops'}
]

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [ RouterModule ]
  })
export class AppRoutingModule { }