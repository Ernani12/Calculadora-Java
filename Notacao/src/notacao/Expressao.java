/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package notacao;

/**
   
 * @author u10265
 */
public class Expressao {
   // OP code instrucao vem do teclado (mostrar teclado)

private Fila<String> entrada; // MBR recebe a equacao palavra de entrada
private Fila<String> saida; //memory saida   saida do teclado nao estatica
private Pilha<String> p;   // Registrador de operacao (Unidade logica)
private Pilha<String> p2;  // AC e MQ Armazena 

// mobilidade de armazenar na memoria



public Expressao(int e){//Construtor da classe
	entrada = new Fila<String>();
	saida = new Fila<String>();
	
	p  = new Pilha<String>();
	p2 = new Pilha<String>();
        // vem
         
       // 1- IR a refrencia de instrução vem direta do teclado
        //pilhas e saida
        //2-Endereçdamento a Ser lido que fica em memoria
        
         //Dinamicamente de acordo com tamanho da String
        /*  
        Desde pequenos aprendemos a escrever 
        expressões aritméticas em que as operações 
        com dois argumentos são escritas na seguinte ordem: 
        o primeiro argumento, o símbolo de operação, o segundo argumento. 
        Esta maneira de escrever expressões é denominada notação infixa. Um dos problemas que ela apresenta é a necessidade de regras de prioridade e de parênteses para indicar exatamente as operações. 
        Por exemplo, as expressões infixas: 
        5 + 7 * 3      e      ( 5 + 7 ) * 3
        
        A fim de evitar o uso de parênteses, existe uma outra notação, 
        pós-fixa, em a ordem é: o primeiro argumento, o segundo argumento, o 
        símbolo de operação. Por exemplo, as expressões acima seriam escritas nesta notação como:
        5 7 3 * +     e      5 7 + 3 *
        */
        
        // guarda na memoria a espressao
        
        
        
}


public void implementaExpressao(String e){//Coloca expresao no vector(entrada)
	entrada.enfileire(e);//enfileira tudo na MBR
}


public String toString(){//Metodo toString para exibir resultado
	String resposta;

	resposta= ""+ entrada +""; //O vector ficou:

	return resposta;
}




public boolean isNumeric(String str)//Verifica se parametro eh numerico
{
	try//verifica se é numero
	{
	  Double.parseDouble(str);
	  return true;
	}
	catch(Exception e)
	{
	  return false;	
	}
}

//Funcao Adress Joga na pilha
public int qualPrecedencia(String oper) throws Exception//Verifica a precedencia da operacao
{
    //Operacoes de instrucão Mar que força a funcao
	  if(oper.equals("(")) 
		return 0;
	  if(oper.equals("^"))
		return 1;
	  if((oper.equals("*"))||(oper.equals("/")))
		return 2; 
	  if((oper.equals("+"))||(oper.equals("-")))
		return 3;
	  if(oper.equals(")"))
		return 4;
	  else
		throw new Exception("Operacao nao existe");
}


public int ComparaPrec(String str, String c)//Compara qual operacao tem maior ou menor precedencia
{
	// Strings são as instruções , procedencia
      // compara procdencia forçada endereo
	try
	{
	  if(qualPrecedencia(str) > qualPrecedencia(c))
		  return 1;
	  if (qualPrecedencia(str) < qualPrecedencia(c))
		  return 2;
	  if (qualPrecedencia(str) == qualPrecedencia(c))
		  return 3;
	  else
		  return 4;
	}
	catch(Exception e)
	{
	  e.printStackTrace();	
	  return -1;
	}
}
  
public void  RetornaVetorString(String ex){  
  String[] string = new String[1];  
     //;   
    // System.out.println(string[0]);
     //System.out.println(string);
        
     string[0]=ex;
  //   System.out.println(string[0]);
    // System.out.println(string);
  
}  
// Jogar no Adress  de acordo com as instrucao
// Compara as expressoes logicas  de Adress
//Joga espresao de memoria para saida
public String transformaPosFixa() throws Exception{// expressao infixa em posfixa
	while (!entrada.vazia()) // se entrada de dados da memoria
	{	
	 if (isNumeric(entrada.espie()))//se for numerico ira direto p/ saida
	 {
		 saida.enfileire(entrada.desenfileire());
	 }
	 else
	 {
	  if (p.tamanhoPilha()==0)//pilha vazia, empilha a operacao
	  {
	    	p.empilhe(entrada.desenfileire());
	  }
	  else // entrara se a pilha nao estiver vazia
	  {	  
		  if (ComparaPrec(p.pegaTopo(),entrada.espie())==1)
		  {
			  p.empilhe(entrada.desenfileire());
		  }
		  else
		  {
		   if (ComparaPrec(p.pegaTopo(),entrada.espie())==2)
		   {
			 if((p.pegaTopo().equals("(")))	 
			   p.empilhe(entrada.desenfileire());
			 else
			 {
				if (entrada.espie().equals(")"))
				{
				   while (!p.pegaTopo().equals("("))	
					saida.enfileire(p.desempilhe());
				   
				   p.desempilhe();
				   entrada.desenfileire();
				}
				else
				{
				 while ((p.tamanhoPilha()!=0)&&(!p.pegaTopo().equals("("))) 
				  saida.enfileire(p.desempilhe());
				  
				 p.empilhe(entrada.desenfileire());
				}
			 }
		   }
		   else
		   {	   
		     if (ComparaPrec(p.pegaTopo(),entrada.espie())==3)
		     {
		    	if (p.espie().equals("("))
		    		p.empilhe(entrada.desenfileire());
		    	else
		    	{
				  saida.enfileire(p.desempilhe());
			      p.empilhe(entrada.desenfileire());
		    	}
		     }

		   }
		  }
			

	  }
	 } 
	 
	}
	
	while (p.tamanhoPilha()!=0)
	{
	  if((p.pegaTopo().equals(")"))||(p.pegaTopo().equals("(")))
		   p.desempilhe();
	  else
		   saida.enfileire(p.desempilhe());
	}
	
	return ""+saida; //Expressao posFixa: 
        // Joga a saida da expressao
}

public double retornaResultado() throws NumberFormatException, Exception
{
    double retorno = 0;
    double num1    = 0;
    double num2    = 0;
    double aux     = 0;
    String oper = "";    
	
	while (!saida.vazia())
	{// verifica se saida é numero
		if (isNumeric(saida.espie()))
		{
                    // empilha as operacoes de saida
			p2.empilhe(saida.desenfileire());
		}
		else
		{
                    // verifica se é numero para jogar saida
                    // e  qual é processo a ser feito
			if (p2.tamanhoPilha() != 0)
			{
			num2 = Double.parseDouble(p2.desempilhe());
			
			if (p2.tamanhoPilha() != 0)
				num1 = Double.parseDouble(p2.desempilhe());
			
			if (saida.espie().equals("+"))
			    retorno = num1 + num2;
			
			if (saida.espie().equals("-"))
				retorno = num1 - num2;
			
			if (saida.espie().equals("*"))
				retorno = num1 * num2;
			
			if (saida.espie().equals("/"))
				retorno = num1 / num2;
			
			if (saida.espie().equals("^"))
			{
				aux = num1;
				for (int i=1;i < num2;i++)
				 num1 = num1 * aux;
			   
			   retorno = num1;
			}
			
			saida.desenfileire();
			
			p2.empilhe(retorno+"");
			
		}
		}
	}
	//System.out.println(entrada);
	//System.out.println(saida);
        System.out.println(p);
       //System.out.println(p2);

	return retorno;
}

}



