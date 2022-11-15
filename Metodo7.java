public class Metodo7 {
      public void amplitud(NodoArbol a) // SE RECIBE LA RAIZ DEL ARBOL
      {
            Fila fila, filaAux; // DEFINICIÓN DE 2 VARIABLES DE TIPO COLA
            NodoArbol aux; // DEFINICIÓN AUX DE TIPO NODOARBOL

            if (a != null) // SI EL ÁRBOL CONTIENE NODOS...
            {
                  fila = new Fila(); // SE INSTANCIA EL OBJETO COLA
                  filaAux = new Fila(); // SE INSTANCIA EL OBJETO COLAAUX
                  fila.push(a); // SE INSERTA EL NODOARBOL "A" (RAIZ) COMO PRIMER NODO EN LA COLA
                  while (fila.colavacia() != 1) // MIENTRAS HAYAN ELEMENTOS EN LA COLA...
                  {
                        filaAux.push(aux = fila.pop()); /*
                                                         * EL ELEMENTO EXTRAIDO DE LA COLA PRINCIPAL ES ASIGNADO
                                                         * A AUX Y A SU VEZ INSERTADO EN LA COLA AUXILIAR
                                                         */
                        if (aux.izq != null) // SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                        {
                              fila.push(aux.izq); // SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                        }
                        if (aux.der != null) // SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                        {
                              fila.push(aux.der); // SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                        }
                  }
                  filaAux.print(); // POR ÚLTIMO SE IMPRIME LA COLA AUXILIAR
            }
      }
}
