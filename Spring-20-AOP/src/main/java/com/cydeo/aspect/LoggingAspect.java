package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect
//When I put @Aspect, spring will not create a bean for this class.
//We add @Configuration for pluggable configuration
//We will build all business logic inside of this class.
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    // Which place I want to monitor? all course controller methods.
    //*-->no matter return type each will include
    //com.cydeo.controller--> adress of the packages.
    //.CourseController--> I want to get CourseController class method's information
    //.*(..)--> get all methods with any number of arguments.

/*  @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
  // It is how I am going to define this part? with advice like @Before
  private void pointcut(){}*/

   // Advices is associated with pointcut
//    @Before("pointcut()")
//    public void log(){
//      logger.info("Logger info ------");
//    } BELOW IS THE SAME IN ONE STEP :::*/
//   }

/*    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info ------");
    }*/
//Below, I want to get a specific method which is in repository.
//I have just one parameter, it is not important which type of parameter.
/*    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    private void anyProductRepositoryFindById(){}
// You can display any information  by using joinpoint methods. Like below joinpoint.getArgs()
    @Before("anyProductRepositoryFindById()")
    public void beforeCourseRepoOperation(JoinPoint joinPoint){
        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }*/

  /*  //within
    // syntax is different since it is class level we don't put return type
    //inside of the controller I want to get all classes
    @Pointcut("within(com.cydeo.controller..*)")
    private void anyControllerOperation(){}
//Whatever has service annotation I can log
    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceOperation(){
    }
    // Whatever requested I want to monitor before. I want to get log information
    // I want to display method,arguments and target object
    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }
*/

   /* @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteCourseOperation(){}

    @Before("anyDeleteCourseOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }*/
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}
    //Afterreturning works wit key=value principles.
    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
//        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
//    }

//    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
//    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
//        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

//    @After("anyGetCourseOperation()")
//    public void afterControllerAdvice(JoinPoint joinPoint) {
//        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
//    }

    /*@Pointcut("@annotation(com.cydeo.annotation.Loggable)")
    private void anyLoggableMethodOperation(){}*/

   /* @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before () -> Method : {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results =proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(),results.toString());
        return results;
    }
*/
}
