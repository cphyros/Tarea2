public class ArbolGeneralTest {
      public static void main(String[] args) {
            ArbolGeneral a = new ArbolGeneral();
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
      }
}
