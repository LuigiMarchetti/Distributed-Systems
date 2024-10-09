package tcp.basico;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		try {

			Socket cliente = new Socket("localhost", 8900);

			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

			CardDTO card = new CardDTO();

			card.setTransactionId("PAY");
			card.setCardName("John Doe");
			card.setCardNumber("1234-5678-9876-5432");
			card.setExpirationDate("12/2025");
			card.setTransactionValue(150.75);

			saida.writeObject(card);
			saida.flush();

			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			String data = (String) entrada.readObject();

			// Date data_atual = (Date)entrada.readObject();

			JOptionPane.showMessageDialog(null, data.toString());
			entrada.close();

			System.out.println("Conexão encerrada");
		}

		catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
