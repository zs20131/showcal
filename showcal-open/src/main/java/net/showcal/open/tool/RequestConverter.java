package net.showcal.open.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xiniunet.apiframework.AbstractApiRequest;
import com.xiniunet.apiframework.response.ErrorResponse;
import com.xiniunet.apiframework.security.MainError;
import com.xiniunet.apiframework.security.SubError;
import com.xiniunet.apiframework.security.SubErrorType;
import com.xiniunet.apiframework.security.SubErrors;
import com.xiniunet.apiframework.session.Session;
import com.xiniunet.framework.base.BaseRequest;
import com.xiniunet.framework.security.Passport;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniunet.api.tool
 *  Description:
 * ***************************************************************
 *  2014/11/21  V1.0  xiniunet    New Files for com.xiniunet.api.tool
 * </pre>
 */
@Service
public class RequestConverter {
    private static Validator validator;
    private static final Map<String, SubErrorType> INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS = new LinkedHashMap<String, SubErrorType>();

    static {
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("typeMismatch",
                SubErrorType.ISV_PARAMETERS_MISMATCH);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("NotNull",
                SubErrorType.ISV_MISSING_PARAMETER);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("NotEmpty",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Size",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Range",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Pattern",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Min",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Max",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("DecimalMin",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("DecimalMax",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Digits",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Past",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("Future",
                SubErrorType.ISV_INVALID_PARAMETE);
        INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS.put("AssertFalse",
                SubErrorType.ISV_INVALID_PARAMETE);
    }

    /**
     * 将参数转换为契约的Request对象
     *
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    public <T> T converter(Class<T> clazz, AbstractApiRequest request) {
        if (clazz != null) {
            try {
                T newT = (T) clazz.newInstance();
                BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                Map<String, String> parameters = request.getApiRequestContext().getAllParams();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    if (parameters.containsKey(key)) {
                        Object value = parameters.get(key);
                        if(value==null||"null".equals(value)){
                            continue;
                        }
                        // 得到property对应的setter方法
                        Method setter = property.getWriteMethod();
                        //获取参数
                        Class<?> typeClass = property.getPropertyType();
                        if (String.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, value.toString());
                        } else if (Long.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Long.valueOf(value.toString()));
                        } else if (int.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Integer.valueOf(value.toString()));
                        } else if (boolean.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Boolean.valueOf(value.toString()));
                        } else if (Boolean.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Boolean.valueOf(value.toString()));
                        } else if (Double.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Double.valueOf(value.toString()));
                        } else if (Integer.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Integer.valueOf(value.toString()));
                        } else if (Long.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Long.valueOf(value.toString()));
                        } else if (Float.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Float.valueOf(value.toString()));
                        } else if (Short.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, Short.valueOf(value.toString()));
                        } else if (Number.class.isAssignableFrom(typeClass)) {
                            setter.invoke(newT, (Number) value);
                        } else if (Date.class.isAssignableFrom(typeClass)) {

                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            setter.invoke(newT, format.parse(value.toString()));
                        } else if (Enum.class.isAssignableFrom(typeClass)) {
                            Class<? extends Enum> enumType = (Class<Enum>) typeClass;
                            setter.invoke(newT, Enum.valueOf(enumType, value.toString()));

                        } else if (List.class.isAssignableFrom(typeClass)) {
                            //使用通用方法解决
                            Field field = getDeclaredField(clazz, key);
                            Type type = field.getGenericType();
                            Class genericClazz = null;
                            if (type instanceof ParameterizedType) {
                                ParameterizedType pt = (ParameterizedType) type;
                                genericClazz = (Class) pt.getActualTypeArguments()[0];
                            }
                            if (genericClazz != null) {
                                //如果取不到泛型，则直接返回该数据为null
                                String valuestr = value.toString().replace("\\","");
                                System.out.println(valuestr);
                                List list = JSON.parseArray(valuestr, genericClazz);
                                setter.invoke(newT, list);
                            }

                        } else if (Set.class.isAssignableFrom(typeClass)) {
                            Field field = getDeclaredField(clazz, key);
                            Type type = field.getGenericType();
                            Class genericClazz = null;
                            if (type instanceof ParameterizedType) {
                                ParameterizedType pt = (ParameterizedType) type;
                                genericClazz = (Class) pt.getActualTypeArguments()[0];
                            }
                            if (genericClazz != null) {
                                String valuestr = value.toString().replace("\\","");
                                List list = JSON.parseArray(valuestr, genericClazz);
                                Set set = new HashSet();
                                for (Object obj : list) {
                                    set.add(obj);
                                }
                                setter.invoke(newT, set);
                            }
                        } else if (typeClass.isArray()) {
                            //数组解包
                            JSONArray array = JSON.parseArray(value.toString());
                            Object[] jsonArray = array.toArray();
                            Object t = Array.newInstance(typeClass.getComponentType(), jsonArray.length);
                            for (int i = 0; i < jsonArray.length; i++) {
                                Array.set(t, i, jsonArray[i]);
                            }
                            setter.invoke(newT, t);
                        } else {
                            //非基本型参数，使用JSON格式化
                            String valuestr = value.toString().replace("\\","");
                            Object obj = JSON.parseObject(valuestr, typeClass);
                            setter.invoke(newT, obj);
                        }

                    }
                }
                return newT;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Field getDeclaredField(Class<?> clazz, String fieldName) {
        Field field = null;

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了

            }
        }

        return null;
    }

    /**
     * 参数校验
     *
     * @param webRequest
     * @param request
     * @return
     */
    public ErrorResponse doValidate(HttpServletRequest webRequest, BaseRequest request) {
        // TODO 将ids转为List后，此处的验证无法通过，因为类型不匹配
        return null;
//        ServletRequestDataBinder dataBinder = new ServletRequestDataBinder(request, "bindObject");
//        dataBinder.setValidator(getValidator());
//        dataBinder.bind(webRequest);
//        dataBinder.validate();
//        List<ObjectError> errorList = dataBinder.getBindingResult().getAllErrors();
//        // 将Bean数据绑定时产生的错误转换为Api的错误
//        if (errorList != null && errorList.size() > 0) {
//            return new ErrorResponse(toMainErrorOfSpringValidateErrors(errorList,
//                    webRequest.getLocale()));
//        } else {
//            return null;
//        }
    }

