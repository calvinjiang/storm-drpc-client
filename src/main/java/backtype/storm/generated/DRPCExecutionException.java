package backtype.storm.generated;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DRPCExecutionException extends Exception
	implements
	org.apache.thrift7.TBase<DRPCExecutionException, DRPCExecutionException._Fields>,
	java.io.Serializable, Cloneable {
    private static final org.apache.thrift7.protocol.TStruct STRUCT_DESC = new org.apache.thrift7.protocol.TStruct(
	    "DRPCExecutionException");

    private static final org.apache.thrift7.protocol.TField MSG_FIELD_DESC = new org.apache.thrift7.protocol.TField(
	    "msg", org.apache.thrift7.protocol.TType.STRING, (short) 1);

    private String msg; // required

    /**
     * The set of fields this struct contains, along with convenience methods
     * for finding and manipulating them.
     */
    public enum _Fields implements org.apache.thrift7.TFieldIdEnum {
	MSG((short) 1, "msg");

	private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

	static {
	    for (_Fields field : EnumSet.allOf(_Fields.class)) {
		byName.put(field.getFieldName(), field);
	    }
	}

	/**
	 * Find the _Fields constant that matches fieldId, or null if its not
	 * found.
	 */
	public static _Fields findByThriftId(int fieldId) {
	    switch (fieldId) {
	    case 1: // MSG
		return MSG;
	    default:
		return null;
	    }
	}

	/**
	 * Find the _Fields constant that matches fieldId, throwing an exception
	 * if it is not found.
	 */
	public static _Fields findByThriftIdOrThrow(int fieldId) {
	    _Fields fields = findByThriftId(fieldId);
	    if (fields == null)
		throw new IllegalArgumentException("Field " + fieldId
			+ " doesn't exist!");
	    return fields;
	}

	/**
	 * Find the _Fields constant that matches name, or null if its not
	 * found.
	 */
	public static _Fields findByName(String name) {
	    return byName.get(name);
	}

	private final short _thriftId;
	private final String _fieldName;

	_Fields(short thriftId, String fieldName) {
	    _thriftId = thriftId;
	    _fieldName = fieldName;
	}

	public short getThriftFieldId() {
	    return _thriftId;
	}

	public String getFieldName() {
	    return _fieldName;
	}
    }

    // isset id assignments

    public static final Map<_Fields, org.apache.thrift7.meta_data.FieldMetaData> metaDataMap;
    static {
	Map<_Fields, org.apache.thrift7.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift7.meta_data.FieldMetaData>(
		_Fields.class);
	tmpMap.put(_Fields.MSG, new org.apache.thrift7.meta_data.FieldMetaData(
		"msg", org.apache.thrift7.TFieldRequirementType.REQUIRED,
		new org.apache.thrift7.meta_data.FieldValueMetaData(
			org.apache.thrift7.protocol.TType.STRING)));
	metaDataMap = Collections.unmodifiableMap(tmpMap);
	org.apache.thrift7.meta_data.FieldMetaData.addStructMetaDataMap(
		DRPCExecutionException.class, metaDataMap);
    }

    public DRPCExecutionException() {
    }

    public DRPCExecutionException(String msg) {
	this();
	this.msg = msg;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public DRPCExecutionException(DRPCExecutionException other) {
	if (other.is_set_msg()) {
	    this.msg = other.msg;
	}
    }

    public DRPCExecutionException deepCopy() {
	return new DRPCExecutionException(this);
    }

    @Override
    public void clear() {
	this.msg = null;
    }

    public String get_msg() {
	return this.msg;
    }

    public void set_msg(String msg) {
	this.msg = msg;
    }

    public void unset_msg() {
	this.msg = null;
    }

    /**
     * Returns true if field msg is set (has been assigned a value) and false
     * otherwise
     */
    public boolean is_set_msg() {
	return this.msg != null;
    }

    public void set_msg_isSet(boolean value) {
	if (!value) {
	    this.msg = null;
	}
    }

    public void setFieldValue(_Fields field, Object value) {
	switch (field) {
	case MSG:
	    if (value == null) {
		unset_msg();
	    } else {
		set_msg((String) value);
	    }
	    break;

	}
    }

    public Object getFieldValue(_Fields field) {
	switch (field) {
	case MSG:
	    return get_msg();

	}
	throw new IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been assigned
     * a value) and false otherwise
     */
    public boolean isSet(_Fields field) {
	if (field == null) {
	    throw new IllegalArgumentException();
	}

	switch (field) {
	case MSG:
	    return is_set_msg();
	}
	throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
	if (that == null)
	    return false;
	if (that instanceof DRPCExecutionException)
	    return this.equals((DRPCExecutionException) that);
	return false;
    }

    public boolean equals(DRPCExecutionException that) {
	if (that == null)
	    return false;

	boolean this_present_msg = true && this.is_set_msg();
	boolean that_present_msg = true && that.is_set_msg();
	if (this_present_msg || that_present_msg) {
	    if (!(this_present_msg && that_present_msg))
		return false;
	    if (!this.msg.equals(that.msg))
		return false;
	}

	return true;
    }

    @Override
    public int hashCode() {
	HashCodeBuilder builder = new HashCodeBuilder();

	boolean present_msg = true && (is_set_msg());
	builder.append(present_msg);
	if (present_msg)
	    builder.append(msg);

	return builder.toHashCode();
    }

    public int compareTo(DRPCExecutionException other) {
	if (!getClass().equals(other.getClass())) {
	    return getClass().getName().compareTo(other.getClass().getName());
	}

	int lastComparison = 0;
	DRPCExecutionException typedOther = (DRPCExecutionException) other;

	lastComparison = Boolean.valueOf(is_set_msg()).compareTo(
		typedOther.is_set_msg());
	if (lastComparison != 0) {
	    return lastComparison;
	}
	if (is_set_msg()) {
	    lastComparison = org.apache.thrift7.TBaseHelper.compareTo(this.msg,
		    typedOther.msg);
	    if (lastComparison != 0) {
		return lastComparison;
	    }
	}
	return 0;
    }

    public _Fields fieldForId(int fieldId) {
	return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift7.protocol.TProtocol iprot)
	    throws org.apache.thrift7.TException {
	org.apache.thrift7.protocol.TField field;
	iprot.readStructBegin();
	while (true) {
	    field = iprot.readFieldBegin();
	    if (field.type == org.apache.thrift7.protocol.TType.STOP) {
		break;
	    }
	    switch (field.id) {
	    case 1: // MSG
		if (field.type == org.apache.thrift7.protocol.TType.STRING) {
		    this.msg = iprot.readString();
		} else {
		    org.apache.thrift7.protocol.TProtocolUtil.skip(iprot,
			    field.type);
		}
		break;
	    default:
		org.apache.thrift7.protocol.TProtocolUtil.skip(iprot,
			field.type);
	    }
	    iprot.readFieldEnd();
	}
	iprot.readStructEnd();
	validate();
    }

    public void write(org.apache.thrift7.protocol.TProtocol oprot)
	    throws org.apache.thrift7.TException {
	validate();

	oprot.writeStructBegin(STRUCT_DESC);
	if (this.msg != null) {
	    oprot.writeFieldBegin(MSG_FIELD_DESC);
	    oprot.writeString(this.msg);
	    oprot.writeFieldEnd();
	}
	oprot.writeFieldStop();
	oprot.writeStructEnd();
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("DRPCExecutionException(");
	boolean first = true;

	sb.append("msg:");
	if (this.msg == null) {
	    sb.append("null");
	} else {
	    sb.append(this.msg);
	}
	first = false;
	sb.append(")");
	return sb.toString();
    }

    public void validate() throws org.apache.thrift7.TException {
	// check for required fields
	if (!is_set_msg()) {
	    throw new org.apache.thrift7.protocol.TProtocolException(
		    "Required field 'msg' is unset! Struct:" + toString());
	}

    }

    private void writeObject(java.io.ObjectOutputStream out)
	    throws java.io.IOException {
	try {
	    write(new org.apache.thrift7.protocol.TCompactProtocol(
		    new org.apache.thrift7.transport.TIOStreamTransport(out)));
	} catch (org.apache.thrift7.TException te) {
	    throw new java.io.IOException(te);
	}
    }

    private void readObject(java.io.ObjectInputStream in)
	    throws java.io.IOException, ClassNotFoundException {
	try {
	    read(new org.apache.thrift7.protocol.TCompactProtocol(
		    new org.apache.thrift7.transport.TIOStreamTransport(in)));
	} catch (org.apache.thrift7.TException te) {
	    throw new java.io.IOException(te);
	}
    }

}