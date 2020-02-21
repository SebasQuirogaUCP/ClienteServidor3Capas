package servidorintermediotask;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        DataOutputStream out;
        DataInputStream in;
        final String serverAdd = "127.0.0.1";
        int puertoServer = 9001;
        Scanner es = new Scanner(System.in);
        String op;
        String n1;
        String n2;
        String info;

        while (true) {
            System.out.println("Ingrese primer numero");
            n1 = es.next();
            System.out.println("Ingrese segundo numero");
            n2 = es.next();
            System.out.println("Ingrese Simbolo de la Operación + - * / pow log");
            op = es.next();

            // Conexion al Servidor
            Socket s = new Socket(serverAdd, puertoServer);
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());

            out.writeUTF(op);
            info = in.readUTF();
            String[] datos = info.split(",");
            String opDir = datos[0];
            int opPuerto = Integer.parseInt(datos[1]);

            System.out.println("Informacion Recibida: " + opDir + " - " + opPuerto);
            s.close();
            System.err.println("Conexion Cerrada con el Servidor Intermedio");

            System.out.println("Iniciando nueva conexión con socket a: " + opDir + " - " + opPuerto);
            s = new Socket(opDir, opPuerto);
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());

            System.out.println("En conexión con servidor de operaciones");
            out.writeUTF(n1 + "," + n2);

            String resp = in.readUTF();
            System.out.println("El resultado de la operación es: " + resp);
            System.out.println("");
            System.out.println("**************************** ");
            System.out.println("");
        }
    }

}
