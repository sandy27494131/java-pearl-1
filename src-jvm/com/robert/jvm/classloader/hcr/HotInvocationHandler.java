package com.robert.jvm.classloader.hcr;

import java.lang.reflect.Method;
  
  
/** 
 * 拦截java方法，更新新的类 
 * @author xuwei 
 * Jul 9, 2008 12:02:26 PM 
 */  
public class HotInvocationHandler extends DefaultInvocationHandler {  
  
    private ClassManager manager;  
  
    public HotInvocationHandler(ClassManager manager) {  
        this.manager = manager;  
    }  
  
    /** 
     * 在调用类时判断该类是否重新编译过，如编译过则调用新类的方法 
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object targetObject = null;  
        Class c = target.getClass();  
        Class cNew = manager.reloadClass(c);  
        if (cNew == null) {  
            targetObject = target;  
        } else {  
            targetObject = cNew.newInstance();  
            this.setTarget(targetObject);  
        }  
        Object returnValue = method.invoke(targetObject, args);  
        return returnValue;  
    }  
  
}  
