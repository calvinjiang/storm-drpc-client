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

public class DistributedRPC {

    public interface Iface {

	public String execute(String functionName, String funcArgs)
		throws DRPCExecutionException, org.apache.thrift7.TException;

    }

    public interface AsyncIface {

	public void execute(
		String functionName,
		String funcArgs,
		org.apache.thrift7.async.AsyncMethodCallback<AsyncClient.execute_call> resultHandler)
		throws org.apache.thrift7.TException;

    }

    public static class Client extends org.apache.thrift7.TServiceClient
	    implements Iface {
	public static class Factory implements
		org.apache.thrift7.TServiceClientFactory<Client> {
	    public Factory() {
	    }

	    public Client getClient(org.apache.thrift7.protocol.TProtocol prot) {
		return new Client(prot);
	    }

	    public Client getClient(
		    org.apache.thrift7.protocol.TProtocol iprot,
		    org.apache.thrift7.protocol.TProtocol oprot) {
		return new Client(iprot, oprot);
	    }
	}

	public Client(org.apache.thrift7.protocol.TProtocol prot) {
	    super(prot, prot);
	}

	public Client(org.apache.thrift7.protocol.TProtocol iprot,
		org.apache.thrift7.protocol.TProtocol oprot) {
	    super(iprot, oprot);
	}

	public String execute(String functionName, String funcArgs)
		throws DRPCExecutionException, org.apache.thrift7.TException {
	    send_execute(functionName, funcArgs);
	    return recv_execute();
	}

	public void send_execute(String functionName, String funcArgs)
		throws org.apache.thrift7.TException {
	    execute_args args = new execute_args();
	    args.set_functionName(functionName);
	    args.set_funcArgs(funcArgs);
	    sendBase("execute", args);
	}

	public String recv_execute() throws DRPCExecutionException,
		org.apache.thrift7.TException {
	    execute_result result = new execute_result();
	    receiveBase(result, "execute");
	    if (result.is_set_success()) {
		return result.success;
	    }
	    if (result.e != null) {
		throw result.e;
	    }
	    throw new org.apache.thrift7.TApplicationException(
		    org.apache.thrift7.TApplicationException.MISSING_RESULT,
		    "execute failed: unknown result");
	}

    }

    public static class AsyncClient extends
	    org.apache.thrift7.async.TAsyncClient implements AsyncIface {
	public static class Factory implements
		org.apache.thrift7.async.TAsyncClientFactory<AsyncClient> {
	    private org.apache.thrift7.async.TAsyncClientManager clientManager;
	    private org.apache.thrift7.protocol.TProtocolFactory protocolFactory;

	    public Factory(
		    org.apache.thrift7.async.TAsyncClientManager clientManager,
		    org.apache.thrift7.protocol.TProtocolFactory protocolFactory) {
		this.clientManager = clientManager;
		this.protocolFactory = protocolFactory;
	    }

	    public AsyncClient getAsyncClient(
		    org.apache.thrift7.transport.TNonblockingTransport transport) {
		return new AsyncClient(protocolFactory, clientManager,
			transport);
	    }
	}

	public AsyncClient(
		org.apache.thrift7.protocol.TProtocolFactory protocolFactory,
		org.apache.thrift7.async.TAsyncClientManager clientManager,
		org.apache.thrift7.transport.TNonblockingTransport transport) {
	    super(protocolFactory, clientManager, transport);
	}

	public void execute(
		String functionName,
		String funcArgs,
		org.apache.thrift7.async.AsyncMethodCallback<execute_call> resultHandler)
		throws org.apache.thrift7.TException {
	    checkReady();
	    execute_call method_call = new execute_call(functionName, funcArgs,
		    resultHandler, this, ___protocolFactory, ___transport);
	    this.___currentMethod = method_call;
	    ___manager.call(method_call);
	}

	public static class execute_call extends
		org.apache.thrift7.async.TAsyncMethodCall {
	    private String functionName;
	    private String funcArgs;

	    public execute_call(
		    String functionName,
		    String funcArgs,
		    org.apache.thrift7.async.AsyncMethodCallback<execute_call> resultHandler,
		    org.apache.thrift7.async.TAsyncClient client,
		    org.apache.thrift7.protocol.TProtocolFactory protocolFactory,
		    org.apache.thrift7.transport.TNonblockingTransport transport)
		    throws org.apache.thrift7.TException {
		super(client, protocolFactory, transport, resultHandler, false);
		this.functionName = functionName;
		this.funcArgs = funcArgs;
	    }

	    public void write_args(org.apache.thrift7.protocol.TProtocol prot)
		    throws org.apache.thrift7.TException {
		prot.writeMessageBegin(new org.apache.thrift7.protocol.TMessage(
			"execute",
			org.apache.thrift7.protocol.TMessageType.CALL, 0));
		execute_args args = new execute_args();
		args.set_functionName(functionName);
		args.set_funcArgs(funcArgs);
		args.write(prot);
		prot.writeMessageEnd();
	    }

	    public String getResult() throws DRPCExecutionException,
		    org.apache.thrift7.TException {
		if (getState() != org.apache.thrift7.async.TAsyncMethodCall.State.RESPONSE_READ) {
		    throw new IllegalStateException("Method call not finished!");
		}
		org.apache.thrift7.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift7.transport.TMemoryInputTransport(
			getFrameBuffer().array());
		org.apache.thrift7.protocol.TProtocol prot = client
			.getProtocolFactory().getProtocol(memoryTransport);
		return (new Client(prot)).recv_execute();
	    }
	}

    }

