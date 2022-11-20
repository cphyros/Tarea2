import java.util.*;
class ArbolG
{
private class NodoArbol
  {
    String nombre;
    NodoArbol hijo;
    NodoArbol hermano;
    NodoArbol(String elNombre,NodoArbol elHijo, NodoArbol elHermano)
    { nombre = elNombre; hijo=elHijo; hermano=elHermano;}
  }
 private NodoArbol root;
 public ArbolG(){root=null;}

 void Inorder() { // Implementar 
   inorder(root);
  }
 int Size() {// Implementar
  // Cuenta la cantidad de nodos del Arbol
   return size(root); 
  }  
  
//void Mover(String path1, String path2) Metodo original
 void Mover(String path1, String path2, String elPadre) { 
// Implementar
 // Mover el nodo (y todos sus hijos)  indicado en path1 
 // como hijo del nodo indicado en path2. Dejarlo como 
 // Primer hijo de path2.
 // Para buscar los punteros de los los nodos 
 // use el método privado buscaNodo(String elPath)
 
  
   //NodoArbol p = buscaelPadre(path1); 
   // Implementar usando buscaNodo()
   
   NodoArbol p = buscaNodo(elPadre); //cambiar por buscaelPadre(path1)
   
   NodoArbol n1 = buscaNodo(path1);
   NodoArbol n2 = buscaNodo(path2);
   // Elimina el nodo n1 desde la lista de hijos de p.
   // n1 siempre está en la lista de hijos de p
  if(p.hijo.nombre.equalsIgnoreCase(n1.nombre)) 
     p.hijo = p.hijo.hermano; // se elimina n1 desde la lista de hijos de p 
   else { 
     NodoArbol t1 = p.hijo; 
     NodoArbol t2 = p.hijo; 
     while ( !t1.nombre.equalsIgnoreCase(n1.nombre)) { 
      t2 = t1; t1 = t1.hermano; 
     }
     t2.hermano = t1.hermano; // Se elimina n1 de la lista de hijos de p
    } 
  
  n1.hermano = n2.hijo; // 
  n2.hijo = n1;
  
 }

 void Imprimir() { imprime(root," ");}
 boolean Agregar(String elPath,String elDato)
 {if(root == null) {root = new NodoArbol(elDato,null,null); return true;}
    else { NodoArbol tmp = buscaNodo(elPath);
    if(tmp == null) return false;
    else return AgregaHermano(tmp,elDato);
  }
 }


//============================================== 
// Métodos privados 
//==============================================
 private void inorder(NodoArbol n)
 {
  if(n != null)
  {
    inorder(n.hijo);
    System.out.print("-"+n.nombre);
    NodoArbol t = n.hijo;
    while (t!=null) {t = t.hermano;inorder(t);}
   }
  }
private int size(NodoArbol n) 
 {
  if (n ==null) return 0;
    else return 1 + (size(n.hijo) + size(n.hermano));
 }

 
 
  private NodoArbol buscaNodo(String elPath)
 {
   NodoArbol tmp1= root;
   NodoArbol tmp2 = tmp1;
   StringTokenizer path = new StringTokenizer(elPath,"/");
   String s;
   while(path.hasMoreTokens())
    { s = path.nextToken();
      while(tmp1 !=null)
      {
       if(s.equalsIgnoreCase(tmp1.nombre))  break;
          else {tmp2 = tmp1= tmp1.hermano;}
      }
      if(tmp1 == null) return tmp1;
       else {tmp2 = tmp1;tmp1 = tmp1.hijo;}
     }
     return tmp2;
   }
 
 
 
 private boolean AgregaHermano(NodoArbol elPadre, String elDato)
 {
  NodoArbol tmp=elPadre.hijo;
    if(tmp == null) { elPadre.hijo=new NodoArbol(elDato,null,null); 
                      return true;
                    }
     else {elPadre.hijo = new NodoArbol(elDato,null, elPadre.hijo); 
           return true;
          }
   }
private void imprime(NodoArbol r, String tab)
  {
   if (r!=null)
   { System.out.println(tab + r.nombre);
     imprime(r.hijo, tab +"  "); 
     imprime(r.hermano,tab);
   }  
  } 
 }//Fin clase 
