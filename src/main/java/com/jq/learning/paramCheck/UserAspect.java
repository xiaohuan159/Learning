package com.jq.learning.paramCheck;

import com.alibaba.fastjson.JSONObject;
import com.jq.learning.bean.Return;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


@Slf4j
@Aspect
@Component
public class UserAspect {
    private  static final Map<String,String> TESTJACKSON= Collections.unmodifiableMap(new HashMap<String, String>(){
        {
            put("zhangsan","长春");
            put("李四","北京");
        }
    });
    private static Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Before("execution(public * com.jq.learning.controller.JackSonController.list(..))")
//    @Before("execution(public * com.jq.learning.controller..*(..))")
    public String doBefore(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError error = result.getFieldError();
                   logger.error(error.getField()+error.getDefaultMessage());
                    Return.error(error.getField(), error.getDefaultMessage());
                }
            }
        }
        return joinPoint.toString();
    }
//    @Before("execution(public * com.jq.learning.controller.JackSonController.testJackSon(..))")
    public void checkTestJackSon(JoinPoint joinPoint) throws NoSuchMethodException {
        Object arg = joinPoint.getArgs()[0];
        String methodName = joinPoint.getSignature().getName();
        Method[] methods = joinPoint.getSignature().getDeclaringType().getMethods();
        Method testJackSon = joinPoint.getSignature().getDeclaringType().getMethod("testJackSon", JSONObject.class);

        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        String[] parameterNames = pnd.getParameterNames(testJackSon);
        assert parameterNames != null;
        String parameterName = parameterNames[0];
        String s = arg.toString();
        boolean matches = Pattern.matches("[a-zA-Z0-8\\s]*", s);
            if (!matches) {
//                result.addError(new ObjectError("name","字段校验不通过"));
//                FieldError error = result.getFieldError();
//                logger.error(error.getField()+error.getDefaultMessage());
                logger.error(joinPoint.getSignature().getName());
                Return.error(parameterName,"字段校验不通过");
            }

    }
    private static Map getFieldsName(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 参数值
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        for (int k = 0; k < args.length; k++) {
            if (!args[k].getClass().isPrimitive()) {
                // 获取的是封装类型而不是基础类型
                String result = args[k].getClass().getName();
                Class s = map.get(result);
                classes[k] = s == null ? args[k].getClass() : s;
            }
        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        // 获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        // 通过map封装参数和参数值
        HashMap<String, Object> paramMap = new HashMap();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }
    private static HashMap<String, Class> map = new HashMap<String, Class>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };
}