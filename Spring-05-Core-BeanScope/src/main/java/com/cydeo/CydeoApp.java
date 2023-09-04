package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
   //Always the runner class must be under the top package
   public static void main(String[] args) {
       Comment comment=new Comment();
       comment.setAuthor("Johnson");
       comment.setText("Spring Framework");

       ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);


      /* CommentService cs1 = context.getBean(CommentService.class);
       CommentService cs2 = context.getBean(CommentService.class);
       //When you run as you see they have the same object hash-code
       System.out.println(cs1);
       System.out.println(cs2);
       System.out.println(cs1==cs2);*/
   }

}