    public static class Processor<I extends Iface> extends
	    org.apache.thrift7.TBaseProcessor implements
	    org.apache.thrift7.TProcessor {
	private static final Logger LOGGER = LoggerFactory
		.getLogger(Processor.class.getName());

	public Processor(I iface) {
	    super(
		    iface,
		    getProcessMap(new HashMap<String, org.apache.thrift7.ProcessFunction<I, ? extends org.apache.thrift7.TBase>>()));
	}

	protected Processor(
		I iface,
		Map<String, org.apache.thrift7.ProcessFunction<I, ? extends org.apache.thrift7.TBase>> processMap) {
	    super(iface, getProcessMap(processMap));
	}

	private static <I extends Iface> Map<String, org.apache.thrift7.ProcessFunction<I, ? extends org.apache.thrift7.TBase>> getProcessMap(
		Map<String, org.apache.thrift7.ProcessFunction<I, ? extends org.apache.thrift7.TBase>> processMap) {
	    processMap.put("execute", new execute());
	    return processMap;
	}

	private static class execute<I extends Iface> extends
		org.apache.thrift7.ProcessFunction<I, execute_args> {
	    public execute() {
		super("execute");
	    }

	    protected execute_args getEmptyArgsInstance() {
		return new execute_args();
	    }

	    protected execute_result getResult(I iface, execute_args args)
		    throws org.apache.thrift7.TException {
		execute_result result = new execute_result();
		try {
		    result.success = iface.execute(args.functionName,
			    args.funcArgs);
		} catch (DRPCExecutionException e) {
		    result.e = e;
		}
		return result;
	    }
	}

    }

