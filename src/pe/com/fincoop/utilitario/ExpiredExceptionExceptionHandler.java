/**
 * Created with IntelliJ IDEA.
 * User: PROMERO
 * Date: 12/06/13
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */
package pe.com.fincoop.utilitario;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.log4j.Logger;



public class ExpiredExceptionExceptionHandler extends ExceptionHandlerWrapper {
	private static Logger depurador = Logger.getLogger(ExpiredExceptionExceptionHandler.class.getName());
    private ExceptionHandler wrapped;

    public ExpiredExceptionExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
    	FacesContext fc = FacesContext.getCurrentInstance();
        for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
        	ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            String redirectPage = null;
            Throwable t = context.getException();

            try {
                if (t instanceof ViewExpiredException ) {
                	
						
						redirectPage = "/login.jsf";
					
                	
                } else {
                	redirectPage = "/page/error/error.jsf";
                }
            } finally {
                i.remove();
            }

            ExternalContext extContext = fc.getExternalContext();
            String url = extContext.encodeActionURL(fc.getApplication().getViewHandler().getActionURL(fc, redirectPage));
            try {
            	depurador.error(t.getMessage());
            	extContext.redirect(url);

            } catch (IOException ioe) {
            	depurador.error(ioe.getMessage());
                throw new FacesException(ioe);
            } catch (IllegalStateException ioe) {
            	depurador.error(ioe.getMessage());
            	throw new FacesException(ioe);
            }

            break;
        }

        // At this point, the queue will not contain any ViewExpiredEvents. Therefore, let the parent handle them.
        getWrapped().handle();
    }
}

