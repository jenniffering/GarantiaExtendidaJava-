package dominio.unitaria;


import org.junit.Assert;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import dominio.GarantiaExtendida;
import dominio.Producto;
import testdatabuilder.ProductoTestDataBuilder;

public class GarantiaExtendidaTest {
	
	private static final Producto PRODUCTO = new ProductoTestDataBuilder().conCodigo("F01TSA0150").build();
	 private  static String NOMBRECLIENTE = "Jorge Correa";
	 public static final SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd-EEEEE");

	private final GarantiaExtendida garantiaExtendida= new GarantiaExtendida(PRODUCTO,NOMBRECLIENTE);

	@Test
	public void productoPreciodeGrantiaInferior() {	
		double resultado = 40000;
		double precioGarantia = this.garantiaExtendida.DefinirPrecioGarantia(400000);
		Assert.assertEquals(resultado,precioGarantia,0.01);
		
	}
	@Test
	public void productoPrecioGarantiaSuperior(){
		double resultado = 130000;
		double precioGarantia = this.garantiaExtendida.DefinirPrecioGarantia(650000);
		Assert.assertEquals(resultado,precioGarantia,0.01);
	}
	
	@Test
	public void garantia100Dias(){
		Calendar fechaInicio =  Calendar.getInstance();
		fechaInicio.set(2018, 10, 22);
		Date FechaInicio = fechaInicio.getTime();
		Calendar expect =Calendar.getInstance();
		expect.set(2019, 2, 2);
		Date expectFin = expect.getTime();
		
		Date Final= this.garantiaExtendida.DefinirFechaFinGarantia(100,FechaInicio);
		
		Assert.assertEquals(Final,expectFin);
	}
	@Test
	public void garantia200Dias(){
		Calendar fechaInicio =  Calendar.getInstance();
		fechaInicio.set(2018, 7, 16);
		Date FechaInicio = fechaInicio.getTime();
		Calendar expect =Calendar.getInstance();
		expect.set(2019, 3, 6);
		Date expectFin = expect.getTime();
		
		Date Final= this.garantiaExtendida.DefinirFechaFinGarantia(200,FechaInicio);
		
		Assert.assertEquals(Final,expectFin);
	}
	

	
}


