package tcp.basico;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class Servidor {
	  public static void main(String[] args) {
	    try {
	      
	    	// Instancia o ServerSocket ouvindo a porta 8900
	      ServerSocket servidor = new ServerSocket(8900);
	      System.out.println("Servidor ouvindo a porta 8900");
	    
	      while(true) {
	        // o método accept() bloqueia a execução até que
	        // o servidor receba um pedido de conexão
	        Socket cliente = servidor.accept();
	       
	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

			
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

			CardDTO receivedCard = (CardDTO) entrada.readObject();

			String response = generateResponse(receivedCard);
	       
	        saida.writeObject(response);
	        saida.flush();
	        
			entrada.close();
	        saida.close();
	        cliente.close();
	      }  
	    }   
	    catch(Exception e) {    
	    	System.out.println("Erro: " + e.getMessage());
	    }
	      
	  }

	  public static String generateResponse(CardDTO cardDTO) {
		StringBuffer sb = new StringBuffer();

		sb.append(cardDTO.getSerialversionuid());
		sb.append(":");
		sb.append(cardDTO.getCardName());
		sb.append(":");
		String lastFourDigits = cardDTO.getCardNumber().substring(cardDTO.getCardNumber().length() - 4);
		sb.append(lastFourDigits);
		sb.append(":");
		sb.append(cardDTO.getExpirationDate());
		sb.append(":");
		sb.append(cardDTO.getTransactionValue());
		sb.append(":");
		DecimalFormat df = new DecimalFormat("#.00");
		sb.append(df.format(cardDTO.getTransactionValue() * 0.95));

		return sb.toString();
	  }
	}
