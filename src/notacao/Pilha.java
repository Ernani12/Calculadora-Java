/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package notacao;

import java.util.Vector;

/**
 *
 * @author u10265 
 */
public class Pilha <Tipo>
{
    private Vector<Tipo> e = new Vector<Tipo>();
    private int topo = 0;
   //a Pilha é controlada sempre  pelo  topo do vetor
    // que na v erdade seria um vetor na  vertical.

 
    public int tamanhoPilha()
    {
	    return e.size();
            // retorna o tamanho do vetor da Pilha pelo metodo size()
	}
    
    
    public void empilhe (Tipo info) throws Exception
    {
        this.e.add (info);
        topo++;
        // adiciona um elemento ao topo da pilha passando a informação
    }

    public Tipo espie () throws Exception
    {
        if (this.e.size() == 0)
            throw new Exception ("vazia");
      // espíar o elemento que esta no topo da Pilha  caso ela nao esteja vazia
        return this.e.get (this.e.size()-1);
    }
    
    public Tipo pegaTopo()
    {
    	return e.get(topo-1);
        
        // retorna atraves  do metodo get() do vector pegando o que esta no topo
        // da  pilha de forma a pegar o ultimo, sendo que ultimo de fato é
        // uma posicao anterior a do topo ex: topo é 1, mais o elemento esta no zero
    }
    
    public Tipo desempilhe () throws Exception
    {
        if (this.e.size() == 0)
            throw new Exception ("vazia");
        // tira um elemento do topo da pilha  
        topo--;
        // da mesma forma aqui na hora de  remover, removemos
        //  o elemento anterior do topo, que de fato é pego pelo tamanho do vector -1
        // pois  pega o length
        return this.e.remove(this.e.size()-1);
    }
    
    public Tipo desempilheTudo () throws Exception
    {
        if (this.e.size() == 0)
            throw new Exception ("vazia");
        
        while (!e.isEmpty())    
          topo--;
        // desempilha tudo da  pílha enquanto ela nao for vazia 
        return this.e.remove(this.e.size()-1);
    }
       

    
    public String toString(){
    	String aux="";
    	
   	for (int i=0;i<e.size();i++)
    	  aux += e.get(i);
   
    return aux;
    }
}
    
   