    public static class execute_args implements
	    org.apache.thrift7.TBase<execute_args, execute_args._Fields>,
	    java.io.Serializable, Cloneable {
	private static final org.apache.thrift7.protocol.TStruct STRUCT_DESC = new org.apache.thrift7.protocol.TStruct(
		"execute_args");

	private static final org.apache.thrift7.protocol.TField FUNCTION_NAME_FIELD_DESC = new org.apache.thrift7.protocol.TField(
		"functionName", org.apache.thrift7.protocol.TType.STRING,
		(short) 1);
	private static final org.apache.thrift7.protocol.TField FUNC_ARGS_FIELD_DESC = new org.apache.thrift7.protocol.TField(
		"funcArgs", org.apache.thrift7.protocol.TType.STRING, (short) 2);

	private String functionName; // required
	private String funcArgs; // required

	/**
	 * The set of fields this struct contains, along with convenience
	 * methods for finding and manipulating them.
	 */
	public enum _Fields implements org.apache.thrift7.TFieldIdEnum {
	    FUNCTION_NAME((short) 1, "functionName"), FUNC_ARGS((short) 2,
		    "funcArgs");

	    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

	    static {
		for (_Fields field : EnumSet.allOf(_Fields.class)) {
		    byName.put(field.getFieldName(), field);
		}
	    }

	    /**
	     * Find the _Fields constant that matches fieldId, or null if its
	     * not found.
	     */
	    public static _Fields findByThriftId(int fieldId) {
		switch (fieldId) {
		case 1: // FUNCTION_NAME
		    return FUNCTION_NAME;
		case 2: // FUNC_ARGS
		    return FUNC_ARGS;
		default:
		    return null;
		}
	    }

	    /**
	     * Find the _Fields constant that matches fieldId, throwing an
	     * exception if it is not found.
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
	    tmpMap.put(
		    _Fields.FUNCTION_NAME,
		    new org.apache.thrift7.meta_data.FieldMetaData(
			    "functionName",
			    org.apache.thrift7.TFieldRequirementType.DEFAULT,
			    new org.apache.thrift7.meta_data.FieldValueMetaData(
				    org.apache.thrift7.protocol.TType.STRING)));
	    tmpMap.put(
		    _Fields.FUNC_ARGS,
		    new org.apache.thrift7.meta_data.FieldMetaData(
			    "funcArgs",
			    org.apache.thrift7.TFieldRequirementType.DEFAULT,
			    new org.apache.thrift7.meta_data.FieldValueMetaData(
				    org.apache.thrift7.protocol.TType.STRING)));
	    metaDataMap = Collections.unmodifiableMap(tmpMap);
	    org.apache.thrift7.meta_data.FieldMetaData.addStructMetaDataMap(
		    execute_args.class, metaDataMap);
	}

	public execute_args() {
	}

	public execute_args(String functionName, String funcArgs) {
	    this();
	    this.functionName = functionName;
	    this.funcArgs = funcArgs;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public execute_args(execute_args other) {
	    if (other.is_set_functionName()) {
		this.functionName = other.functionName;
	    }
	    if (other.is_set_funcArgs()) {
		this.funcArgs = other.funcArgs;
	    }
	}

	public execute_args deepCopy() {
	    return new execute_args(this);
	}

	@Override
	public void clear() {
	    this.functionName = null;
	    this.funcArgs = null;
	}

	public String get_functionName() {
	    return this.functionName;
	}

	public void set_functionName(String functionName) {
	    this.functionName = functionName;
	}

	public void unset_functionName() {
	    this.functionName = null;
	}

	/**
	 * Returns true if field functionName is set (has been assigned a value)
	 * and false otherwise
	 */
	public boolean is_set_functionName() {
	    return this.functionName != null;
	}

	public void set_functionName_isSet(boolean value) {
	    if (!value) {
		this.functionName = null;
	    }
	}

	public String get_funcArgs() {
	    return this.funcArgs;
	}

	public void set_funcArgs(String funcArgs) {
	    this.funcArgs = funcArgs;
	}

	public void unset_funcArgs() {
	    this.funcArgs = null;
	}

	/**
	 * Returns true if field funcArgs is set (has been assigned a value) and
	 * false otherwise
	 */
	public boolean is_set_funcArgs() {
	    return this.funcArgs != null;
	}

	public void set_funcArgs_isSet(boolean value) {
	    if (!value) {
		this.funcArgs = null;
	    }
	}

	public void setFieldValue(_Fields field, Object value) {
	    switch (field) {
	    case FUNCTION_NAME:
		if (value == null) {
		    unset_functionName();
		} else {
		    set_functionName((String) value);
		}
		break;

	    case FUNC_ARGS:
		if (value == null) {
		    unset_funcArgs();
		} else {
		    set_funcArgs((String) value);
		}
		break;

	    }
	}

	public Object getFieldValue(_Fields field) {
	    switch (field) {
	    case FUNCTION_NAME:
		return get_functionName();

	    case FUNC_ARGS:
		return get_funcArgs();

	    }
	    throw new IllegalStateException();
	}

	/**
	 * Returns true if field corresponding to fieldID is set (has been
	 * assigned a value) and false otherwise
	 */
	public boolean isSet(_Fields field) {
	    if (field == null) {
		throw new IllegalArgumentException();
	    }

	    switch (field) {
	    case FUNCTION_NAME:
		return is_set_functionName();
	    case FUNC_ARGS:
		return is_set_funcArgs();
	    }
	    throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
	    if (that == null)
		return false;
	    if (that instanceof execute_args)
		return this.equals((execute_args) that);
	    return false;
	}

	public boolean equals(execute_args that) {
	    if (that == null)
		return false;

	    boolean this_present_functionName = true && this
		    .is_set_functionName();
	    boolean that_present_functionName = true && that
		    .is_set_functionName();
	    if (this_present_functionName || that_present_functionName) {
		if (!(this_present_functionName && that_present_functionName))
		    return false;
		if (!this.functionName.equals(that.functionName))
		    return false;
	    }

	    boolean this_present_funcArgs = true && this.is_set_funcArgs();
	    boolean that_present_funcArgs = true && that.is_set_funcArgs();
	    if (this_present_funcArgs || that_present_funcArgs) {
		if (!(this_present_funcArgs && that_present_funcArgs))
		    return false;
		if (!this.funcArgs.equals(that.funcArgs))
		    return false;
	    }

	    return true;
	}

	@Override
	public int hashCode() {
	    HashCodeBuilder builder = new HashCodeBuilder();

	    boolean present_functionName = true && (is_set_functionName());
	    builder.append(present_functionName);
	    if (present_functionName)
		builder.append(functionName);

	    boolean present_funcArgs = true && (is_set_funcArgs());
	    builder.append(present_funcArgs);
	    if (present_funcArgs)
		builder.append(funcArgs);

	    return builder.toHashCode();
	}

	public int compareTo(execute_args other) {
	    if (!getClass().equals(other.getClass())) {
		return getClass().getName().compareTo(
			other.getClass().getName());
	    }

	    int lastComparison = 0;
	    execute_args typedOther = (execute_args) other;

	    lastComparison = Boolean.valueOf(is_set_functionName()).compareTo(
		    typedOther.is_set_functionName());
	    if (lastComparison != 0) {
		return lastComparison;
	    }
	    if (is_set_functionName()) {
		lastComparison = org.apache.thrift7.TBaseHelper.compareTo(
			this.functionName, typedOther.functionName);
		if (lastComparison != 0) {
		    return lastComparison;
		}
	    }
	    lastComparison = Boolean.valueOf(is_set_funcArgs()).compareTo(
		    typedOther.is_set_funcArgs());
	    if (lastComparison != 0) {
		return lastComparison;
	    }
	    if (is_set_funcArgs()) {
		lastComparison = org.apache.thrift7.TBaseHelper.compareTo(
			this.funcArgs, typedOther.funcArgs);
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
		case 1: // FUNCTION_NAME
		    if (field.type == org.apache.thrift7.protocol.TType.STRING) {
			this.functionName = iprot.readString();
		    } else {
			org.apache.thrift7.protocol.TProtocolUtil.skip(iprot,
				field.type);
		    }
		    break;
		case 2: // FUNC_ARGS
		    if (field.type == org.apache.thrift7.protocol.TType.STRING) {
			this.funcArgs = iprot.readString();
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
	    if (this.functionName != null) {
		oprot.writeFieldBegin(FUNCTION_NAME_FIELD_DESC);
		oprot.writeString(this.functionName);
		oprot.writeFieldEnd();
	    }
	    if (this.funcArgs != null) {
		oprot.writeFieldBegin(FUNC_ARGS_FIELD_DESC);
		oprot.writeString(this.funcArgs);
		oprot.writeFieldEnd();
	    }
	    oprot.writeFieldStop();
	    oprot.writeStructEnd();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("execute_args(");
	    boolean first = true;

	    sb.append("functionName:");
	    if (this.functionName == null) {
		sb.append("null");
	    } else {
		sb.append(this.functionName);
	    }
	    first = false;
	    if (!first)
		sb.append(", ");
	    sb.append("funcArgs:");
	    if (this.funcArgs == null) {
		sb.append("null");
	    } else {
		sb.append(this.funcArgs);
	    }
	    first = false;
	    sb.append(")");
	    return sb.toString();
	}

	public void validate() throws org.apache.thrift7.TException {
	    // check for required fields
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

    public static class execute_result implements
	    org.apache.thrift7.TBase<execute_result, execute_result._Fields>,
	    java.io.Serializable, Cloneable {
	private static final org.apache.thrift7.protocol.TStruct STRUCT_DESC = new org.apache.thrift7.protocol.TStruct(
		"execute_result");

	private static final org.apache.thrift7.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift7.protocol.TField(
		"success", org.apache.thrift7.protocol.TType.STRING, (short) 0);
	private static final org.apache.thrift7.protocol.TField E_FIELD_DESC = new org.apache.thrift7.protocol.TField(
		"e", org.apache.thrift7.protocol.TType.STRUCT, (short) 1);

	private String success; // required
	private DRPCExecutionException e; // required

	/**
	 * The set of fields this struct contains, along with convenience
	 * methods for finding and manipulating them.
	 */
	public enum _Fields implements org.apache.thrift7.TFieldIdEnum {
	    SUCCESS((short) 0, "success"), E((short) 1, "e");

	    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

	    static {
		for (_Fields field : EnumSet.allOf(_Fields.class)) {
		    byName.put(field.getFieldName(), field);
		}
	    }

	    /**
	     * Find the _Fields constant that matches fieldId, or null if its
	     * not found.
	     */
	    public static _Fields findByThriftId(int fieldId) {
		switch (fieldId) {
		case 0: // SUCCESS
		    return SUCCESS;
		case 1: // E
		    return E;
		default:
		    return null;
		}
	    }

	    /**
	     * Find the _Fields constant that matches fieldId, throwing an
	     * exception if it is not found.
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
	    tmpMap.put(
		    _Fields.SUCCESS,
		    new org.apache.thrift7.meta_data.FieldMetaData(
			    "success",
			    org.apache.thrift7.TFieldRequirementType.DEFAULT,
			    new org.apache.thrift7.meta_data.FieldValueMetaData(
				    org.apache.thrift7.protocol.TType.STRING)));
	    tmpMap.put(
		    _Fields.E,
		    new org.apache.thrift7.meta_data.FieldMetaData(
			    "e",
			    org.apache.thrift7.TFieldRequirementType.DEFAULT,
			    new org.apache.thrift7.meta_data.FieldValueMetaData(
				    org.apache.thrift7.protocol.TType.STRUCT)));
	    metaDataMap = Collections.unmodifiableMap(tmpMap);
	    org.apache.thrift7.meta_data.FieldMetaData.addStructMetaDataMap(
		    execute_result.class, metaDataMap);
	}

	public execute_result() {
	}

	public execute_result(String success, DRPCExecutionException e) {
	    this();
	    this.success = success;
	    this.e = e;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public execute_result(execute_result other) {
	    if (other.is_set_success()) {
		this.success = other.success;
	    }
	    if (other.is_set_e()) {
		this.e = new DRPCExecutionException(other.e);
	    }
	}

	public execute_result deepCopy() {
	    return new execute_result(this);
	}

	@Override
	public void clear() {
	    this.success = null;
	    this.e = null;
	}

	public String get_success() {
	    return this.success;
	}

	public void set_success(String success) {
	    this.success = success;
	}

	public void unset_success() {
	    this.success = null;
	}

	/**
	 * Returns true if field success is set (has been assigned a value) and
	 * false otherwise
	 */
	public boolean is_set_success() {
	    return this.success != null;
	}

	public void set_success_isSet(boolean value) {
	    if (!value) {
		this.success = null;
	    }
	}

	public DRPCExecutionException get_e() {
	    return this.e;
	}

	public void set_e(DRPCExecutionException e) {
	    this.e = e;
	}

	public void unset_e() {
	    this.e = null;
	}

	/**
	 * Returns true if field e is set (has been assigned a value) and false
	 * otherwise
	 */
	public boolean is_set_e() {
	    return this.e != null;
	}

	public void set_e_isSet(boolean value) {
	    if (!value) {
		this.e = null;
	    }
	}

	public void setFieldValue(_Fields field, Object value) {
	    switch (field) {
	    case SUCCESS:
		if (value == null) {
		    unset_success();
		} else {
		    set_success((String) value);
		}
		break;

	    case E:
		if (value == null) {
		    unset_e();
		} else {
		    set_e((DRPCExecutionException) value);
		}
		break;

	    }
	}

	public Object getFieldValue(_Fields field) {
	    switch (field) {
	    case SUCCESS:
		return get_success();

	    case E:
		return get_e();

	    }
	    throw new IllegalStateException();
	}

	/**
	 * Returns true if field corresponding to fieldID is set (has been
	 * assigned a value) and false otherwise
	 */
	public boolean isSet(_Fields field) {
	    if (field == null) {
		throw new IllegalArgumentException();
	    }

	    switch (field) {
	    case SUCCESS:
		return is_set_success();
	    case E:
		return is_set_e();
	    }
	    throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
	    if (that == null)
		return false;
	    if (that instanceof execute_result)
		return this.equals((execute_result) that);
	    return false;
	}

	public boolean equals(execute_result that) {
	    if (that == null)
		return false;

	    boolean this_present_success = true && this.is_set_success();
	    boolean that_present_success = true && that.is_set_success();
	    if (this_present_success || that_present_success) {
		if (!(this_present_success && that_present_success))
		    return false;
		if (!this.success.equals(that.success))
		    return false;
	    }

	    boolean this_present_e = true && this.is_set_e();
	    boolean that_present_e = true && that.is_set_e();
	    if (this_present_e || that_present_e) {
		if (!(this_present_e && that_present_e))
		    return false;
		if (!this.e.equals(that.e))
		    return false;
	    }

	    return true;
	}

	@Override
	public int hashCode() {
	    HashCodeBuilder builder = new HashCodeBuilder();

	    boolean present_success = true && (is_set_success());
	    builder.append(present_success);
	    if (present_success)
		builder.append(success);

	    boolean present_e = true && (is_set_e());
	    builder.append(present_e);
	    if (present_e)
		builder.append(e);

	    return builder.toHashCode();
	}

	public int compareTo(execute_result other) {
	    if (!getClass().equals(other.getClass())) {
		return getClass().getName().compareTo(
			other.getClass().getName());
	    }

	    int lastComparison = 0;
	    execute_result typedOther = (execute_result) other;

	    lastComparison = Boolean.valueOf(is_set_success()).compareTo(
		    typedOther.is_set_success());
	    if (lastComparison != 0) {
		return lastComparison;
	    }
	    if (is_set_success()) {
		lastComparison = org.apache.thrift7.TBaseHelper.compareTo(
			this.success, typedOther.success);
		if (lastComparison != 0) {
		    return lastComparison;
		}
	    }
	    lastComparison = Boolean.valueOf(is_set_e()).compareTo(
		    typedOther.is_set_e());
	    if (lastComparison != 0) {
		return lastComparison;
	    }
	    if (is_set_e()) {
		lastComparison = org.apache.thrift7.TBaseHelper.compareTo(
			this.e, typedOther.e);
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
		case 0: // SUCCESS
		    if (field.type == org.apache.thrift7.protocol.TType.STRING) {
			this.success = iprot.readString();
		    } else {
			org.apache.thrift7.protocol.TProtocolUtil.skip(iprot,
				field.type);
		    }
		    break;
		case 1: // E
		    if (field.type == org.apache.thrift7.protocol.TType.STRUCT) {
			this.e = new DRPCExecutionException();
			this.e.read(iprot);
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
	    oprot.writeStructBegin(STRUCT_DESC);

	    if (this.is_set_success()) {
		oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
		oprot.writeString(this.success);
		oprot.writeFieldEnd();
	    } else if (this.is_set_e()) {
		oprot.writeFieldBegin(E_FIELD_DESC);
		this.e.write(oprot);
		oprot.writeFieldEnd();
	    }
	    oprot.writeFieldStop();
	    oprot.writeStructEnd();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("execute_result(");
	    boolean first = true;

	    sb.append("success:");
	    if (this.success == null) {
		sb.append("null");
	    } else {
		sb.append(this.success);
	    }
	    first = false;
	    if (!first)
		sb.append(", ");
	    sb.append("e:");
	    if (this.e == null) {
		sb.append("null");
	    } else {
		sb.append(this.e);
	    }
	    first = false;
	    sb.append(")");
	    return sb.toString();
	}

	public void validate() throws org.apache.thrift7.TException {
	    // check for required fields
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

}