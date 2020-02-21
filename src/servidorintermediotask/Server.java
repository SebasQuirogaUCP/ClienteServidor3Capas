package servidorintermediotask;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        //Server
        ServerSocket server; // Para que escuchar por conexiones del cliente
        Socket S;  // Para enviar datos (direccion, puerto)
        DataInputStream input; // Para recibir datos del cliente
        DataOutputStream output; // Para enviar respuesta del puerto y dirección a Cliente
        final int puertoServer = 9001;
        String infoDir;
        int infoPuerto;

        try {
            server = new ServerSocket(puertoServer);
            System.out.println("Servidor Intermedio escuchando en " + puertoServer);
            while (true) {
                S = server.accept(); // Socket aceptando peticiones al servidor(9001);
                input = new DataInputStream(S.getInputStream());
                output = new DataOutputStream(S.getOutputStream());

                String op = input.readUTF();

                switch (op) {
                    case "+":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9002;
                        System.out.println("Peticion Recibida para la Operación de Suma");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Informacion enviada al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    case "-":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9003;
                        System.out.println("Peticion Recibida para la Operación de Resta");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Información envidad al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    case "*":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9004;
                        System.out.println("Peticion Recibida para la Operación de Multiplicación");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Información enviada al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    case "/":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9005;
                        System.out.println("Peticion Recibida para la Operación de División");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Información enviada al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    case "pow":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9006;
                        System.out.println("Peticion Recibida para la Operación de Pow");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Información enviada al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    case "log":
                        infoDir = "127.0.0.1";
                        infoPuerto = 9007;
                        System.out.println("Peticion Recibida para la Operación de Log");
                        output.writeUTF(infoDir + "," + infoPuerto);
                        System.out.println("Información enviada al Cliente " + infoDir + " - " + infoPuerto);
                        break;
                    default:
                        output.writeUTF("Operación no fue reconocida por el Servidor");

                }

            }

        } catch (IOException err) {
            System.out.println(err);
        }

    }
}
