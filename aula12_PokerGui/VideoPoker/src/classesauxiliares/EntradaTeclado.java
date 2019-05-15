package classesauxiliares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta classe foi desenhada para facilitar a entrada de dados
 * pelo teclado. Basicamente ela implementa funcoes para
 * ler strings, inteiros e doubles. 
 * Ela nao faz verificacoes se o que foi digitado realmente
 * eh o esperado.
 * Todos 
 * @author delamaro
 *
 */
public class EntradaTeclado {
static InputStreamReader isr = new InputStreamReader(System.in);
static BufferedReader br = new BufferedReader(isr);
	
	/**
	 * Le um string digitado pelo teclado, at� que seja pressionado
	 * um enter. Ou seja, le a linha toda.
	 * @return o string que foi digitado pelo usu�rio.
	 * @throws IOException
	 */
	public static String leString() throws ETException {
		String x;
		try {
			x = br.readLine();
		} catch (IOException e) {
			throw new ETException("Erro na leitura do terminal.");
		}
		return x;

	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num inteiro. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor inteiro digitado pelo usu�rio. 
	 * @throws IOException
	 */
	public static int leInt() throws ETException  {
		String x = leString();
		int    xInt;
		
		try {
			 xInt = Integer.parseInt(x);
		} catch(Exception e) {
			throw new ETException("Erro na convers�o para Integer.");
		}
		
		return xInt;
	}

	/**
	 * Le um string do teclado (uma linha toda) e tenta transform�-lo num double. 
	 * Por�m n�o faz qualquer verifica��o sobre a validade do dado digitado.
	 * @return  o valor double digitado pelo usu�rio. 
	 * @throws IOException
	 */

	public static double leDouble() throws ETException {
		String x = leString();
		double xDouble;
		try {
			xDouble = Double.parseDouble(x);
		}catch(Exception e) {
			throw new ETException("Erro na convers�o para Double.");
		}
		return xDouble;

	}
}
