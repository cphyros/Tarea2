public class Metodo2 {
      private void Peso(Nodo reco) {
            if (reco != null) {
                  cantidad++;
                  retornarCantidad(reco.izq);
                  retornarCantidad(reco.der);
            }
      }

      public int Peso() {
            cantidad = 0;
            Peso(raiz);
            return cantidad;
      }
}
