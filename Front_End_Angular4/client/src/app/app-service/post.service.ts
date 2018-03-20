import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../post';

@Injectable()
export class PostService {

  private url: string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getPosts() {
    return this.http.get<Post[]>(this.url+"/api/posts");
  }

  getPost(post_id: string) {
    return this.http.get<Post>(this.url+"/api/post/"+post_id);
  }
}
