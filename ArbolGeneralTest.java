public class ArbolGeneralTest {
      public static void main(String[] args) {
            ArbolGeneral a = new ArbolGeneral();

            a.Agregar("", "a"); // La raiz del arbol
            a.Agregar("a", "c"); // Agrega d como hijo de a
            a.Agregar("a", "b"); // Agrega c como Hijo de a
            a.Agregar("a/b", "h"); 
            a.Agregar("a/b", "e");
            a.Agregar("a/b/h", "m");
            a.Agregar("a/b/h", "l");
            a.Agregar("a/c", "k");
            a.Agregar("a/c", "j");
            
            
            System.out.println();
            a.Imprimir();
            System.out.println("Altura: " + a.Altura());
            System.out.println("Peso: " + a.Peso());
            System.out.println("Path:" + a.Path("z"));
            System.out.print("Preorden Iterativo: ");
            a.PreordenIterativo();
            System.out.println();
            System.out.print("Recorrido por Nivel: ");
            a.PorNivel();
            System.out.println();
            a.printInConNivel();
            a.In();
            a.Post();
      }
}
