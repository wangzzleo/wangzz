package com.wangzz.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangzz
 * 自定义日期格式转换方式
 */
public class JaxbDateAdapter {

    /**
     * 格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static class StandardDateFormat extends XmlAdapter<String, Date> {

        static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null) {
                return null;
            }

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(v);
        }

        @Override
        public String marshal(Date v)  {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

    /**
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    public static class NoMSStandardDateFormat extends XmlAdapter<String, Date> {

        static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null) {
                return null;
            }

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(v);
        }

        @Override
        public String marshal(Date v) {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

    /**
     * 格式：yyyy-MM-dd_HH:mm:ss
     */
    public static class UnderlineDateFormat extends XmlAdapter<String, Date> {

        static String DATE_FORMAT = "yyyy-MM-dd_HH:mm:ss";

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null) {
                return null;
            }

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(v);
        }

        @Override
        public String marshal(Date v) {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

    /**
     * 格式：yyyy-MM-dd
     */
    public static class OnlyDateFormat extends XmlAdapter<String, Date> {

        static final String DATE_FORMAT = "yyyy-MM-dd";

        @Override
        public Date unmarshal(String v) throws Exception {
            if (v == null) {
                return null;
            }

            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(v);
        }

        @Override
        public String marshal(Date v) {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

}
