package it.cosenonjaviste.alfresco.annotations.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// A simple annotation type.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
  String stringValue();

  int intValue();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
  String description();
}

@Retention(RetentionPolicy.RUNTIME)
@What(description = "An annotation test class")
@MyAnnotation(stringValue = "for class", intValue = 100)
@interface Which {

}

@Which
class Other {

}
@What(description = "An annotation test class")
@MyAnnotation(stringValue = "for class", intValue = 100)
public class MainClass {
  // Annotate a method.
  @What(description = "An annotation test method")
  @MyAnnotation(stringValue = "Annotation Example", intValue = 100)
  public static void myMethod(String str, int i) {
  }

  public static void main(String[] arg) {
    try {
      MainClass ob = new MainClass();
      Annotation[] annos = ob.getClass().getAnnotations();
      
      System.out.println("All annotations for Meta2:");
      for(Annotation a : annos)
        System.out.println(a);


      Other o = new Other();
      Annotation[] annotations = o.getClass().getAnnotations();
      for(Annotation a : annotations) {
          System.out.println(a);
          final Annotation[] annotations1 = a.getClass().getAnnotations();
          for (Annotation a1 : annotations1) {
              System.out.println(a1);
          }
      }



    } catch (Exception exc) {
    }
  }
}