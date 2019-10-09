package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.Pedido;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
							@ActivationConfigProperty(
				propertyName = "destinationLookup", propertyValue = "java:/jms/colatest")
		})
public class ProcesaPedido implements MessageListener {

    public void onMessage(Message message) {
        ObjectMessage obj =(ObjectMessage)message;
        Pedido pedido;
        try {
			pedido=(Pedido)obj.getObject();
			System.out.println("***********************");
			System.out.println("Enviando Mensaje");
			System.out.println("Producto: " + pedido.getProducto());
			System.out.println("Precio: " + pedido.getPrecio());
			System.out.println("***********************");
		} catch (JMSException e) {
			e.printStackTrace();
		}

    }

}