    private MainError toMainErrorOfSpringValidateErrors(
            List<ObjectError> allErrors, Locale locale) {
        if (hastSubErrorType(allErrors, SubErrorType.ISV_MISSING_PARAMETER)) {
            return getBusinessParameterMainError(allErrors, locale,
                    SubErrorType.ISV_MISSING_PARAMETER);
        } else if (hastSubErrorType(allErrors,
                SubErrorType.ISV_PARAMETERS_MISMATCH)) {
            return getBusinessParameterMainError(allErrors, locale,
                    SubErrorType.ISV_PARAMETERS_MISMATCH);
        } else {
            return getBusinessParameterMainError(allErrors, locale,
                    SubErrorType.ISV_INVALID_PARAMETE);
        }
    }

    private MainError getBusinessParameterMainError(
            List<ObjectError> allErrors, Locale locale,
            SubErrorType subErrorType) {
        MainError mainError = SubErrors.getMainError(subErrorType, locale);
        for (ObjectError objectError : allErrors) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                SubErrorType tempSubErrorType = INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS
                        .get(fieldError.getCode());
                if (tempSubErrorType == subErrorType) {

                    String subErrorCode = SubErrors.getSubErrorCode(
                            tempSubErrorType, fieldError.getField(),
                            fieldError.getRejectedValue());

                    SubError subError = SubErrors.getSubError(subErrorCode,
                            tempSubErrorType.value(), locale,
                            fieldError.getField(),
                            fieldError.getRejectedValue());
                    mainError.addSubError(subError);
                }
            }
        }
        return mainError;
    }


    private boolean hastSubErrorType(List<ObjectError> allErrors,
                                     SubErrorType subErrorType1) {
        for (ObjectError objectError : allErrors) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                if (INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS
                        .containsKey(fieldError.getCode())) {
                    SubErrorType tempSubErrorType = INVALIDE_CONSTRAINT_SUBERROR_MAPPINGS
                            .get(fieldError.getCode());
                    if (tempSubErrorType == subErrorType1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Validator getValidator() {
        if (this.validator == null) {
            LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
            localValidatorFactoryBean.afterPropertiesSet();
            this.validator = localValidatorFactoryBean;
        }
        return this.validator;
    }

    public Passport requestToPassport(AbstractApiRequest request) {
        Session session = request.getApiRequestContext().getSession();
        Passport passport = new Passport();
        if (session != null) {
            passport = (Passport) session.getAttribute("passport");
        }
//        PassportGetRequest passportGetRequest = new PassportGetRequest();
//        passportGetRequest.setId(Long.valueOf(passportid));
//        System.out.println("passportid : " + passportid);
//        PassportGetResponse passportGetResponse = securityService.getPassport(passportGetRequest);
        return passport;
    }

}
