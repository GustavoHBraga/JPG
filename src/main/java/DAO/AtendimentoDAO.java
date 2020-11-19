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
 * @author JPG
 */

//Notação de servidor WebSocket.
@ServerEndpoint("/atendimento")
public class AtendimentoDAO {

    private static Set<Session> usuarios = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
    
    //Método e notação para estabelecer uma nova conexão WebSocket.
    @OnOpen
    public void onOpen(Session session) {
        usuarios.add(session);
    }
    //Método e notação para fechar uma conexão WebSocket.
    @OnClose
    public void onClose(Session session) {
        usuarios.remove(session);
    }
    //Método e notação para enviar dados com WebSocket.
    @OnMessage
    public void onMessage(String mensagem, Session session) {
        for (Session s : usuarios) {
            s.getAsyncRemote().sendText(mensagem);
        }
    }
}
