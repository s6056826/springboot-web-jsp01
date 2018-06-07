package cn.dbw.springboot.springbootwebjsp.service;

import cn.dbw.springboot.springbootwebjsp.controller.BaseController;
import cn.dbw.springboot.springbootwebjsp.utils.SpringContextUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * mybatis 通用service
 * @author by：dbw
 * @param <T>
 */
public abstract class BaseService<T> {

    private Class mapperClass=null;
    private Class<T> argumentClazz=null;

    /**
     * 添加
     * @param t
     * @return
     */
    public T add(T t){
        Object bean = getApplicationContext().getBean(getMapperType());
        try {
            Method insert = getMapperType().getMethod("insertSelective", getTypeArguement());
            insert.setAccessible(true);
            insert.invoke(bean,t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        Object bean = getApplicationContext().getBean(getMapperType());
        try {
            Method insert = getMapperType().getMethod("deleteByPrimaryKey", Long.class);
            insert.setAccessible(true);
            insert.invoke(bean,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param t
     * @return
     */
    public T update(T t){
        Object bean = getApplicationContext().getBean(getMapperType());
        try {
            Method insert = getMapperType().getMethod("updateByPrimaryKeySelective", getTypeArguement());
            insert.setAccessible(true);
            insert.invoke(bean,t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }



    public T newinstance(Map map){
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(map));
        return   jsonObject.toJavaObject(getTypeArguement());
    }


    /**
     * 返回子类泛型参数类型
     * @return
     */
    public Class<T> getTypeArguement(){
        if(null==argumentClazz){
          this.argumentClazz = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return  argumentClazz;
    }

    /**
     * 获取子类Mapper Class
     * @return
     */
    public Class getMapperType()  {
        if(null==mapperClass){
            Type type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            String mapperClassName= type.toString().split(" ")[1].replace("po","mapper")+"Mapper";
            try {
                this.mapperClass=Class.forName(mapperClassName);
                return mapperClass;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            return mapperClass;
        }
        return null;
    }

    /**
     * 获取spring容器
     * @return
     */
    public ApplicationContext getApplicationContext(){
         return  SpringContextUtils.getApplicationContext();
    }
}
