import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ArbolGeneral {

      private class NodoArbol {
            String letra;
            NodoArbol hijo;
            NodoArbol hermano;

            NodoArbol(String elNombre, NodoArbol elHijo, NodoArbol elHermano) {
                  letra = elNombre;
                  hijo = elHijo;
                  hermano = elHermano;
            }
      }

      private NodoArbol root;

      public ArbolGeneral() {
            root = null;
      }

      public boolean Agregar(String elPath, String elDato) {
            if (root == null) {
                  root = new NodoArbol(elDato, null, null);
                  return true;
            } else {
                  NodoArbol tmp = buscaNodo(elPath);
                  if (tmp == null)
                        return false;
                  else
                        return AgregaHermano(tmp, elDato);
            }
      }

      private NodoArbol buscaNodo(String elPath) {
            NodoArbol tmp1 = root;
            NodoArbol tmp2 = tmp1;
            StringTokenizer path = new StringTokenizer(elPath, "/");
            String s;
            while (path.hasMoreTokens()) {
                  s = path.nextToken();
                  while (tmp1 != null) {
                        if (s.equalsIgnoreCase(tmp1.letra))
                              break;
                        else {
                              tmp2 = tmp1 = tmp1.hermano;
                        }
                  }
                  if (tmp1 == null)
                        return tmp1;
                  else {
                        tmp2 = tmp1;
                        tmp1 = tmp1.hijo;
                  }
            }
            return tmp2;
      }

      private boolean AgregaHermano(NodoArbol elPadre, String elDato) {
            NodoArbol tmp = elPadre.hijo;
            if (tmp == null) {
                  elPadre.hijo = new NodoArbol(elDato, null, null);
                  return true;
            } else {
                  elPadre.hijo = new NodoArbol(elDato, null, elPadre.hijo);
                  return true;
            }
      }

      

      public class Fila {
            class Nodo {
                  NodoArbol info;
                  Nodo sig;
            }

            private Nodo raiz, fondo;

            public Fila() {
                  raiz = null;
                  fondo = null;
            }

            public boolean isEmpty() {
                  return raiz == null;
            }

            public void insertar(NodoArbol x) {
                  Nodo nuevo = new Nodo();
                  nuevo.info = x;
                  if (raiz == null) {
                        raiz = nuevo;
                        fondo = nuevo;
                  } else {
                        fondo.sig = nuevo;
                        fondo = nuevo;
                  }
            }

            public void imprimir() {
                  Nodo reco = raiz;
                  while (reco != null) {
                        System.out.print(reco.info + "-");
                        reco = reco.sig;
                  }
                  System.out.println();
            }

            public NodoArbol extraer() {
                  if (raiz == null) {
                        return null;
                  } else {
                        NodoArbol informacion = raiz.info;
                        if (raiz == fondo) {
                              raiz = null;
                              fondo = null;
                        } else {
                              raiz = raiz.sig;
                        }
                        return informacion;
                  }
            }
      }

      // Metodo n°1:Calcular la altura del Arbol
      private int altura(NodoArbol root) {
            if (root == null) {
                  return 0;
            }
            return 1 + Math.max(altura(root.hijo), altura(root.hermano));
      }

      public int Altura() {
            return altura(root);
      }

      // Metodo n°2:Calcular el Peso del Arbol
      public int Peso() {
            return peso(root);
      }

      private int peso(NodoArbol n) {
            if (n == null) {
                  return 0;
            } else {
                  return 1 + peso(n.hermano) + peso(n.hijo);
            }
      }

      // Metodo n°3: Retornar camino del objeto
      private boolean getPath(NodoArbol root, ArrayList<String> arr, String x) {
            if (root == null) {
                  return false;
            }

            arr.add(root.letra);
            if (root.letra == x) {
                  return true;
            }

            if (getPath(root.hijo, arr, x) || getPath(root.hermano, arr, x)) {
                  return true;
            }
            arr.remove(arr.size() - 1);
            return false;
      }

      private String path(NodoArbol A, String B) {
            ArrayList<String> arr = new ArrayList<String>();
            getPath(A, arr, B);
            String bueno = String.join("/", arr);
            return bueno;
      }

      public String Path(String o) {
            if (root != null) {
                  return path(root, o);
            }
            return "La raiz esta vacia";

      }

      // Metodo n°6: Recorrido Preorden Iterativo del Arbol
      private void preordenIterativo(NodoArbol root) {
            // crear una pila vacía
            Stack<NodoArbol> pila = new Stack<>();

            NodoArbol actual = root;

            while (!pila.empty() || actual != null) {

                  // si el nodo actual existe, imprimirlo y empujarlo a la pila
                  // luego pasar a su hijo izquierdo
                  if (actual != null) {
                        System.out.print(actual.letra + " ");
                        pila.push(actual);
                        actual = actual.hijo;
                  } else {
                        // de lo contrario, si el nodo actual es nulo, extrae un elemento de
                        // la pila y finalmente establece el nodo actual en su
                        // hermano derecho
                        actual = pila.pop();
                        actual = actual.hermano;
                  }
            }
      }

      public void PreordenIterativo() {
            preordenIterativo(root);
      }

      // Metodo n°7: Imprimir por nivel
      private void pornivel(NodoArbol root) {
            if (root != null) {
                  NodoArbol temp = root;
                  NodoArbol temp2 = null;

                  Fila fila = new Fila();
                  fila.insertar(temp);

                  while (!(fila.isEmpty())) {
                        temp = fila.extraer();
                        System.out.print(temp.letra + "-");

                        if (temp.hijo != null) {
                              temp2 = temp.hijo;
                              fila.insertar(temp2);
                        }

                        while (temp2.hermano != null) {
                              temp2 = temp2.hermano;
                              fila.insertar(temp2);
                        }
                  }
            } else {
                  System.out.println("El arbol esta vacio");
            }
      }

      public void PorNivel() {
            pornivel(root);
      }


      //////METODOS DE PRUEBA\\\\\\\\
      private void printInConNivel(NodoArbol reco, int nivel) {
            if (reco != null) {
                  printInConNivel(reco.hijo, nivel + 1);
                  System.out.print(reco.letra + "(" + nivel + ") - ");
                  printInConNivel(reco.hermano, nivel + 1);
            }
      }

      public void printInConNivel() {
            printInConNivel(root, 0);
            System.out.println();
      }

      private void In(NodoArbol reco) {
            if (reco != null) {
                  In(reco.hijo);
                  System.out.print(reco.letra + "-");
                  In(reco.hermano);
            }
      }

      public void In() {
            In(root);
            System.out.println();
      }

      private void Post(NodoArbol reco) {
            if (reco != null) {
                  Post(reco.hijo);
                  Post(reco.hermano);
                  System.out.print(reco.letra + "-");
            }
      }

      public void Post() {
            Post(root);
            System.out.println();
      }

      public void Imprimir() {
            imprime(root, " ");
      }

      private void imprime(NodoArbol r, String tab) {
            if (r != null) {
                  System.out.println(tab + r.letra);
                  imprime(r.hijo, tab + "  ");
                  imprime(r.hermano, tab);
            }
      }

}
