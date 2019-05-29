package com.wangzz.xml;

import com.wangzz.exception.XMLConvertException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.*;

public class JAXBUtil {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "STATUS")
    public static class CommonResponseStatus {
        /**
         * 处理结果码
         * 0表示正常，其余均为异常
         */
        @XmlElement(name = "CODE")
        private String code;

        /**
         * 处理结果等级(INFO/WARN/ERROR)
         */
        @XmlElement(name = "SEVERITY")
        private String severity;

        /**
         * 信息描述
         */
        @XmlElement(name = "MESSAGE")
        private String message;
    }


    public static void main(String[] args) throws Exception {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<USER>\n" +
                "    <balance>1.01</balance>\n" +
                "    <IDDD>1</IDDD>\n" +
                "</USER>";

        ArrayList<String> strings = new ArrayList<>();
        strings.add("宝马");
        strings.add("宝马2");
        strings.add("宝马3");
        List<User.Test> map = new ArrayList<>();
        User.Test test = new User.Test();
        test.setTest("asdfsdf");
        map.add(test);
        User user = new User(new CommonResponseStatus("1", "2", "3"), 1,"宙哥", new BigDecimal(1.01).setScale(2, BigDecimal.ROUND_DOWN), strings,new Date(), null);
        //JAXB.marshal(user, System.out);
        User user1 = convertXmlToJavaBean(User.class, xmlStr);
        System.out.println(convertJavabeanToXml(user));
    }


    public static <T> T convertXmlToJavaBean(Class<T> clazz, String xmlString) throws XMLConvertException {
        try(StringReader stringReader = new StringReader(xmlString)) {
            return JAXB.unmarshal(stringReader, clazz);
        } catch (Exception e) {
            throw new XMLConvertException("XML 格式错误!" + e.getMessage());
        }
    }

    public static <T> String convertJavabeanToXml(T bean) throws XMLConvertException {
        try(StringWriter stringWriter = new StringWriter()) {
            JAXB.marshal(bean, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            throw new XMLConvertException(e.getMessage());
        }

    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "USER")
    private static class User {

        @XmlElement(name = "STATUS")
        private CommonResponseStatus status;

        @XmlElement(name = "IDDDD")
        private Integer id;

        @XmlElement(name = "NAMEEE")
        private String name;

        @XmlElement(name = "BALLLL")
        private BigDecimal balance;

       // @XmlElementWrapper(name = "CARSS")
        @XmlElement(name = "CAR")
        private List<String> cars;

        //@XmlJavaTypeAdapter(JaxbDateAdapter.ONLY_DATE_FORMAT.class)
        @XmlElement(name = "BIRTH")
        private Date birthday;

        @XmlElement(name = "map")
        private Test map;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Test {
            @XmlElement(name = "test")
            private String test;
        }
    }


}
