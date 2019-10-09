package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import daos.DaoVentas;
import model.Venta;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
							@ActivationConfigProperty(
				propertyName = "destinationLookup", propertyValue = "java:/jms/colaventas")
		})
public class GestorVenta implements MessageListener {

	@EJB
	DaoVentas daoVentas;
    public void onMessage(Message message) {
        ObjectMessage obj =(ObjectMessage)message;
        Venta venta;
        try {
			venta=(Venta)obj.getObject();
			System.out.println("***********************");
			System.out.println("Enviando Mensaje Venta");
//			System.out.println("libro Titulo: " + libro.getTitulo());
//			System.out.println("Precio: " + libro.getPrecio());
			daoVentas.registrarVenta(venta);
			System.out.println("***********************");
		} catch (JMSException e) {
			e.printStackTrace();
		}

    }

}
