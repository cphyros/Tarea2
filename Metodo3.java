import java.util.ArrayList;

public class Metodo3 {
      private boolean getPath(TreeNode root, ArrayList<String> arr, String x) {
            if(root == null) {
                  return false;
            }

            arr.add(root.val);

            if(root.val == x) {
                  return true;
            }

            if(getPath(root.left, arr, x) || getPath(root.right, arr, x) {
                  return true;
            }

            arr.remove(arr.size() -1);
            return false;
      }

      public String solve (TreeNode A, String B) {
            ArrayList<String> arr = new ArrayList<String>();
            String listString1= String.join("/", arr);
            if(A == null) return listString1;
            getPath(A, arr, B);
            String bueno = String.join("/", arr);
            return bueno;
      }
}
