package com.robert.jvm.classloader.hcr;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
* 默认代理处理类 
* @author Robert 
*/  
public class DefaultInvocationHandler implements InvocationHandler {  

  /** 
   * 目标对象 
   */  
  protected Object target;  

  public DefaultInvocationHandler() {  
    
  }  

  /** 
   * 处理方法 
   */  
  public Object invoke(Object proxy, Method method, Object[] args)  
          throws Throwable {  
      System.out.println("before invoke");  
      Object returnValue = method.invoke(target, args);  
      System.out.println("after invoke");  
      return returnValue;  
  }  

  public Object getTarget() {  
      return target;  
  }  

  public void setTarget(Object target) {  
      this.target = target;  
  }  
}  
