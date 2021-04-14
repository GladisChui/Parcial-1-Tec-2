/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Andrea
 */
public class GestorVacunas_gChui {
    private ArrayList<Vacunas_gChui> lista;

    public GestorVacunas_gChui() 
    {
        lista = new ArrayList<Vacunas_gChui>();
    }

    public ArrayList<Vacunas_gChui> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Vacunas_gChui> lista) {
        this.lista = lista;
    }
     
    public void insertarVacuna(Vacunas_gChui item)
    {
      lista.add(item);
    }
    public void modificarVacuna(int pos, Vacunas_gChui item)
    {
      lista.set(pos, item);
    }
    public void eliminarVacuna(int pos)
    {
      lista.remove(pos);
    }
   
    public int obtieneId()
    {
      int idaux=0;
      
      for (Vacunas_gChui item:lista)
      {
          idaux=item.getId();
      }
      return idaux + 1;
    }
    
    public int ubicarProducto(int id)
    {
        int pos=-1;
        Iterator<Vacunas_gChui> it = lista.iterator();
        
        while ( it.hasNext())
        {
            ++pos;
            Vacunas_gChui aux = it.next();
            
            if(aux.getId()==id)
            {
                break;
            }
        }
        return pos;
    }
}
