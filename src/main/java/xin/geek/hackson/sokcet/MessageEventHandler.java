package xin.geek.hackson.sokcet;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
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
            String openId = client.getHandshakeData().getSingleUrlParam("openId");
            logger.info(openId + "已加入");
            String familyRoom = client.getHandshakeData().getSingleUrlParam("familyId");
            client.joinRoom(familyRoom);
            logger.info(openId + "加入家庭群聊" + familyRoom);
            client.joinRoom("bigRoom");
            logger.info(openId + "加入系统群聊");
        } else {
            System.out.println("客户端为空");
        }
    }

    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        String openId = client.getHandshakeData().getSingleUrlParam("openId");
        logger.info(openId + "客户端断开连接");
        client.disconnect();
    }

    @OnEvent("sendTo")
    public void send(SocketIOClient client, AckRequest ackRequest, Object data) {
        String familyRoom = client.getHandshakeData().getSingleUrlParam("familyId");
        for (SocketIOClient client1 : server.getRoomOperations(familyRoom).getClients()) {
            if (client1.getHandshakeData().getSingleUrlParam("openId").equals(client.getHandshakeData().getSingleUrlParam("toOpenId"))) {
                client1.sendEvent("getFrom", data);
            }
        }
        if (ackRequest.isAckRequested()) {
            ackRequest.sendAckData(true);
        }
    }

    @OnEvent("sendToFamily")
    public void sendToFamily(SocketIOClient client, AckRequest ackRequest, Object data) {
        String familyRoom = client.getHandshakeData().getSingleUrlParam("familyId");
        for (SocketIOClient client1 : server.getRoomOperations(familyRoom).getClients()) {
            if (client1.getHandshakeData().getSingleUrlParam("openId").equals(client.getHandshakeData().getSingleUrlParam("toOpenId"))) {
                client1.sendEvent("getFromFamily", data);
            }
        }
        if (ackRequest.isAckRequested()) {
            ackRequest.sendAckData("true");
        }
    }

    // 广播消息接收入口
    @OnEvent(value = "broadcast")
    public void onBroadcast(SocketIOClient client, AckRequest ackRequest, Object data) {
        String room = "bigRoom";
        server.getRoomOperations(room).sendEvent("broadcast", data);
    }
}
