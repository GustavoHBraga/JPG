package DAO;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Miguel Castro
 */
@ServerEndpoint("/atendimento")
public class AtendimentoDAO {

    private static Set<Session> usuarios = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());

    @OnOpen
    public void onOpen(Session session) {
        usuarios.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        usuarios.remove(session);
    }

    @OnMessage
    public void onMessage(String mensagem, Session session) {
        for (Session s : usuarios) {
            s.getAsyncRemote().sendText(mensagem);
        }
    }
}
