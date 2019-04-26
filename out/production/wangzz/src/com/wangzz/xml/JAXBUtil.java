package com.wangzz.xml;

import com.wangzz.exception.XMLConvertException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.modelmbean.XMLParseException;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JAXBUtil {
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
        User user = new User(1,"宙哥", new BigDecimal(1.01).setScale(2, BigDecimal.ROUND_DOWN), strings,new Date());
        //JAXB.marshal(user, System.out);
        //User user = convertXmlToJavaBean(User.class, xmlStr);
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

        @XmlElement(name = "IDDDD")
        private Integer id;

        @XmlElement(name = "NAMEEE")
        private String name;

        @XmlElement(name = "BALLLL")
        private BigDecimal balance;

        @XmlElementWrapper(name = "cars")
        @XmlElement(name = "car")
        private List<String> cars;

        @XmlJavaTypeAdapter(JaxbDateAdapter.ONLY_DATE_FORMAT.class)
        @XmlElement(name = "BIRTH")
        private Date birthday;

    }

}
