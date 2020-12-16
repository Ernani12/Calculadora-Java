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

    
 class Fila <Tipo> // a Classe fila Recebe um tipo de dado vindo  
{
    private Vector<Tipo> elems = new Vector<Tipo>();
    private int          fim   = 0;

    public boolean vazia ()
    {
        return this.elems.size()==0;
        // a fila esta  esta vizia  qaundo nao há elementos a partir da posição zero
    }

    public boolean cheia ()
    {
        return false;
    }

    public void enfileire (Tipo info)
    {
        this.elems.add (fim, info);
        this.fim++;
        // enfileira sempre  no fimda fila a informçao adicionando um dado
    }

    public Tipo espie () throws Exception
    {
        if (this.elems.size() == 0)
            throw new Exception ("vazia");

        return this.elems.get (0);
        // sempre espiamos  o primeiro da fila 
    }

    public Tipo desenfileire () throws Exception
    {
        if (this.elems.size() == 0)
            throw new Exception ("vazia");
          //  desemfileire  sempre o  removendo  o primeiro elemento do vector
        // no caso o primeiro da Fila sempre no FIFO.(First in, First out)
        
        this.fim--;
        // removendo aqui do vetor abaixo a primeira posicao
        return this.elems.remove(0);
    }
    
    public String toString()
    {
        String retorno="";
        
    	for (int i=0;i<fim;i++)
    		retorno += elems.get(i)+"";
        
      
        return retorno;
    }
    }
