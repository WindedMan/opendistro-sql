package com.amazon.opendistroforelasticsearch.jdbc.types;

import java.sql.SQLException;
import java.util.Map;



public class VarBinaryType implements TypeHelper<Byte[]>{

    public static final VarBinaryType INSTANCE = new VarBinaryType();

    public VarBinaryType(){

    }

    @Override
    public Byte[] fromValue(Object value, Map<String, Object> conversionParams) throws SQLException {
        if(value == null){
            return null;
        }else {
            return asByteArray(value.toString().getBytes());
        }

    }

    private Byte[] asByteArray(byte[] byteArray){
        Byte[] bytes = new Byte[byteArray.length];
        int num = 0;
        for(byte b :byteArray) bytes[num++]=b;
        return bytes;
    }

    @Override
    public String getTypeName() {
        return "VarBinary";
    }
}
