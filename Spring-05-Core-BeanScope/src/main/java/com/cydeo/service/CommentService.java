package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository; //we will not change the dependencies, so we put as a final
    private final CommentNotificationProxy commentNotificationProxy;
    //@Autowired since there is only one constructor, no need to put @Autowired
    //we need to initialize dependencies so, we need to create constructor
    //If you put @AllArgConstructor you don't need to create explicit constructor
   public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
       System.out.println("Hello");
    }
    // This is our business logic.
    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
