package servidorintermediotask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Divi {

    public static void main(String[] args) throws IOException {
        final int puertoSuma = 9005;
        ServerSocket serverSuma = new ServerSocket(puertoSuma);
        while (true) {
            System.out.println("Servidor División Escuchando");
            Socket s = serverSuma.accept();
            System.out.println("CLIENTE CONECTADO A SERVIDOR DIVISION");
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            String datos = in.readUTF();
            String[] temp = datos.split(",");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);
            String resp = String.valueOf(n1/n2);
            System.out.println("DATOS ENVIADOS AL CLIENTE");
            out.writeUTF(resp);
            
            s.close();
        }
    }
}
