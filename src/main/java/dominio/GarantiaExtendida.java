package dominio;

import java.util.Calendar;
import java.util.Date;

public class GarantiaExtendida {

    private Producto producto;
    private Date fechaSolicitudGarantia;
    private Date fechaFinGarantia;
    private double precioGarantia;
    private String nombreCliente;

    public GarantiaExtendida(Producto producto, String nombreCliente) {
        this.fechaSolicitudGarantia = new Date();
        this.producto = producto;
        this.nombreCliente= nombreCliente;
        this.precioGarantia= DefinirPrecioGarantia(producto.getPrecio());
    }

    public GarantiaExtendida(Producto producto, Date fechaSolicitudGarantia, Date fechaFinGarantia,
            double precioGarantia, String nombreCliente) {

        this.producto = producto;
        this.fechaSolicitudGarantia = fechaSolicitudGarantia;
        this.fechaFinGarantia = fechaFinGarantia;
        this.precioGarantia = precioGarantia;
        this.nombreCliente = nombreCliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public Date getFechaSolicitudGarantia() {
        return fechaSolicitudGarantia;
    }

    public Date getFechaFinGarantia() {
        return fechaFinGarantia;
    }

    public double getPrecioGarantia() {
        return precioGarantia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public double DefinirPrecioGarantia(double precioP){
    	
    	double precioProducto = precioP;
    	double precioGarantia= 0;
    	
    	if(precioProducto <= 500000){
    		precioGarantia= precioProducto*0.10;
    		this.fechaFinGarantia= DefinirFechaFinGarantia(100,this.fechaSolicitudGarantia);
    	}else{
    		precioGarantia= precioProducto*0.20;
    		this.fechaFinGarantia= DefinirFechaFinGarantia(200, this.fechaSolicitudGarantia);
    
    	}
     return precioGarantia;
    }
    
    public Date DefinirFechaFinGarantia(int incremento, Date fechaInicio){
    	Calendar fechaSolicitdGarantia = Calendar.getInstance();
    	fechaSolicitdGarantia.setTime(fechaInicio);
    	Date nuevaFecha;
    	if(incremento == 100){
    		fechaSolicitdGarantia.add(Calendar.DATE, 100);
        	nuevaFecha= fechaSolicitdGarantia.getTime();
        	return nuevaFecha;
    	}else{
    		int i=0;
        	while(i<200){
        		fechaSolicitdGarantia.add(Calendar.DATE,1);
        		if (fechaSolicitdGarantia.get(Calendar.DAY_OF_WEEK) !=1)
        			i++;
        		}
        	
        	if(fechaSolicitdGarantia.get(Calendar.DAY_OF_WEEK) == 0){
        		fechaSolicitdGarantia.add(Calendar.DATE,2);
        		}
         nuevaFecha = fechaSolicitdGarantia.getTime();	
    		return nuevaFecha;
    	}
    	
    }


}
