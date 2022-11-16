public class ArbolGeneralTest {
      public static void main(String[] args) {
            ArbolGeneral a = new ArbolGeneral();

            a.Agregar("", "a"); // La raiz del arbol
            a.Agregar("a", "c"); // Agrega d como hijo de a
            a.Agregar("a", "b"); // Agrega c como Hijo de a
            a.Agregar("a/b", "h"); // Agrega f como hijo de c
            a.Agregar("a/b", "e");
            a.Agregar("a/b/h", "m");
            a.Agregar("a/b/h", "l");
            a.Agregar("a/c", "k");
            a.Agregar("a/c", "j");
            
            
            System.out.println();
            a.Imprimir();
            System.out.println("Altura: " + a.Altura());//PROBLEMA
            System.out.println("Peso: " + a.Peso());
            System.out.println("Path:" + a.Path("m"));//PROBLEMA
            System.out.print("Preorden Iterativo: ");
            a.PreordenIterativo();
            System.out.println();
            System.out.print("Recorrido por Nivel: ");
            a.PorNivel();
            System.out.println();
            a.printInConNivel();
      }
}
