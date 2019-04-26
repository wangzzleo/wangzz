package com.wangzz.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JaxbDateAdapter {

    public static class STANDARM_DATE_FORMAT extends XmlAdapter<String, Date> {

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
        public String marshal(Date v) throws Exception {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

    public static class ONLY_DATE_FORMAT extends XmlAdapter<String, Date> {

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
        public String marshal(Date v) throws Exception {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.format(v);
        }
    }

}
