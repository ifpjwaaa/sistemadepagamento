

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Testedosistema {

	@Test

	
	public void test() {
	
		
	//Fatura de 1.500,00 com 3 boletos no valor de500,00, 400,00 e 600,00	
		//Fatura marcada como PAGATrês pagamentos do tipo BOLETO criados

		
		double valor1 = 500;
		double valor2 = 400;
		double valor3 =600;
		
		
		double valoresperado = 1500; 
		
		if (valoresperado == 1500){ 
			System.out.println("TESTE 1");
			System.out.println("FATURA PAGA");
			System.out.println("---------------------------------");
		}

		

double retornoFeito = calculos.ExecutaCalculo(valor1, valor2,valor3);
assertEquals(valoresperado, retornoFeito,0);
		
		
		
	}
	
	


	@Test
	public void test2() {
	
		
		
		//Fatura de 1.500,00 com 3 boletos no valor de
		//1000,00, 500,00 e 250,00
		//Fatura marcada como PAGA
		//Três pagamentos do tipo BOLETO criados
		//Um crédito de 250,00

		double valordafatura = 1500;
		
		int quantidadeboletoscriados= 3;
		
		assertEquals(3,quantidadeboletoscriados);
		
		double valor1 = 1000;
		double valor2 = 500;
		double valor3 =250;
		
		double creditogerado = 250;
		
		if((valor1+valor2+valor3) >= valordafatura){
			System.out.println("TESTE 2");
			System.out.println("FATURA PAGA");
			System.out.println("CREDITO GERADO DE " +creditogerado);
			System.out.println(quantidadeboletoscriados + " Pagamentos Criados Tipo BOLETO");

		}

double retornoFeito2 = calculos.ExecutaCalculo2(valor1, valor2,valor3,valordafatura);
assertEquals(creditogerado, retornoFeito2,0);
		
	}
	
	
	
	
	
	//Fatura de 2.000,00 com 2 boletos no valor de
	//500,00 e 400,00
//Fatura marcada como NAO-PAGA
	//Dois pagamentos do tipo BOLETO criados
	
	@Test
	public void test3() {
		
		double valordafatura = 2000;
		 
		double valor1 = 500;
		double valor2 = 400;
		
int quantidadeboletoscriados= 2;
		
		assertEquals(2,quantidadeboletoscriados);
		
		double valorEsperado = valordafatura <= valor1 + valor2 ? 2000 : 900;
		 
		if((valor1+valor2) < valordafatura){	
			System.out.println("---------------------------------");
			System.out.println("TESTE 3");
			System.out.println("FATURA não PAGA");
			System.out.println(quantidadeboletoscriados + " Pagamentos Criados Tipo BOLETO");
		
		}
		
		double retornoFeito2 = calculos.ExecutaCalculo3(valor1, valor2,valordafatura);
		assertEquals(valorEsperado, retornoFeito2,0);		
		
	
	}

}
