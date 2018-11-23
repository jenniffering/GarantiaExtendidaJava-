package dominio;

import dominio.repositorio.RepositorioProducto;
import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_TIENE_TRESVOCALES = "Este producto no Cuenta con garantia extendida";

    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo, String nombreCliente) {
    	
    	
    	boolean TieneGarantia = tieneGarantia(codigo);
    	boolean cumpleRequisitoGarantia =  cumpleRequisitoGarantia(codigo);
    	 if(TieneGarantia == false){
    		 if(cumpleRequisitoGarantia == true){
    	 Producto producto= repositorioProducto.obtenerPorCodigo(codigo);
    	 GarantiaExtendida garantia = new GarantiaExtendida(producto, nombreCliente);
    	 repositorioGarantia.agregar(garantia);
    		 }else{
    			 throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_TRESVOCALES);
    		 }
    	 } else{
    				 
    		 throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
    	 }
    	}
    

    public boolean tieneGarantia(String codigo) {
    	Producto productoExistente;
    	productoExistente= repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
    	if(productoExistente == null)
    		return false;
    	else 
    		return true;
    	    
    }
    
    public boolean cumpleRequisitoGarantia(String codigo){
    	int contador = 0;
    	for (int x = 0; x <codigo.length(); x++){
    		if((codigo.charAt(x)== 'A') || (codigo.charAt(x)== 'E') || (codigo.charAt(x)== 'I')
    				|| (codigo.charAt(x)== 'O') || (codigo.charAt(x)== 'U')){
    			contador ++;
    		}
    	}
    	if(contador != 3){
    		return true;
    	}else 
    		return false;
    }
    
    
   
}
