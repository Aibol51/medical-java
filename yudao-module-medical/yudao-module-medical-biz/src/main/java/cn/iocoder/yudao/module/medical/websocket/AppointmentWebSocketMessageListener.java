package cn.iocoder.yudao.module.medical.websocket;

import cn.iocoder.yudao.framework.websocket.core.listener.WebSocketMessageListener;
import cn.iocoder.yudao.framework.websocket.core.sender.WebSocketMessageSender;
import cn.iocoder.yudao.framework.websocket.core.util.WebSocketFrameworkUtils;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.module.medical.websocket.message.AppointmentCreateMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import jakarta.annotation.Resource;

@Component
public class AppointmentWebSocketMessageListener implements WebSocketMessageListener<AppointmentCreateMessage> {

    @Resource
    private WebSocketMessageSender webSocketMessageSender;

    @Override
    public void onMessage(WebSocketSession session, AppointmentCreateMessage message) {
        // 这里可以处理接收到的消息
    }

    @Override
    public String getType() {
        return "appointment-create";
    }

}