package com.wangzz.rpc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SerialTest {

    public static <T> byte[] serialize(T t){
        byte[] data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            HessianOutput output = new HessianOutput(os);
            output.writeObject(t);
            data = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static <T> byte[] serialize2(T t){
        byte[] data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Hessian2Output output = new Hessian2Output(os);
            output.writeObject(t);
            output.getBytesOutputStream().flush();
            output.completeMessage();
            output.close();
            data = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static <T> byte[] jdkSerialize(T t){
        byte[] data = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream output = new ObjectOutputStream(os);
            output.writeObject(t);
            output.flush();
            output.close();
            data = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] data){
        if(data==null){
            return null;
        }
        Object result = null;
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(data);
            HessianInput input = new HessianInput(is);
            result = input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize2(byte[] data){
        if(data==null){
            return null;
        }
        Object result = null;
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(data);
            Hessian2Input input = new Hessian2Input(is);
            result = input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student implements Serializable {
        int id;
        String name;
        String sex;
    }

    public static void main(String[] args) {
        Student stu = new Student(1,"hessian","boy");
        byte[] obj = serialize(stu);
        System.out.println("hessian serialize result length = "+obj.length);
        byte[] obj2 = serialize2(stu);
        System.out.println("hessian2 serialize result length = "+obj2.length);
        byte[] other = jdkSerialize(stu);
        System.out.println("jdk serialize result length = "+other.length);
        Student student = deserialize2(obj2);
        System.out.println("deserialize result entity is "+student);
    }

}
