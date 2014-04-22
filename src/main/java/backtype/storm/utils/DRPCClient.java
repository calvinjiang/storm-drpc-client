package backtype.storm.utils;

import backtype.storm.generated.DRPCExecutionException;
import backtype.storm.generated.DistributedRPC;

import org.apache.thrift7.TException;
import org.apache.thrift7.protocol.TBinaryProtocol;
import org.apache.thrift7.transport.TFramedTransport;
import org.apache.thrift7.transport.TSocket;
import org.apache.thrift7.transport.TTransport;

public class DRPCClient implements DistributedRPC.Iface {
    private TTransport conn;
    private DistributedRPC.Client client;
    private String host;
    private int port;
    //millisecond
    private Integer timeout;
    
   /* public static void main(String[] args){

	String requestString="{\"blockId\":\"tj0profile\",\"visitor\":{\"userId\":68193589,\"age\":28,\"gender\":1},\"visitedUser\":{\"maxAge\":27,\"userId\":68193589,\"minAge\":21,\"gender\":0},\"beginIndex\":1,\"size\":6}";
	
	try {
	    // 设置调用的服务地址为本地，端口为 7911
	    TSocket socket= new TSocket("172.16.4.193", 3772,2000);
	    TFramedTransport transport =new TFramedTransport(socket);
	    // 设置传输协议为 TBinaryProtocol
	    TBinaryProtocol protocol = new TBinaryProtocol(transport);
	    DistributedRPC.Client client = new DistributedRPC.Client(protocol);
	    transport.open();
	    
	    // 调用服务的 helloVoid 方法
	    String result=client.execute("recommendSimilarUsers",requestString);
	    System.out.println("result:"+result);
	    transport.close();
	} catch (TException e) {
	    e.printStackTrace();
	}catch(DRPCExecutionException e) {
	    e.printStackTrace();
        }
    }*/
   /* public static void main(String[] args){
	HashMap test2Map = new HashMap();
	test2Map.put("minAge", 21);
	test2Map.put("maxAge", 27);
	test2Map.put("gender", 0);
	test2Map.put("userId", 68193589);

	HashMap testMap = new HashMap();
	testMap.put("gender", 1);
	testMap.put("age", 28);
	testMap.put("userId", 68193589);

	RecommedationRequestObject request = new RecommedationRequestObject(
		"tj0profile", testMap, test2Map, 1, 6);
	
	try {
	    // 设置调用的服务地址为本地，端口为 7911
	    TSocket socket= new TSocket("172.16.4.193", 3772,2000);
	    TFramedTransport transport =new TFramedTransport(socket);
	    // 设置传输协议为 TBinaryProtocol
	    TBinaryProtocol protocol = new TBinaryProtocol(transport);
	    DistributedRPC.Client client = new DistributedRPC.Client(protocol);
	    transport.open();
	    
	    // 调用服务的 helloVoid 方法
	    System.out.println(request.toJSONString());
	    String result=client.execute("recommendSimilarUsers","");
	    System.out.println("result:"+result);
	    transport.close();
	} catch (TException e) {
	    e.printStackTrace();
	}catch(DRPCExecutionException e) {
	    e.printStackTrace();
        }
    }*/
    
    public boolean isConnected(){
	return conn!=null && conn.isOpen();
    }

    public DRPCClient(String host, int port, Integer timeout) {
        try {
            this.host = host;
            this.port = port;
            this.timeout = timeout;
            connect();
        } catch(TException e) {
            throw new RuntimeException(e);
        }
    }
    
    public DRPCClient(String host, int port) {
        this(host, port, null);
    }
    
    private void connect() throws TException {
        TSocket socket = new TSocket(host, port);
        if(timeout!=null) {
            socket.setTimeout(timeout);
        }
        conn = new TFramedTransport(socket);
        client = new DistributedRPC.Client(new TBinaryProtocol(conn));
        conn.open();
    }
    
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }   
    
    
    public boolean testRemoteServiceResponse(String func){
        try {
            if(client==null) connect();
            client.execute(func, "");
            return true;
        } catch(TException e) {
            client = null;
            return false;
        } catch(DRPCExecutionException e) {
            client = null;
            return false;
        }
    }
    
    public String execute(String func, String args) throws TException, DRPCExecutionException {
        try {
            if(client==null) connect();
            return client.execute(func, args);
        } catch(TException e) {
            client = null;
            throw e;
        } catch(DRPCExecutionException e) {
            client = null;
            throw e;
        }
    }

    public void close() {
        conn.close();
    }
}