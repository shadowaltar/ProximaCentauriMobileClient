package com.ageofaquarius.proximacentauri.gaming.entity;

import com.ageofaquarius.proximacentauri.R;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Mars on 2016-12-27.
 */
public class ResourceTypeTest {
    @Test
    public void getName() throws Exception {
        Class type = ResourceType.class;
        ResourceType instance = (ResourceType) type.newInstance();
        Method m = instance.getClass().getMethod("set"+"Name", String.class);
        m.invoke(instance, "RES_TEST");
        System.out.println( ResourceType.class.getSimpleName());
        assertTrue(instance.getName()=="RES_TEST");
    }

    @Test
    public void setName() throws Exception {

    }

    @Test
    public void getDisplayName() throws Exception {

    }

    @Test
    public void setDisplayName() throws Exception {

    }

}