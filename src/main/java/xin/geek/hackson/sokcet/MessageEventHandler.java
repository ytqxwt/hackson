package xin.geek.hackson.sokcet;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import io.socket.client.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageEventHandler {

    private final SocketIOServer server;
    private static final Logger logger = LoggerFactory.getLogger(MessageEventHandler.class);

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        this.server = server;
    }

    //添加connect事件，当客户端发起连接时调用
    @OnConnect
    public void onConnect(SocketIOClient client) {
        if (client != null) {
            logger.info("连接成功");
        } else {
            System.out.println("客户端为空");
        }
    }

    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        logger.info("客户端断开连接");
        client.disconnect();
    }

    @OnEvent("send")
    public void send(SocketIOClient client, AckRequest ackRequest, Object data) {
       // client.joinRoom(client.getHandshakeData().getSingleUrlParam("userId"));
        logger.info("接到消息" + data);
        if (ackRequest.isAckRequested()) {
            ackRequest.sendAckData("test1", "test2");
        }
    }
    //消息接收入口
    @OnEvent(value = Socket.EVENT_MESSAGE)
    public void onEvent(SocketIOClient client, AckRequest ackRequest, Object data) {
        client.joinRoom("room");
        logger.info("接收到客户端消息");
        logger.info("" + data);
        if (ackRequest.isAckRequested()) {
            // send ack response with data to client
            ackRequest.sendAckData("服务器回答Socket.EVENT_MESSAGE", "好的");
        }
    }

    // 广播消息接收入口
    @OnEvent(value = "broadcast")
    public void onBroadcast(SocketIOClient client, AckRequest ackRequest, Object data) {
        logger.info("接收到广播消息");
        String room = "room";
        server.getRoomOperations(room).sendEvent("broadcast", "广播啦啦啦啦");
    }
}
