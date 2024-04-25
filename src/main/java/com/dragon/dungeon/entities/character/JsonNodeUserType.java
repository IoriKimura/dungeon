// package com.dragon.dungeon.entities.character;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.hibernate.HibernateException;
// import org.hibernate.engine.spi.SharedSessionContractImplementor;
// import org.hibernate.usertype.UserType;

// import java.io.Serializable;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Types;
// import java.util.Objects;

// @SuppressWarnings("rawtypes")
// public class JsonNodeUserType implements UserType {

//     private final ObjectMapper objectMapper = new ObjectMapper();

//     @Override
//     public int getSqlType() {
//         return Types.OTHER;
//     }

//     @Override
//     public Class<?> returnedClass() {
//         return Object.class;
//     }

//     @Override
//     public boolean equals(Object x, Object y) {
//         return Objects.equals(x, y);
//     }

//     @Override
//     public int hashCode(Object x) {
//         return Objects.hashCode(x);
//     }
    
//     @Override
//     public Object nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner) throws SQLException {
//         String json = rs.getString(position);
//         if (json != null) {
//             try {
//                 return objectMapper.readTree(json);
//             } catch (Exception e) {
//                 throw new HibernateException("Failed to convert JSON string to JsonNode", e);
//             }
//         }
//         return null;
//     }
    

//     @Override
//     public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
//         if (value != null) {
//             try {
//                 String json = objectMapper.writeValueAsString(value);
//                 st.setObject(index, json, Types.OTHER);
//             } catch (Exception e) {
//                 throw new SQLException("Failed to convert object to JSON string", e);
//             }
//         } else {
//             st.setNull(index, Types.OTHER);
//         }
//     }

//     @Override
//     public Object deepCopy(Object value) {
//         if (value == null) {
//             return null;
//         }
//         try {
//             String json = objectMapper.writeValueAsString(value);
//             return objectMapper.readTree(json);
//         } catch (Exception e) {
//             throw new HibernateException("Failed to deep copy JsonNode", e);
//         }
//     }

//     @Override
//     public boolean isMutable() {
//         return true;
//     }

//     @Override
//     public Serializable disassemble(Object value) {
//         Object copy = deepCopy(value);
//         if (copy instanceof Serializable) {
//             return (Serializable) copy;
//         }
//         throw new UnsupportedOperationException("Value is not serializable: " + value);
//     }

//     @Override
//     public Object assemble(Serializable cached, Object owner) {
//         return deepCopy(cached);
//     }

//     @Override
//     public Object replace(Object original, Object target, Object owner) {
//         return deepCopy(original);
//     }

// }
