package dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;

import dominio.Vendedor;

import dominio.Producto;
import dominio.repositorio.RepositorioProducto;
import dominio.repositorio.RepositorioGarantiaExtendida;
import testdatabuilder.ProductoTestDataBuilder;

public class VendedorTest {

	@Test
	public void productoYaTieneGarantiaTest() {
		
		// arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		
		Producto producto = productoTestDataBuilder.build(); 
		
		RepositorioGarantiaExtendida repositorioGarantia = mock(RepositorioGarantiaExtendida.class);
		RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
		
		when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(producto);
		
		Vendedor vendedor = new Vendedor(repositorioProducto, repositorioGarantia);
		
		// act 
		boolean existeProducto = vendedor.tieneGarantia(producto.getCodigo());
		
		//assert
		assertTrue(existeProducto);
	}
	
	@Test
	public void productoNoTieneGarantiaTest() {
		
		// arrange
		ProductoTestDataBuilder productoestDataBuilder = new ProductoTestDataBuilder();
		
		Producto producto = productoestDataBuilder.build(); 
		
		RepositorioGarantiaExtendida repositorioGarantia = mock(RepositorioGarantiaExtendida.class);
		RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
		
		when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(null);
		
		Vendedor vendedor = new Vendedor(repositorioProducto, repositorioGarantia);
		
		// act 
		boolean existeProducto =  vendedor.tieneGarantia(producto.getCodigo());
		
		//assert
		assertFalse(existeProducto);
	}
	@Test 
	public void productoNoCumpleRequisitosVocales(){
		// arrange
				ProductoTestDataBuilder productoestDataBuilder = new ProductoTestDataBuilder().conCodigo("AEO7689");
				
				Producto producto = productoestDataBuilder.build(); 
				RepositorioGarantiaExtendida repositorioGarantia = mock(RepositorioGarantiaExtendida.class);
				RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
				
				when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(producto);
				
				when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(null);
				
				Vendedor vendedor = new Vendedor(repositorioProducto, repositorioGarantia);
				
		// act	
				boolean NotresVocales=  vendedor.cumpleRequisitoGarantia(producto.getCodigo());
		//assert
				assertFalse(NotresVocales);
	}
	@Test 
	public void productoCumpleRequisitosVocales(){
		// arrange
				ProductoTestDataBuilder productoestDataBuilder = new ProductoTestDataBuilder().conCodigo("AEO7689EA");
				
				Producto producto = productoestDataBuilder.build(); 
				RepositorioGarantiaExtendida repositorioGarantia = mock(RepositorioGarantiaExtendida.class);
				RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
				
				when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(producto);
				
				when(repositorioGarantia.obtenerProductoConGarantiaPorCodigo(producto.getCodigo())).thenReturn(null);
				
				Vendedor vendedor = new Vendedor(repositorioProducto, repositorioGarantia);
				
		// act	
				boolean NotresVocales=  vendedor.cumpleRequisitoGarantia(producto.getCodigo());
		//assert
				assertTrue(NotresVocales);
	}
}
